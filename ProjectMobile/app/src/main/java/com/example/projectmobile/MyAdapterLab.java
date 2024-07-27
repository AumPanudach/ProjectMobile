package com.example.projectmobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapterLab extends RecyclerView.Adapter<MyViewHolderLab> {
    Context context;
    List<DataLab> dataLabList;
    public MyAdapterLab(Context context , List<DataLab> dataLabList){
        this.context = context;
        this.dataLabList = dataLabList;
    }
    @NonNull
    @Override
    public MyViewHolderLab onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lab_item,parent,false);
        return new MyViewHolderLab(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderLab holder, int position) {
        holder.textView.setText(dataLabList.get(position).getNameLab());
        holder.imageView.setImageResource(dataLabList.get(position).getSrcImage());
    }

    @Override
    public int getItemCount() {
        return dataLabList.size();
    }
}
class MyViewHolderLab extends RecyclerView.ViewHolder{
    TextView textView;
    ImageView imageView;
    public MyViewHolderLab(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.roomId);
        imageView = itemView.findViewById(R.id.image_room);
    }
}
