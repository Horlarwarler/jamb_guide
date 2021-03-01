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
import com.offline.jambguide.databinding.FragmentSyllabusCategoryBinding;

import static com.offline.jambguide.Constant.PDF;
import static com.offline.jambguide.Constant.TITLE;


public class SyllabusCategory extends Fragment {
    AdView mAdView;
    InterstitialAd mInterstitialAd;

    //this list out the subjects
    FragmentSyllabusCategoryBinding fragmentSyllabusCategoryBinding;
    NavController navController;

    public SyllabusCategory() {
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
        //return inflater.inflate(R.layout.fragment_syllabus_category, container, false);
        fragmentSyllabusCategoryBinding = FragmentSyllabusCategoryBinding.inflate(inflater, container, false);
        //AppCompatTextView[] pdflist = new AppCompatTextView[]{fragmentSyllabusCategoryBinding.mathematics, fragmentSyllabusCategoryBinding.english, fragmentSyllabusCategoryBinding.biology, fragmentSyllabusCategoryBinding.physics, fragmentSyllabusCategoryBinding.chemistry,fragmentSyllabusCategoryBinding.commerce};
        return fragmentSyllabusCategoryBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        mAdView = (AdView) view.findViewById(R.id.banner_AdView);
        mAdView.loadAd(new AdRequest.Builder().build());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fragmentSyllabusCategoryBinding.backArrow.setOnClickListener(v -> {
            requireActivity().onBackPressed();
        });


        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId(getString(R.string.admob_interstitial_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        AppCompatTextView[] pdflist = new AppCompatTextView[]{
                fragmentSyllabusCategoryBinding.mathematics, fragmentSyllabusCategoryBinding.irs,
                fragmentSyllabusCategoryBinding.english, fragmentSyllabusCategoryBinding.biology,
                fragmentSyllabusCategoryBinding.physics, fragmentSyllabusCategoryBinding.chemistry,
                fragmentSyllabusCategoryBinding.commerce, fragmentSyllabusCategoryBinding.literature,
                fragmentSyllabusCategoryBinding.goverment, fragmentSyllabusCategoryBinding.economics,
                fragmentSyllabusCategoryBinding.account, fragmentSyllabusCategoryBinding.crs
        };
        for (AppCompatTextView pdf : pdflist) {
            pdf.setOnClickListener(v -> {
                String pdf_selected;

                pdf_selected = pdf.getText().toString();

                Bundle args = new Bundle();
                args.putString(PDF, pdf_selected);
                args.putString(TITLE, pdf.getText().toString());

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "EORORORJJRRNRN");
                }
                navController.navigate(R.id.jambSyllabus2, args);


            });


        }

    }


}