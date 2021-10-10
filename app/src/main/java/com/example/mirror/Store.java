package com.example.mirror;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class Store extends AppCompatActivity {
    private ImageView women, profile,men,shoes,homeliving,ct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        women = findViewById(R.id.imageView12);
        profile = findViewById(R.id.imageprofile);
        men = findViewById(R.id.imageView13);
        shoes = findViewById(R.id.imageView14);
        homeliving = findViewById(R.id.imageView15);
        ct = findViewById(R.id.imageView8);

        profile.setOnClickListener(view -> {
            Intent send = new Intent(Store.this, ProfileOptions.class);
            startActivity(send);
        });

        women.setOnClickListener(view -> {
            Intent send = new Intent(Store.this, WomenItemList.class);
            startActivity(send);
        });

        men.setOnClickListener(view -> {
            Intent send = new Intent(Store.this, MenItemListActivity.class);
            startActivity(send);
        });
        shoes.setOnClickListener(view -> {
            Intent send = new Intent(Store.this, ShoeItemListActivity.class);
            startActivity(send);
        });
        homeliving.setOnClickListener(view -> {
            Intent send = new Intent(Store.this, HomeItemListActivity.class);
            startActivity(send);
        });
        ct.setOnClickListener(view -> {
            Intent send = new Intent(Store.this, Cart.class);
            startActivity(send);
        });
    }
}