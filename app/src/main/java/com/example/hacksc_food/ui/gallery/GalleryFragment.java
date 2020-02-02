package com.example.hacksc_food.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.hacksc_food.R;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    String mealName;
    String description;
    int timeHour;
    int timeMin;
    String location;
    int numPeople;

    Button submitButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //galleryViewModel = ViewModelProviders.of(this).get(GalleryViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        //final TextView textView = root.findViewById(R.id.text_gallery);
        /*galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });*/

        submitButton = root.findViewById(R.id.postMeal);
        submitButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                mealName = root.findViewById(R.id.mealNameInput).toString();
                description = root.findViewById(R.id.descriptionInput).toString();
                location = root.findViewById(R.id.meetingPoint).toString();
                numPeople = Integer.parseInt(root.findViewById(R.id.numOfPeople).toString());

            }
        });







        return root;
    }
}