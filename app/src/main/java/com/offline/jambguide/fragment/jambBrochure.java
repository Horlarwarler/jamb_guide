package com.offline.jambguide.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.offline.jambguide.databinding.FragmentJambBrochureBinding;


public class jambBrochure extends Fragment {

    FragmentJambBrochureBinding FragmentJambBrochure;

    public jambBrochure() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentJambBrochure = FragmentJambBrochureBinding.inflate(inflater,container,false);
        return FragmentJambBrochure.getRoot();        // I hate finiding id anytime am calliign this Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_jamb_brochure, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentJambBrochure.backArrow.setOnClickListener(v ->{
            requireActivity().onBackPressed();
        });
        FragmentJambBrochure.jambBrochurePdf.fromAsset("jamb_syllabus.pdf").show();
    }
}