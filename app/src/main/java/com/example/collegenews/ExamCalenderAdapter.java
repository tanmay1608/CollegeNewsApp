package com.example.collegenews;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExamCalenderAdapter extends RecyclerView.Adapter<ExamCalenderAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ExamCalenderInfo> data;

    public ExamCalenderAdapter(Context context, ArrayList<ExamCalenderInfo> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_adapter,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //  Picasso.get().load(images.get(position).getImages()).into(holder.imageView);
        holder.textView.setText(data.get(position).getNewsData());
        holder.textView.setSelected(true);



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.news_data);

        }
    }
}
