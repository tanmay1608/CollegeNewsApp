package com.example.collegenews;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class ClassesAdapter extends RecyclerView.Adapter<ClassesAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ClassInfo> info;


    public ClassesAdapter(Context context, ArrayList<ClassInfo> info) {
        this.context = context;
        this.info = info;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (info.get(position).getNeed().equals("true"))
        {
            holder.linearLayout.setBackgroundColor(Color.GREEN);
        }
        else if (info.get(position).getNeed().equals("false"))
        {
            holder.linearLayout.setBackgroundColor(Color.RED);
        }
        else {
            holder.linearLayout.setBackgroundColor(Color.parseColor("#F2EABC"));
        }



        holder.textView.setText(info.get(position).getData());
        //   holder.textView.setSelected(true);



    }

    @Override
    public int getItemCount() {
        return info.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView green,red;
        private LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.label);


            linearLayout=itemView.findViewById(R.id.linear);
        }
    }
}
