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

import com.example.hacksc_food.R;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    String title_data[], tag_data[], desc_data[], num_people_data[],time_data[],address_data[];
    Context context;

    public ListAdapter(Context ct, String s1[], String s2[], String s3[], String s4[], String s5[], String s6[]){
        context = ct;
        title_data = s1;
        tag_data = s2;
        desc_data = s3;
        num_people_data= s4;
        time_data= s5;
        address_data = s6;
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
        holder.myText1.setText(title_data[position]);
        holder.myText2.setText(tag_data[position]);
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,find_meal_details.class);
                intent.putExtra("title_data", title_data[position]);
                intent.putExtra("tag_data", tag_data[position]);
                intent.putExtra("desc_data", desc_data[position]);
                intent.putExtra("num_people_data", num_people_data[position]);
                intent.putExtra("time_data", time_data[position]);
                intent.putExtra("address_data", address_data[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return title_data.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView myText1, myText2;

        ConstraintLayout mainLayout;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            myText1 = itemView.findViewById(R.id.titleText);
            myText2 = itemView.findViewById(R.id.tagText);
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
