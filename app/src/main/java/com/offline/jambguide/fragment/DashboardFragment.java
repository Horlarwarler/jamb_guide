package com.offline.jambguide.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.offline.jambguide.databinding.FragmentDashboardBinding;
import com.offline.jambguide.utils.PanelHandler;


public class DashboardFragment extends Fragment {

    FragmentDashboardBinding fragmentDashboardBinding;

    PanelHandler panelHandler;

    NavController navController;

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        panelHandler = new PanelHandler(requireContext(), navController);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        fragmentDashboardBinding = FragmentDashboardBinding.inflate(inflater, container, false);
        return fragmentDashboardBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        fragmentDashboardBinding.setHandler(panelHandler);

    }
}
