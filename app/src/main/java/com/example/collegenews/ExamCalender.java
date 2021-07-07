package com.example.collegenews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ExamCalender extends AppCompatActivity {
    private RecyclerView daily_recyclerView,pre_recyclerView,postPone_recycler;
    private ExamCalenderAdapter examCalenderAdapter;
    private PrePondAdapter pre;
    private PostPoneAdapter postPoneAdapter;
    private TextView textView,daily_text;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        textView=findViewById(R.id.text);
        daily_text=findViewById(R.id.daily__text);
        daily_recyclerView=findViewById(R.id.daily_recyclerView);
        pre_recyclerView=findViewById(R.id.pre_recyclerView);
        pre_recyclerView.setLayoutManager(new LinearLayoutManager(ExamCalender.this));
        pre_recyclerView.setHasFixedSize(true);

        postPone_recycler=findViewById(R.id.post_recyclerView);
        postPone_recycler.setLayoutManager(new LinearLayoutManager(ExamCalender.this));
        postPone_recycler.setHasFixedSize(true);
        daily_recyclerView.setLayoutManager(new LinearLayoutManager(ExamCalender.this));
        daily_recyclerView.setHasFixedSize(true);


        textView.setSelected(true);

        daily_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                daily_recyclerView.setVisibility(View.INVISIBLE);
            }
        });
        ArrayList<ExamCalenderInfo> exam_info=new ArrayList<>();
        ArrayList<prepondInfo> prepondInfos=new ArrayList<>();
        ArrayList<PostPone> postPones=new ArrayList<>();
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("ddMMM");
        String dateTime=simpleDateFormat.format(calendar.getTime());
        Log.d("tag1",dateTime.substring(1));
        Log.d("tag", dateTime);

//
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("Exam Calender");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                exam_info.clear();
                prepondInfos.clear();
                postPones.clear();

                textView.setText(dataSnapshot.child("today").getValue().toString());

                for (DataSnapshot snapshot : dataSnapshot.getChildren())
                {

                    String key=snapshot.getKey();

                    if (key.equals(dateTime))
                    {
                        String snapExamNews=snapshot.getValue().toString();
                        ExamCalenderInfo data=new ExamCalenderInfo(snapExamNews);
                        exam_info.add(data);

                    }
                    if (key.equals("prepone"))
                    {
                        String News=snapshot.getValue().toString();
                        prepondInfo news=new prepondInfo(News);
                        prepondInfos.add(news);
                    }
                    if (key.equals("postpone"))
                    {
                        String postNews=snapshot.getValue().toString();
                        PostPone news=new PostPone(postNews);
                        postPones.add(news);
                    }
//                    else
//                    {
//                        String snapExamNews="No news till now";
//                        ExamCalenderInfo data=new ExamCalenderInfo(snapExamNews);
//                        exam_info.add(data);
//
//                    }




                }
                examCalenderAdapter.notifyDataSetChanged();
                pre.notifyDataSetChanged();
                postPoneAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
//
        examCalenderAdapter=new ExamCalenderAdapter(ExamCalender.this,exam_info);
        daily_recyclerView.setAdapter(examCalenderAdapter);
        pre=new PrePondAdapter(ExamCalender.this,prepondInfos);
        postPoneAdapter=new PostPoneAdapter(ExamCalender.this,postPones);
        postPone_recycler.setAdapter(postPoneAdapter);

        pre_recyclerView.setAdapter(pre);
//
//        // galleryAdapter=new GalleryAdapter(GalleryActivity.this,images);
//
//      //  recyclerView.setAdapter(galleryAdapter);
//    }
    }
}