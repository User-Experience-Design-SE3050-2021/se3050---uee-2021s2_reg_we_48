package com.example.mirror;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        final ImageView wishlist = (ImageView) findViewById(R.id.imageWishlistFilled);
        wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Wishlist.class);
                startActivity(i);

            }
        });

        final ImageView backProfile = (ImageView) findViewById(R.id.imageView21);
        backProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ProfileOptions.class);
                startActivity(i);

            }
        });
    }
}