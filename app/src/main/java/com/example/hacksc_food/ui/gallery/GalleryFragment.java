package com.example.hacksc_food.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.hacksc_food.Meal;
import com.example.hacksc_food.R;
import com.example.hacksc_food.NavDrawer;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class GalleryFragment extends Fragment implements View.OnClickListener {
    public static int uploads;
    private GalleryViewModel galleryViewModel;
    private EditText mealNameField;
    private EditText descriptionField;
    private EditText timeField;
    private EditText locationField;
    private EditText tagField;
    private EditText numPeopleField;
    private Button submitButton;
    FirebaseUser user;
    DatabaseReference ref;
    FirebaseDatabase db;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //galleryViewModel = ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        //final TextView textView = root.findViewById(R.id.text_gallery);
        /*galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });*/
        mealNameField = root.findViewById(R.id.mealNameInput);
        descriptionField = root.findViewById(R.id.descriptionInput);
        timeField = root.findViewById(R.id.timeInput);
        locationField = root.findViewById(R.id.meetingPoint);
        tagField = root.findViewById(R.id.tags);
        numPeopleField = root.findViewById(R.id.numOfPeople);
        db = FirebaseDatabase.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        submitButton = root.findViewById(R.id.postMeal);
        submitButton.setOnClickListener(this);
        return root;
    }
    public Meal buildMeal(String key){
        String mealName = mealNameField.getText().toString();
        String description = descriptionField.getText().toString();
        String location = null;
        location = locationField.getText().toString();
        int numPeople = 0;
        try {
            numPeople = Integer.parseInt(numPeopleField.getText().toString());
        } catch (Exception e){
            Log.d("IntParseException", e.getMessage());
        }
        String time = timeField.getText().toString();
        String tags = tagField.getText().toString();
        List<String> tag = new ArrayList<String>();
        tag.add(tags);
        Meal thisMeal = new Meal(mealName,user.getDisplayName(),description,time,location,numPeople,tag);
        thisMeal.setKey(key);
        return thisMeal;
    }
    public void onClick(View view) {
        String key = "meal"+user.getDisplayName() + Calendar.getInstance().getTime().toString();
        ref = db.getReference(key);
        ref.setValue(buildMeal(key)).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getActivity(), "Successfully Posted!",
                        Toast.LENGTH_SHORT).show();
                Intent goToHome = new Intent(getActivity(), NavDrawer.class);
                startActivity(goToHome);
            }
        });
    }
}