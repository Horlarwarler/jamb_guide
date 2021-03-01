package com.offline.jambguide.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.offline.jambguide.R;
import com.offline.jambguide.databinding.FragmentQuestionCategoryBinding;

import static com.offline.jambguide.Constant.PDF;


public class PastQuestionCategory extends Fragment {

    public static AdRequest adRequest;
    FragmentQuestionCategoryBinding fragmentQuestionCategoryBinding;
    NavController navController;
    AdView mAdView;
    private InterstitialAd mInterstitialAd;

    public PastQuestionCategory() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentQuestionCategoryBinding = FragmentQuestionCategoryBinding.inflate(inflater, container, false);


        return fragmentQuestionCategoryBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdView = (AdView) view.findViewById(R.id.banner_AdView);
        mAdView.loadAd(new AdRequest.Builder().build());
        navController = Navigation.findNavController(view);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId(getString(R.string.admob_interstitial_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        AppCompatTextView[] pdflist;
        pdflist = new AppCompatTextView[]{
                fragmentQuestionCategoryBinding.mathematics, fragmentQuestionCategoryBinding.irs,
                fragmentQuestionCategoryBinding.english, fragmentQuestionCategoryBinding.biology,
                fragmentQuestionCategoryBinding.physics, fragmentQuestionCategoryBinding.chemistry,
                fragmentQuestionCategoryBinding.commerce, fragmentQuestionCategoryBinding.literature,
                fragmentQuestionCategoryBinding.goverment, fragmentQuestionCategoryBinding.economics,
                fragmentQuestionCategoryBinding.account, fragmentQuestionCategoryBinding.crs
        };
        for (AppCompatTextView pdf : pdflist) {
            pdf.setOnClickListener(v -> {

                String pdf_selected;
                pdf_selected = pdf.getText().toString();
                Bundle args = new Bundle();
                args.putString(PDF, pdf_selected);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "EORORORJJRRNRN");
                }

                navController.navigate(R.id.navigate_past_question, args);


            });

        }
        fragmentQuestionCategoryBinding.backArrow.setOnClickListener(v -> {
            requireActivity().onBackPressed();
        });


    }
}