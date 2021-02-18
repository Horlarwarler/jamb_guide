package com.offline.jambguide.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.offline.jambguide.databinding.FragmentPractiseQuestionBinding;

public class practiseQuestion extends Fragment {
    FragmentPractiseQuestionBinding FragmentPractiseQuestion;



    public practiseQuestion() {
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

        FragmentPractiseQuestion = FragmentPractiseQuestionBinding.inflate(inflater, container,false);
        return FragmentPractiseQuestion.getRoot();
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_practise_question, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentPractiseQuestion.backArrow.setOnClickListener(v->{
            requireActivity().onBackPressed();
        });
        FragmentPractiseQuestion.practiseQuestionPdf.fromAsset("jamb_syllabus.pdf").show();
    }

}