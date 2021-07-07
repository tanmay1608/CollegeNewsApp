package com.example.collegenews;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.myViewHolder> {
    private Context context;
    // ArrayList<String> list;
    ArrayList<ModelClass> list;
    public NewsAdapter(Context context,ArrayList<ModelClass> list){
        this.context=context;
        this.list=list;

    }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter,parent,false);
        myViewHolder holder=new myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getNews());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.adapter_text);
        }
    }
}
