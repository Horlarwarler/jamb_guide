package com.offline.jambguide.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.offline.jambguide.R;
import com.offline.jambguide.databinding.FragmentSyllabusCategoryBinding;


public class SyllabusCategory  extends Fragment implements View.OnClickListener {
    SyllabusCategory syllabusCategory;

    //this list out the subjects
FragmentSyllabusCategoryBinding fragmentSyllabusCategoryBinding;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_syllabus_category, container, false);
        fragmentSyllabusCategoryBinding = FragmentSyllabusCategoryBinding.inflate(inflater,container,false);
        AppCompatTextView[] pdflist = new AppCompatTextView[]{fragmentSyllabusCategoryBinding.mathematics, fragmentSyllabusCategoryBinding.english, fragmentSyllabusCategoryBinding.biology, fragmentSyllabusCategoryBinding.physics, fragmentSyllabusCategoryBinding.chemistry,fragmentSyllabusCategoryBinding.commerce};

        return fragmentSyllabusCategoryBinding.getRoot();
    }
    @Override
    public void onClick(View v) {
        AppCompatTextView[] pdflist = new AppCompatTextView []{fragmentSyllabusCategoryBinding.mathematics, fragmentSyllabusCategoryBinding.english, fragmentSyllabusCategoryBinding.biology, fragmentSyllabusCategoryBinding.physics, fragmentSyllabusCategoryBinding.chemistry,fragmentSyllabusCategoryBinding.commerce};
        for (AppCompatTextView pdf : pdflist){
            jambSyllabus nextFrag= new jambSyllabus();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.syllabus_category, nextFrag)
                    .addToBackStack(null)
                    .commit();
//            Context context = getActivity();
//            CharSequence text = "Hello toast!";
//            int duration = Toast.LENGTH_SHORT;
//
//            Toast toast = Toast.makeText(context, text, duration);
//            toast.show();
//                    jambSyllabus fragment2 =new jambSyllabus();
//            FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
//            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//            fragmentTransaction.replace(R.id.syllabus_category,fragment2,"tag");
//            fragmentTransaction.addToBackStack(null);
//            fragmentTransaction.commit();
        }
        }


    @Override
    public void onActivityCreated(@Nullable  Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fragmentSyllabusCategoryBinding.backArrow.setOnClickListener(v->{
            requireActivity().onBackPressed();
        });
        AppCompatTextView[] pdflist = new AppCompatTextView []{fragmentSyllabusCategoryBinding.mathematics, fragmentSyllabusCategoryBinding.english, fragmentSyllabusCategoryBinding.biology, fragmentSyllabusCategoryBinding.physics, fragmentSyllabusCategoryBinding.chemistry,fragmentSyllabusCategoryBinding.commerce};
        for (AppCompatTextView pdf : pdflist){

            pdf.setOnClickListener(this);
        };



    }


}