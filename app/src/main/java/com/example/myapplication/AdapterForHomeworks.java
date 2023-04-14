package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AdapterForHomeworks extends RecyclerView.Adapter<AdapterForHomeworks.ViewHolder>{

    interface OnStateClickListener{
        void onStateClick(One_Homework homework, int position);
    }

    private final OnStateClickListener onClickListener;

    private final LayoutInflater inflater;
    private final List<One_Homework> states;

    AdapterForHomeworks(Context context, List<One_Homework> states, OnStateClickListener onClickListener) {
        this.onClickListener = onClickListener;
        this.states = states;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public AdapterForHomeworks.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.homeworks_style, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterForHomeworks.ViewHolder holder, int position) {
        One_Homework state = states.get(position);
        holder.pictureView.setImageResource(state.getPictureResource());
        holder.nameView.setText(state.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                onClickListener.onStateClick(state, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return states.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView pictureView;
        final TextView nameView;
        ViewHolder(View view){
            super(view);
            pictureView = view.findViewById(R.id.homeworks_imagine);
            nameView = view.findViewById(R.id.homeworks_text);
        }
    }

}

















