package com.example.mirror;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class ProfileOptions extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_options);
        Button btn = (Button) findViewById(R.id.btnShow);
        back = findViewById(R.id.imageView21);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(ProfileOptions.this, v);
                popup.setOnMenuItemClickListener(ProfileOptions.this);
                popup.inflate(R.menu.menu_example);
                popup.show();
            }
        });

        back.setOnClickListener(view -> {
            Intent send = new Intent(ProfileOptions.this, Store.class);
            startActivity(send);
        });


    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {


        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {

            case R.id.search_item1:

                Intent send = new Intent(ProfileOptions.this, Profile.class);
                startActivity(send);

                return true;

            case R.id.upload_item1:

                Intent send1 = new Intent(ProfileOptions.this, UpdateAddress.class);
                startActivity(send1);


                return true;
            case R.id.copy_item:
                Intent send2 = new Intent(ProfileOptions.this, Feedback.class);
                startActivity(send2);
                return true;
            case R.id.print_item:
                Intent send3 = new Intent(ProfileOptions.this, Login.class);
                startActivity(send3);
                return true;

            default:
                return false;
        }
    }


}
