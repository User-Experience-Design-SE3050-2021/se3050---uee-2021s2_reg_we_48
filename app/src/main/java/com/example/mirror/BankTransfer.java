package com.example.mirror;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

public class BankTransfer extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_transfer);
        setTitle("Bank Transfer");
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        context = this;

        Button button = findViewById(R.id.btn_confirm);
        button.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "Your order is confirmed", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(context, Store.class));
        });
    }
}