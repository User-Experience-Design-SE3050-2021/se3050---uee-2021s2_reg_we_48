package com.example.mirror;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class ShoeItemListActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener  {
    ImageView st,ct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoe_item_list);
        Button btn = (Button) findViewById(R.id.btnShow2);
        Button btn2 = (Button) findViewById(R.id.button);
        st = findViewById(R.id.imageView6);
        ct = findViewById(R.id.imageView8);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(ShoeItemListActivity.this, v);
                popup.setOnMenuItemClickListener(ShoeItemListActivity.this);
                popup.inflate(R.menu.catergory);
                popup.show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(ShoeItemListActivity.this, v);
                popup.setOnMenuItemClickListener(ShoeItemListActivity.this);
                popup.inflate(R.menu.sort);
                popup.show();
            }
        });

        st.setOnClickListener(view -> {
            Intent send = new Intent(ShoeItemListActivity.this, Store.class);
            startActivity(send);
        });

        ct.setOnClickListener(view -> {
            Intent send = new Intent(ShoeItemListActivity.this, Cart.class);
            startActivity(send);
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {


        Toast.makeText(this, "Selected Item: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {

            case R.id.search_item1:

                Intent send = new Intent(ShoeItemListActivity.this, WomenItemList.class);
                startActivity(send);

                return true;

            case R.id.upload_item1:

                Intent send1 = new Intent(ShoeItemListActivity.this, MenItemListActivity.class);
                startActivity(send1);


                return true;
            case R.id.copy_item:
                Intent send2 = new Intent(ShoeItemListActivity.this, ShoeItemListActivity.class);
                startActivity(send2);
                return true;
            case R.id.print_item:
                Intent send3 = new Intent(ShoeItemListActivity.this, HomeItemListActivity.class);
                startActivity(send3);
                return true;

            default:
                return false;
        }
    }
}