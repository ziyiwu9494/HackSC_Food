package com.example.hacksc_food;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    String data1[], data2[];
    Context context;

    public ListAdapter(Context ct, String s1[], String s2[]){
        context = ct;
        data1 = s1;
        data2 = s2;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView myText1, myText2;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            myText1 = itemView.findViewById(R.id.titleText);
            myText2 = itemView.findViewById(R.id.descText);
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
