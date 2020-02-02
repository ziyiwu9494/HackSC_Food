package com.example.hacksc_food.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hacksc_food.Meal;
import com.example.hacksc_food.NavDrawer;
import com.example.hacksc_food.R;

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.nav_recycle);
        ListAdapter listAdapter = new ListAdapter(((NavDrawer)getActivity()).getFoodOptions(), getActivity());
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity())
        //recyclerView.setLayoutManager(layoutManager);

        return root;
    }
}