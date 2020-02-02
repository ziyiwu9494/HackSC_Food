package com.example.hacksc_food.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hacksc_food.Meal;
import com.example.hacksc_food.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    List<Meal> foodOptions;
    Context context;

    public ListAdapter(List<Meal> foodOptions, Context context){
        this.foodOptions = foodOptions;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final Meal currentMeal = foodOptions.get(position);
        holder.mealTitle.setText(currentMeal.getMealName());
        String tags = "";
        if(currentMeal.getTags() != null){
            for(String tag : currentMeal.getTags()){
                tags = tags + tag;
            }
            holder.tag.setText(tags);
        }
        final String passTags = tags;
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FindMealDetails.class);
                intent.putExtra("title_data", currentMeal.getMealName());
                intent.putExtra("tag_data", passTags);
                intent.putExtra("desc_data", currentMeal.getDescription());
                intent.putExtra("num_people_data", String.valueOf(currentMeal.getNumPeople()));
                intent.putExtra("time_data", currentMeal.getTime());
                intent.putExtra("address_data", currentMeal.getLocation());
                intent.putExtra("key", currentMeal.getKey());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodOptions.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView mealTitle, tag;
        ConstraintLayout mainLayout;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            mealTitle = itemView.findViewById(R.id.titleText);
            tag = itemView.findViewById(R.id.tagText);
            mainLayout = itemView.findViewById(R.id.my_row_layout);
        }
    }

/*    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
         private TextView mTitleText;
         private TextView mDescText;


         public ListViewHolder(View itemView){
             super(itemView);
             mTitleText = (TextView) itemView.findViewById(R.id.itemText);
             mDescText = (TextView) itemView.findViewById(R.id.descText);
             itemView.setOnClickListener(this);
         }

         public void bindView(int position){
             mTitleText.setText(sample_data.titles[position]);


         };

         public void onClick(View view){

         }
    }*/
}
