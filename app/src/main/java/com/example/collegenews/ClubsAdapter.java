package com.example.collegenews;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.List;

public class ClubsAdapter extends RecyclerView.Adapter<ClubsAdapter.ViewHolder> {
    private Context context;
    private String[]  nameList;
    private int[]  imageList;
    private List<ImgList> list;
    private ViewPager2 viewPager2;

    public ClubsAdapter(Context context, int[] imageList) {
        this.context = context;
        //    this.nameList = nameList;
        this.imageList = imageList;
        //this.list=list;
        //  this.viewPager2=viewPager2;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.clubs_adapter,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder.TextView.setText(nameList[position]);
        holder.imageView.setImageResource(imageList[position]);

    }

    @Override
    public int getItemCount() {
        return imageList.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView TextView;
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // TextView=itemView.findViewById(R.id.clubs_textView);
            imageView=itemView.findViewById(R.id.club_images);
        }
    }
}
