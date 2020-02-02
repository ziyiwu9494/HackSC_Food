package com.example.hacksc_food.ui.gallery;

import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.hacksc_food.Login;
import com.example.hacksc_food.MainActivity;
import com.example.hacksc_food.Meal;
import com.example.hacksc_food.R;
import com.example.hacksc_food.nav_drawer;
import com.example.hacksc_food.ui.home.HomeFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GalleryFragment extends Fragment implements View.OnClickListener {

    private GalleryViewModel galleryViewModel;

    String mealName;
    String description;
    Date time;
    String location;
    int numPeople;
    List<String> tag = new ArrayList<String>();
    Button submitButton;
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
        db = FirebaseDatabase.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        submitButton = root.findViewById(R.id.postMeal);
        ref = db.getReference("meal");
        submitButton.setOnClickListener(this);
        return root;
    }
    public Meal buildMeal(){
        mealName = getView().findViewById(R.id.mealNameInput).toString();
        Log.d("mealName", getView().findViewById(R.id.mealNameInput).toString());
        description = getView().findViewById(R.id.descriptionInput).toString();
        location = getView().findViewById(R.id.meetingPoint).toString();
        try {
            numPeople = Integer.parseInt(getView().findViewById(R.id.numOfPeople).toString());
        } catch (Exception e){
            Log.d("IntParseException", e.getMessage());
        }
        String str = getView().findViewById(R.id.timeInput).toString();
        DateFormat formatter = new SimpleDateFormat("hh:mm a");
        try{
            time = formatter.parse(str);
        } catch (Exception e){
            Log.d("Parse Exception", e.getMessage());
        }
        String tags = getView().findViewById(R.id.tags).toString();
        tag.add(tags);
        Meal thisMeal = new Meal(user.getDisplayName(),mealName,description,time,location,numPeople,tag);
        return thisMeal;
    }
    public void onClick(View view) {
        ref.setValue(buildMeal()).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getActivity(), "Successfully Posted!",
                        Toast.LENGTH_SHORT).show();
                Intent goToHome = new Intent(getActivity(), nav_drawer.class);
                startActivity(goToHome);
            }
        });
    }
}