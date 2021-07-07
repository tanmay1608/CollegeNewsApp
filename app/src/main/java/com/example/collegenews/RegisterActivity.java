package com.example.collegenews;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private Button register;
    private EditText Email,Password;

    private FirebaseAuth myAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();
    }

    private void initViews() {
        register=findViewById(R.id.Register_activity);
        Email=findViewById(R.id.email);
        Password=findViewById(R.id.password);
        myAuth=FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email_txt=Email.getText().toString();
                String password_txt=Password.getText().toString();

                if (TextUtils.isEmpty(email_txt) || TextUtils.isEmpty(password_txt))
                {
                    Toast.makeText(RegisterActivity.this, "Empty credentials", Toast.LENGTH_SHORT).show();
                }
                else if (password_txt.length()<6)
                {
                    Toast.makeText(RegisterActivity.this, "Password is too short", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    registerUser(email_txt,password_txt);
                }
            }
        });
    }







    private void registerUser(String email, String password) {
        myAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete( Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(RegisterActivity.this, "Registration is Successful", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(RegisterActivity.this, "Registration is failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}