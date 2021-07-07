package com.example.collegenews;


import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FacultyAdapter extends RecyclerView.Adapter<FacultyAdapter.ViewHolder> {
    private Context context;
    private ArrayList<FacultyInfo> info;

    public FacultyAdapter(Context context, ArrayList<FacultyInfo> info) {
        this.context = context;
        this.info = info;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.faculty_adapter,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.get().load(info.get(position).getFaculty_image()).into(holder.imageView);
        holder.name.setText(info.get(position).getFaculty_name());
        holder.email.setText(info.get(position).getFaculty_email());

    }

    @Override
    public int getItemCount() {
        return info.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView name,email;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.faculty_image);
            name=itemView.findViewById(R.id.faculty_name);
            email=itemView.findViewById(R.id.faculty_email);
            email.setPaintFlags(email.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        }
    }
}
