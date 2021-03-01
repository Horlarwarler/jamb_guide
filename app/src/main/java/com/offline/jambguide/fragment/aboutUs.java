package com.offline.jambguide.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.offline.jambguide.R;
import com.offline.jambguide.databinding.FragmentAboutUsBinding;

public class aboutUs extends Fragment {

    public WebView myLink;
    FragmentAboutUsBinding FragementAboutUs;
    NavController navController;


    public aboutUs() {
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
        FragementAboutUs = FragmentAboutUsBinding.inflate(inflater, container, false);

        return FragementAboutUs.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        Context context = getActivity();
        FragementAboutUs.backArrow.setOnClickListener(v -> {
            requireActivity().onBackPressed();
        });
        FragementAboutUs.contactEmail.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putString("type", "email");

            navController.navigate(R.id.jambNews, args);

        });
        FragementAboutUs.contactPhone.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putString("type", "phone");
            navController.navigate(R.id.jambNews, args);

        });


    }
}