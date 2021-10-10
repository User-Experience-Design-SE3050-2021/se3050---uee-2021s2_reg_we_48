package com.example.mirror;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText email, password;
    private TextView signup, forgotpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        email = findViewById(R.id.etEmail);
        password = findViewById((R.id.etPassword));
        Button login = findViewById(R.id.btn_login);
        signup = findViewById(R.id.signup);
        forgotpassword = findViewById(R.id.textView10);

        login.setOnClickListener(view -> {
            String Email = email.getText().toString().trim();
            String Password = password.getText().toString().trim();

            if(Email.isEmpty()){
                email.setError("Email is required!");
            }else if (Password.isEmpty()){
                password.setError("Password is required!");
            }else{
                Toast.makeText(getApplicationContext(), "Logged In successfully", Toast.LENGTH_SHORT).show();
                Intent send = new Intent(Login.this, Store.class);
                startActivity(send);
            }
        });

        signup.setOnClickListener(view -> {
            Intent send = new Intent(Login.this, SignUp.class);
            startActivity(send);
        });

        forgotpassword.setOnClickListener(view -> {
            Intent send = new Intent(Login.this, ForgotPassword.class);
            startActivity(send);
        });


    }
}