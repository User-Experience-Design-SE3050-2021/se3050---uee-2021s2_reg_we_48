package com.example.mirror;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {
    TextView MoveLogin;
    private EditText mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        mail = findViewById(R.id.etEmail2);
        MoveLogin = findViewById(R.id.log3);
        Button fg = findViewById(R.id.btn_forgot2);

        fg.setOnClickListener(view -> {
            String Mail = mail.getText().toString().trim();
            if(Mail.isEmpty()) {
                mail.setError("Email is required!");
            }else{
                Toast.makeText(getApplicationContext(), "Password has sent your mail address", Toast.LENGTH_SHORT).show();

            }
        });

        MoveLogin.setOnClickListener(view -> {
            Intent send = new Intent(ForgotPassword.this, Login.class);
            startActivity(send);
        });
    }
}