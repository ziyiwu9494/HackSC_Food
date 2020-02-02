package com.example.hacksc_food.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hacksc_food.AppData;
import com.example.hacksc_food.CreateAccount;
import com.example.hacksc_food.R;

public class FindMealDetails extends AppCompatActivity implements View.OnClickListener {

    TextView mealName, mealTags, mealDescs,mealNumPeople, mealTime,mealAddress;
    String data1,data2;
    String title_data, tag_data, desc_data, num_people_data,time_data,address_data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_meal_details);

        mealName = findViewById(R.id.mealName);//R.id. refers to the xml component
        mealTags = findViewById(R.id.mealTags);
        mealDescs = findViewById(R.id.mealDesc);
        mealNumPeople = findViewById(R.id.num_people);
        mealTime= findViewById(R.id.mealTime);
        mealAddress = findViewById(R.id.mealAddress);
        findViewById(R.id.claim).setOnClickListener(this);
        getData();
        setData();
    }

    private void getData(){
        if(
                getIntent().hasExtra("title_data") &&
                getIntent().hasExtra("tag_data") &&
                getIntent().hasExtra("desc_data") &&
                getIntent().hasExtra("num_people_data") &&
                getIntent().hasExtra("time_data") &&
                getIntent().hasExtra("address_data")

        ){
            title_data = getIntent().getStringExtra("title_data");
            tag_data = getIntent().getStringExtra("tag_data");
            desc_data = getIntent().getStringExtra("desc_data");
            num_people_data = getIntent().getStringExtra("num_people_data");
            time_data= getIntent().getStringExtra("time_data");
            address_data= getIntent().getStringExtra("address_data");
        } else {
            Toast.makeText(this,"No Data", Toast.LENGTH_SHORT).show();
        }
    }
    private void setData(){
        mealName.setText(title_data);
        mealTags.setText(getString(R.string.formatTags, tag_data));
        mealDescs.setText(desc_data);
        mealNumPeople.setText(getString(R.string.formatNumPeople, num_people_data));
        mealTime.setText(getString(R.string.formatTime,time_data));
        mealAddress.setText(getString(R.string.formatLocation,address_data));

    }
    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.claim) {
            findViewById(R.id.claim).setVisibility(View.INVISIBLE);
            ((AppData)this.getApplication()).getClaimedMeals().add(title_data);
            Toast.makeText(this,"Claimed!", Toast.LENGTH_SHORT).show();
        }
    }
}
