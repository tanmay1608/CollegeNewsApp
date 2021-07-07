package com.example.collegenews;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StartActivity extends AppCompatActivity {
    private Button login,register;
    private ImageView imageView;
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        init();

        linearLayout.animate().alpha(1f).setDuration(1000);



        TranslateAnimation animation=new TranslateAnimation(0,0,-1000,0);
        animation.setDuration(1000);
        animation.setFillAfter(false);
        animation.setAnimationListener(new MyanimationListener());

        TranslateAnimation animation1=new TranslateAnimation(1000,0,0,0);
        animation1.setDuration(1000);
        animation1.setFillAfter(false);
        animation1.setAnimationListener(new MyanimationListener());

        TranslateAnimation animation2=new TranslateAnimation(-1000,0,0,0);
        animation2.setDuration(1000);
        animation2.setFillAfter(false);
        animation2.setAnimationListener(new MyanimationListener());

        imageView.setAnimation(animation);
        //linearLayout.setAnimation(animation1);
        register.setAnimation(animation1);
        login.setAnimation(animation2);
//
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent=new Intent(StartActivity.this,LoginActivity.class);
                startActivity(loginIntent);
                //finish();

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent RegisterIntent=new Intent(StartActivity.this,RegisterActivity.class);
                startActivity(RegisterIntent);
                //finish();
            }
        });


    }

    private void init() {
        login=findViewById(R.id.Login);
        register=findViewById(R.id.register);
        imageView=findViewById(R.id.icon);
        linearLayout=findViewById(R.id.startLinear);
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user!=null)
        {
            Intent startIntent=new Intent(StartActivity.this,MainActivity.class);
            startActivity(startIntent);
            finish();
        }

    }
    private class MyanimationListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            imageView.clearAnimation();
            //  linearLayout.clearAnimation();
            register.clearAnimation();
            login.clearAnimation();
            // imageView.setVisibility(View.INVISIBLE);
            // linearLayout.animate().alpha(1f).setDuration(1000);

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}