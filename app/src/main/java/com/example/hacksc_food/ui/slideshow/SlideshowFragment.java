package com.example.hacksc_food.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hacksc_food.AppData;
import com.example.hacksc_food.Meal;
import com.example.hacksc_food.R;

import java.util.ArrayList;
import java.util.List;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.nav_recycle);
        List<Meal> claimedMeals = new ArrayList<Meal>();
        for(Meal m : ((AppData)(getActivity().getApplication())).getAllMeals()){
            if(((AppData)(getActivity().getApplication())).getClaimedMeals().contains(m.getMealName())){
                claimedMeals.add(m);
            }
        }
        ListAdapter listAdapter = new ListAdapter(claimedMeals,getActivity());
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

       // final TextView textView = root.findViewById(R.id.text_slideshow);
/*        slideshowViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }
}