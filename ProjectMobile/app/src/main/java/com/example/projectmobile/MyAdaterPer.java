package com.example.projectmobile;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdaterPer extends RecyclerView.Adapter<MyViewHolderPer> {
    private Context contextPer;
    private List<PerDataClass> dataClassList;

    public MyAdaterPer (Context context,List<PerDataClass> dataClassList) {
        this.contextPer = context;
        this.dataClassList = dataClassList;
    }

    @NonNull
    @Override
    public MyViewHolderPer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.personnel_item,parent,false);
        return new MyViewHolderPer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPer holder, int position) {
        holder.imageView.setImageResource(dataClassList.get(position).getDataImage());
        holder.resName.setText(dataClassList.get(position).getDataName());
        holder.resStatus.setText(dataClassList.get(position).getDataStatus());
        holder.resEmail.setText(dataClassList.get(position).getDataEmail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contextPer.startActivity(new Intent(contextPer,Personnel.class));
            }
        });
    }


    @Override
    public int getItemCount() {
        return dataClassList.size();
    }
}
class MyViewHolderPer extends RecyclerView.ViewHolder{
    TextView resName,resStatus,resEmail;
    ImageView imageView;
    CardView cardView;
    public MyViewHolderPer(@NonNull View itemView) {
        super(itemView);
        resName = itemView.findViewById(R.id.name_per);
        resStatus = itemView.findViewById(R.id.status_per);
        resEmail = itemView.findViewById(R.id.email_per);
        imageView = itemView.findViewById(R.id.per_image);
        cardView = itemView.findViewById(R.id.card_per);
    }
}
