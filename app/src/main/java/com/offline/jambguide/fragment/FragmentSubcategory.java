package com.offline.jambguide.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.snackbar.Snackbar;
import com.offline.jambguide.AppController;
import com.offline.jambguide.Constant;
import com.offline.jambguide.R;
import com.offline.jambguide.activity.QuizActivity;
import com.offline.jambguide.activity.SettingActivity;
import com.offline.jambguide.helper.CircleImageView;
import com.offline.jambguide.helper.SettingsPreferences;
import com.offline.jambguide.model.SubCategory;

import java.util.ArrayList;

import static com.offline.jambguide.fragment.FragmentPlay.loadRewardedVideoAd;

public class FragmentSubcategory extends Fragment {
    ArrayList<SubCategory> mListItem;
    AdView mAdView;
    TextView txtblanklist, tvTitle;
    CoordinatorLayout layout;
    ImageView back, setting;
    private RecyclerView recyclerView;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_category, container, false);
        // ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.select_subcategory));

        mAdView = (AdView) view.findViewById(R.id.banner_AdView);
        mAdView.loadAd(new AdRequest.Builder().build());
        txtblanklist = (TextView) view.findViewById(R.id.txtblanklist);
        txtblanklist.setText("sub category not available");
        recyclerView = (RecyclerView) view.findViewById(R.id.category_recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        layout = (CoordinatorLayout) view.findViewById(R.id.layout);
        back = (ImageView) view.findViewById(R.id.back);
        setting = (ImageView) view.findViewById(R.id.setting);
        tvTitle = (TextView) view.findViewById(R.id.tvLevel);
        tvTitle.setText(getString(R.string.select_subcategory));
        mListItem = new ArrayList<>();
        getdata();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
                if (getActivity().getSupportFragmentManager().getBackStackEntryCount() == 0) {

                    try {
                        AppController.StopSound();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SettingsPreferences.getSoundEnableDisable(getActivity())) {
                    Constant.backSoundonclick(getActivity());
                }
                if (SettingsPreferences.getVibration(getActivity())) {
                    Constant.vibrate(getActivity(), Constant.VIBRATION_DURATION);
                }
                Intent playQuiz = new Intent(getActivity(), SettingActivity.class);
                startActivity(playQuiz);
                getActivity().overridePendingTransition(R.anim.open_next, R.anim.close_next);
            }
        });

        return view;
    }

    private void getdata() {


        mListItem = QuizActivity.DBHelper.getSubCategoryById(Constant.categoryId);
        if (mListItem.size() == 0) {
            txtblanklist.setVisibility(View.VISIBLE);
            txtblanklist.setText("sub category not available");

            setSnackBar(layout);

        }
        SubCategoryAdapter subcategoryAdapter = new SubCategoryAdapter(getActivity(), mListItem);
        recyclerView.setAdapter(subcategoryAdapter);

        mAdView.setVisibility(View.GONE);

    }

    public void setSnackBar(View coordinatorLayout) {
        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, "No internet connection!", Snackbar.LENGTH_INDEFINITE)
                .setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getdata();
                    }
                });

        snackbar.setActionTextColor(Color.RED);

        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        snackbar.show();
    }

    public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.ItemRowHolder> {
        private final ArrayList<SubCategory> dataList;
        private final Context mContext;
        public FragmentLock fragmentlock = new FragmentLock();

        public SubCategoryAdapter(Context context, ArrayList<SubCategory> dataList) {
            this.dataList = dataList;
            this.mContext = context;
        }

        @Override
        public SubCategoryAdapter.ItemRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_category, parent, false);
            return new ItemRowHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull SubCategoryAdapter.ItemRowHolder holder, final int position) {
            txtblanklist.setVisibility(View.GONE);
            final SubCategory singleItem = dataList.get(position);
            holder.text.setText(singleItem.getName());

            holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Constant.subCategoryId = singleItem.getId();
                    loadRewardedVideoAd();
//                     Constant.totalLevel = singleItem.getTotallevel();


                    FragmentTransaction ft = ((QuizActivity) mContext).getSupportFragmentManager().beginTransaction();
                    //ft.setCustomAnimations(R.anim.open_next, R.anim.close_next);
                    //ft.replace(R.id.fragment_container, fragmentlock, "fragment");
                    //ft.addToBackStack("tag");
                    //ft.commit();
                    ft.hide(getFragmentManager().findFragmentByTag("subcategoryfragment"));
                    ft.add(R.id.fragment_container, fragmentlock, "fragmentlock");
                    ft.addToBackStack(null);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.commit();
                }
            });
        }

        @Override
        public int getItemCount() {
            return (null != dataList ? dataList.size() : 0);
        }

        public class ItemRowHolder extends RecyclerView.ViewHolder {
            public CircleImageView image;
            public TextView text;
            RelativeLayout relativeLayout;

            public ItemRowHolder(View itemView) {
                super(itemView);
                image = (CircleImageView) itemView.findViewById(R.id.imgcategory);
                text = (TextView) itemView.findViewById(R.id.item_title);
                relativeLayout = (RelativeLayout) itemView.findViewById(R.id.cat_layout);
            }
        }
    }
}