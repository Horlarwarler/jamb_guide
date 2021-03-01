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
import com.offline.jambguide.databinding.FragmentPractiseQuestionBinding;

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
import static com.offline.jambguide.Constant.PAST;
import static com.offline.jambguide.Constant.PDF;
import static com.offline.jambguide.Constant.PHYSICS;


public class pastQuestion extends Fragment {

    FragmentPractiseQuestionBinding FragmentPractiseQuestion;
    String url;
    InterstitialAd mIntersitialAd;

    String pdf_selected;

    public pastQuestion() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            pdf_selected = getArguments().getString(PDF);
        }

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentPractiseQuestion = FragmentPractiseQuestionBinding.inflate(inflater, container, false);
        return FragmentPractiseQuestion.getRoot();        // I hate finiding id anytime am calliign this Inflate the layout for this fragment
    }


    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        switch (pdf_selected) {
            case BIOLOGY:
                url = "Biology_pst.pdf";
                break;
            case PHYSICS:
                url = "Physics_pst.pdf";
                break;
            case CRS:
                url = "Crk_pst.pdf";
                break;
            case MATHEMATICS:
                url = "Mathematics_pst.pdf";
                break;
            case GOVERNMENT:
                url = "Government_pst.pdf";
                break;
            case COMMERCE:
                url = "Commerce_pst.pdf";
                break;
            case ACCOUNT:
                url = "Accounts_pst.pdf";
                break;
            case CHEMISTRY:
                url = "Chemistry_pst.pdf";
                break;
            case LITERATURE:
                url = "Literature_pst.pdf";
                break;
            case ECONOMICS:
                url = "Economics_pst.pdf";
                break;
            case IRS:
                url = "Irs_pst.pdf";
                break;

            default:
                url = "English_pst.pdf";

        }

        FragmentPractiseQuestion.practiseQuestionPdf.fromAsset(url)
                .scrollHandle(null)
                .enableDoubletap(true)
                .swipeHorizontal(true)
                .load();
        String pst_title;
        pst_title = pdf_selected + PAST;
        FragmentPractiseQuestion.pstquestion.setText(pst_title);

        mIntersitialAd = new InterstitialAd(getActivity());
        mIntersitialAd.setAdUnitId(getString(R.string.admob_interstitial_id));
        mIntersitialAd.loadAd(new AdRequest.Builder().build());

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        FragmentPractiseQuestion.backArrow.setOnClickListener(view -> {
            if (mIntersitialAd.isLoaded()) {
                mIntersitialAd.show();
            } else {
                Log.d("TAG", "Network Errow: ");
            }

            requireActivity().onBackPressed();
        });


    }
}