package com.offline.jambguide.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.offline.jambguide.R;
import com.offline.jambguide.databinding.FragmentJambSyllabusBinding;

///this contains the pdf to display for each subjects


public class jambSyllabus extends Fragment {
    jambSyllabus Jambsyllabus;


    FragmentJambSyllabusBinding fragmentJambSyllabusBinding;

    public jambSyllabus() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_syllabus_category, container, false);
        fragmentJambSyllabusBinding = FragmentJambSyllabusBinding.inflate(inflater,container,false);

        return fragmentJambSyllabusBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable  Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SyllabusCategory previousFrag = new SyllabusCategory();
        fragmentJambSyllabusBinding.backArrow.setOnClickListener(v ->{
            getActivity().getSupportFragmentManager().beginTransaction()
           .replace(R.id.syllabus_category, previousFrag, "findThisFragment")
                    .addToBackStack(null)
                    .commit();
        });
        fragmentJambSyllabusBinding.jambSyllabusPdf.fromAsset("jamb_syllabus.pdf").show();

    }
}