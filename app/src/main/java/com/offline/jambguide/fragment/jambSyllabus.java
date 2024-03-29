package com.offline.jambguide.fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.offline.jambguide.R;
import com.offline.jambguide.databinding.FragmentJambSyllabusBinding;

import static com.offline.jambguide.Constant.ACCOUNT;
import static com.offline.jambguide.Constant.BIOLOGY;
import static com.offline.jambguide.Constant.CHEMISTRY;
import static com.offline.jambguide.Constant.COMMERCE;
import static com.offline.jambguide.Constant.CRS;
import static com.offline.jambguide.Constant.ECONOMICS;
import static com.offline.jambguide.Constant.GOVERNMENT;
import static com.offline.jambguide.Constant.IRS;
import static com.offline.jambguide.Constant.LITERATURE;
import static com.offline.jambguide.Constant.MATHEMATICS;
import static com.offline.jambguide.Constant.PDF;
import static com.offline.jambguide.Constant.PHYSICS;
import static com.offline.jambguide.Constant.SYLLABUS;
import static com.offline.jambguide.Constant.TITLE;

///this contains the pdf to display for each subjects


public class jambSyllabus extends Fragment {
    String url;
    String pdf_selected, title;
    InterstitialAd mIntersitialAd;

    FragmentJambSyllabusBinding fragmentJambSyllabusBinding;

    public jambSyllabus() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            pdf_selected = getArguments().getString(PDF);
            title = getArguments().getString(TITLE);

        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentJambSyllabusBinding = FragmentJambSyllabusBinding.inflate(inflater, container, false);

        return fragmentJambSyllabusBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String pdftitle;
        pdftitle = title + SYLLABUS;
        fragmentJambSyllabusBinding.title.setText(pdftitle);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        switch (pdf_selected) {
            case BIOLOGY:
                url = "Biology.pdf";
                break;
            case PHYSICS:
                url = "Physics.pdf";
                break;
            case CRS:
                url = "Crs.pdf";
                break;
            case MATHEMATICS:
                url = "Mathematics.pdf";
                break;
            case GOVERNMENT:
                url = "Government.pdf";
                break;
            case COMMERCE:
                url = "Commerce.pdf";
                break;
            case ACCOUNT:
                url = "Account.pdf";
                break;
            case CHEMISTRY:
                url = "Chemistry.pdf";
                break;
            case LITERATURE:
                url = "Literature.pdf";
                break;
            case ECONOMICS:
                url = "Economics.pdf";
                break;
            case IRS:
                url = "Irs.pdf";
                break;

            default:
                url = "English.pdf";

        }
        mIntersitialAd = new InterstitialAd(getActivity());
        mIntersitialAd.setAdUnitId(getString(R.string.admob_interstitial_id));
        mIntersitialAd.loadAd(new AdRequest.Builder().build());


        fragmentJambSyllabusBinding.jambSyllabusPdf.fromAsset(url)
                .swipeHorizontal(true)
                .enableDoubletap(true)
                .load();
        fragmentJambSyllabusBinding.backArrow.setOnClickListener(v -> {
            if (mIntersitialAd.isLoaded()) {
                mIntersitialAd.show();
            } else {
                Log.d("TAG", "Network Errow: ");
            }
            requireActivity().onBackPressed();
        });
    }
}