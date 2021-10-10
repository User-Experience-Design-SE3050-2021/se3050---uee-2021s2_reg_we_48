package com.example.mirror;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    private EditText username, email, password, repassword;
    private TextView log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = findViewById(R.id.etusername);
        email = findViewById(R.id.etEmail);
        password = findViewById((R.id.etPassword));
        repassword = findViewById(R.id.etRePassword);
        Button register = findViewById(R.id.btn_register);
        log = findViewById(R.id.log);

        register.setOnClickListener(view -> {
            String Username = username.getText().toString().trim();
            String Email = email.getText().toString().trim();
            String Password = password.getText().toString().trim();
            String RePassword = repassword.getText().toString().trim();

            if(Username.isEmpty()) {
                username.setError("Username is required!");
            } else if (Email.isEmpty()) {
                email.setError("Email is required!");
            } else if (Password.isEmpty()){
                password.setError("Password is required!");
            }else if (RePassword.isEmpty()){
                repassword.setError("Re Password is required!");
            }else{
                Toast.makeText(getApplicationContext(), "Signed Up successfully", Toast.LENGTH_SHORT).show();
                Intent send = new Intent(SignUp.this, Addresses.class);
                startActivity(send);
            }
        });

        log.setOnClickListener(view -> {
            Intent send = new Intent(SignUp.this, Login.class);
            startActivity(send);
        });
    }
}