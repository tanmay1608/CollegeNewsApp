package com.example.collegenews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {



    private CardView faculty_cardView,classesCardView,EventCardView,mhrdCardView,galley_cardView,about_us;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(Build.VERSION.SDK_INT>=21)
        {
            Window window=this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.colorAccent));
        }
        setContentView(R.layout.activity_main);


        mhrdCardView = findViewById(R.id.mhrd_card);
        faculty_cardView = findViewById(R.id.faculty_card);
        classesCardView = findViewById(R.id.class_card);
        EventCardView = findViewById(R.id.events_card);
        // clubsCardView=findViewById(R.id.group_card);
        galley_cardView = findViewById(R.id.gallery_card);
        about_us = findViewById(R.id.About_card);



        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.text_gradient));
        }


        faculty_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent facultyIntent = new Intent(MainActivity.this, FacultyActivity.class);
                startActivity(facultyIntent);
            }
        });
        classesCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent classesIntent = new Intent(MainActivity.this, ClassesActivity.class);
                startActivity(classesIntent);
            }
        });
        EventCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent eventsIntent = new Intent(MainActivity.this, EventsActivity.class);
                startActivity(eventsIntent);
            }
        });
//        mhrdCardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent mhrdIntent=new Intent(MainActivity.this,MHRDActivity.class);
//                startActivity(mhrdIntent);
//            }
//        });

        galley_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent = new Intent(MainActivity.this, ExamCalender.class);
                startActivity(galleryIntent);
            }
        });
        about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aboutUsIntent = new Intent(MainActivity.this, AboutUsActivity.class);
                startActivity(aboutUsIntent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.options,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.log_out){
            FirebaseAuth.getInstance().signOut();

            Intent logoutIntent=new Intent(MainActivity.this,StartActivity.class);
            startActivity(logoutIntent);
            Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}