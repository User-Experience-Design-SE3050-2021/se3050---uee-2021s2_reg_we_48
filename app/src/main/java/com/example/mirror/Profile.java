package com.example.mirror;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Profile extends AppCompatActivity {
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button update = findViewById(R.id.btn_update);
        Button cancel = findViewById(R.id.btn_cancel);
        back = findViewById(R.id.imageView21);

        update.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "Updated successfully", Toast.LENGTH_SHORT).show();
            Intent send = new Intent(Profile.this, Store.class);
            startActivity(send);
        });

        cancel.setOnClickListener(view -> {
            Intent send = new Intent(Profile.this, Store.class);
            startActivity(send);
        });

        back.setOnClickListener(view -> {
            Intent send = new Intent(Profile.this, ProfileOptions.class);
            startActivity(send);
        });

    }
}