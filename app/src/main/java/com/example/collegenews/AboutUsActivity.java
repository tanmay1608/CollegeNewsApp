package com.example.collegenews;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AboutUsActivity extends AppCompatActivity {
    private ImageView location,yt,fb,insta,linkedin,twitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        location=findViewById(R.id.college_location);
        yt=findViewById(R.id.college_yt);
        fb=findViewById(R.id.fb);
        insta=findViewById(R.id.insta);
        linkedin=findViewById(R.id.linkedin);
        twitter=findViewById(R.id.twitter);

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("https://twitter.com/IIITKotaOffice");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                //Intent intent=getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
                // intent.setPackage("com.google.android.youtube");
                startActivity(intent);

            }
        });

        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("https://www.linkedin.com/school/iiitkota/");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);

                startActivity(intent);

            }
        });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("https://www.instagram.com/iiitkotaoffice/");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);

                startActivity(intent);

            }
        });

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("https://www.facebook.com/IIITKotaOffice/");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);

                startActivity(intent);

            }
        });

        yt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("https://www.youtube.com/channel/UCMvxTDPPnyuEPSGgjOv6HBQ");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);

                startActivity(intent);

            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("geo:0,0?q=IIIT Kota");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);

            }
        });
    }
}