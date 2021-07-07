package com.example.collegenews;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    private ArrayList<EventInfo> data;
    private Context context;

    private FirebaseUser firebaseUser;

    public EventAdapter( Context context,ArrayList<EventInfo> data) {
        this.context = context;
        this.data = data;
        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.events_adapter,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.get().load(data.get(position).getImage()).into(holder.imageView);
        holder.textView.setText(data.get(position).getText());
        holder.likes.setText(data.get(position).getLikes()+" "+"Likes");

        isLiked(data.get(position).getPostId(),holder.heart);
        noOfLikes(data.get(position).getPostId(),holder.likes);
        holder.heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.heart.getTag().equals("Like")) {

                    FirebaseDatabase.getInstance().getReference().child("Likes")
                            .child(data.get(position).getPostId()).child(firebaseUser.getUid()).setValue(true);

                }
                else {
                    FirebaseDatabase.getInstance().getReference().child("Likes")
                            .child(data.get(position).getPostId()).child(firebaseUser.getUid()).removeValue();
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView,likes;
        private ImageView heart,share;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.event_image);
            textView=itemView.findViewById(R.id.event_text);
            heart=itemView.findViewById(R.id.heart);
            likes=itemView.findViewById(R.id.likes);
            //  share=itemView.findViewById(R.id.share);
        }
    }
    private void isLiked(String postId, ImageView imageView){
        FirebaseDatabase.getInstance().getReference().child("Likes").child(postId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.child(firebaseUser.getUid()).exists())
                {
                    imageView.setImageResource(R.drawable.red);
                    imageView.setTag("Liked");
                }
                else {
                    imageView.setImageResource(R.drawable.like);
                    imageView.setTag("Like");

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void noOfLikes(String postId, TextView text)
    {
        FirebaseDatabase.getInstance().getReference().child("Likes").child(postId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                text.setText(snapshot.getChildrenCount() +"likes");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
