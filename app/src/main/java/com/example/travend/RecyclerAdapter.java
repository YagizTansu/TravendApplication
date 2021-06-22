package com.example.travend;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PostHolder> {
    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_row,parent,false);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        if (position == 0){
            holder.imageView.setImageResource(R.drawable.profile1);
            holder.TextAbout.setText("fsdfkskgmdlfgmdflgdlgdfgdfgdfgdf");
        }else if(position == 1){
            holder.imageView.setImageResource(R.drawable.profile2);
            holder.TextAbout.setText("fsdfkskgmdlfgmdflgdlgdfgdfgdfgdf");
        }
        else if(position == 2 ){
            holder.imageView.setImageResource(R.drawable.profile3);
            holder.TextAbout.setText("fsdfkskgmdlfgmdflgdlgdfgdfgdfgdf");
        }else{
            holder.imageView.setImageResource(R.drawable.ic_baseline_person_24);
            holder.TextAbout.setText("fsdfkskgmdlfgmdflgdlgdfgdfgdfgdf");
        }



    }

    @Override
    public int getItemCount() {
        return 12;
    }

    class PostHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView TextAbout;
        Button buttonPoke;

        public PostHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.profilePic);
            TextAbout = itemView.findViewById(R.id.textAbout);
            buttonPoke = itemView.findViewById(R.id.buttonPoke);


        }
    }
}