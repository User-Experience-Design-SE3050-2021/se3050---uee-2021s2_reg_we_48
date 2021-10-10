package com.example.mirror;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class Cart extends AppCompatActivity {
    ImageView bck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Button cont = findViewById(R.id.btn_shopping);
        Button check = findViewById(R.id.btn_checkout);
        bck = findViewById(R.id.imageView21);


        cont.setOnClickListener(view -> {
            Intent send = new Intent(Cart.this, Store.class);
            startActivity(send);
        });

        check.setOnClickListener(view -> {
            Intent send = new Intent(Cart.this, Addresses.class);
            startActivity(send);
        });

        bck.setOnClickListener(view -> {
            Intent send = new Intent(Cart.this, WomenItemList.class);
            startActivity(send);
        });
    }
}