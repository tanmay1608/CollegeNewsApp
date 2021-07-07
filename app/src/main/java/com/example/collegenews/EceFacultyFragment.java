package com.example.collegenews;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class EceFacultyFragment extends Fragment {
    private RecyclerView recyclerView;
    private FacultyAdapter facultyAdapter;
    private Context context;



    public EceFacultyFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_ece_faculty, container, false);
        recyclerView=view.findViewById(R.id.ece_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setHasFixedSize(true);

        ArrayList<FacultyInfo> eceInfo=new ArrayList<>();

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("Faculty").child("ECE");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                eceInfo.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                    String snapEmail=snapshot.child("Email").getValue().toString();
                    String snapName=snapshot.child("Name").getValue().toString();
                    String snapImage=snapshot.child("Image").getValue().toString();
                    FacultyInfo data=new FacultyInfo(snapName,snapEmail,snapImage);
                    eceInfo.add(data);
                }
                facultyAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        facultyAdapter =new FacultyAdapter(context,eceInfo);
        recyclerView.setAdapter(facultyAdapter);

        return view;
    }
}