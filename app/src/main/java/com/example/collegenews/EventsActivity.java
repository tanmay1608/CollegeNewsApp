package com.example.collegenews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EventAdapter eventAdapter;
    private Context context;
    private ArrayList<EventInfo> info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        recyclerView=findViewById(R.id.events_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setHasFixedSize(true);
        info=new ArrayList<>();

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("Events");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                info.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                    String snapTitle=snapshot.child("Title").getValue().toString();
                    String snapImage=snapshot.child("Image").getValue().toString();
                    String snapLikes=snapshot.child("likes").getValue().toString();
                    String snapPostId=snapshot.child("postID").getValue().toString();
                    EventInfo data=new EventInfo(snapTitle,snapImage,snapLikes,snapPostId);
                    info.add(data);


                }
                eventAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        eventAdapter =new EventAdapter(context,info);
        recyclerView.setAdapter(eventAdapter);
    }
}