package com.example.collegenews;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ClassesActivity extends AppCompatActivity {

    private ListView listView;
    private TextView day,label;
    private ClassesAdapter classesAdapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);
        //   listView=findViewById(R.id.list);
        day=findViewById(R.id.class_day);
        label=findViewById(R.id.label);
        //  label.setSelected(true);
        recyclerView=findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(ClassesActivity.this));
        recyclerView.setHasFixedSize(true);

        Calendar calendar=Calendar.getInstance();
        String currentDay= DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        String[] splitDate=currentDay.split(",");
        day.setText(splitDate[0].trim());


        ArrayList<ClassInfo> list=new ArrayList<>();
//        final ArrayAdapter adapter=new ArrayAdapter<String>(ClassesActivity.this,R.layout.list_item,list);
//        listView.setAdapter(adapter);

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("classes");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                list.clear();
                for (DataSnapshot snapshot : datasnapshot.getChildren()){
                    String today=snapshot.getKey();
                    if (today.equals(splitDate[0].trim().toLowerCase())) {

                        for (DataSnapshot snap : datasnapshot.child(today).getChildren()) {
                            ClassInfo data=new ClassInfo(snap.child("name").getValue().toString(),snap.getKey(),snap.child("condition").getValue().toString());
                            list.add(data);
                            //  list.add(snap.getValue().toString());
                        }


                    }
                }
                classesAdapter.notifyDataSetChanged();



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        classesAdapter=new ClassesAdapter(ClassesActivity.this,list);
        recyclerView.setAdapter(classesAdapter);


    }
}