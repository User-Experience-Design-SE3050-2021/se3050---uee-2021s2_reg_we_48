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

public class ProductViewActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
ImageView bk;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_product_view);
         Button btn1 = (Button) findViewById(R.id.btn_wish);
         Button btn2 = (Button) findViewById(R.id.btn_crt);
         Button btn3 = (Button) findViewById(R.id.button);
         bk = findViewById(R.id.imageView21);


         btn3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 PopupMenu popup = new PopupMenu(ProductViewActivity.this, v);
                 popup.setOnMenuItemClickListener(ProductViewActivity.this);
                 popup.inflate(R.menu.size);
                 popup.show();
             }
         });

         btn1.setOnClickListener(view -> {
             Toast.makeText(getApplicationContext(), "Item Added to wishlist successfully", Toast.LENGTH_SHORT).show();
             Intent send = new Intent(ProductViewActivity.this, Wishlist.class);
             startActivity(send);
         });

         btn2.setOnClickListener(view -> {
             Toast.makeText(getApplicationContext(), "Item Added to cart successfully", Toast.LENGTH_SHORT).show();
             Intent send = new Intent(ProductViewActivity.this, Cart.class);
             startActivity(send);
         });

         bk.setOnClickListener(view -> {
             Intent send = new Intent(ProductViewActivity.this, WomenItemList.class);
             startActivity(send);
         });



     }
    @Override
    public boolean onMenuItemClick(MenuItem item) {


        Toast.makeText(this, "Selected Item: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {

            case R.id.search_item1:

                Intent send = new Intent(ProductViewActivity.this, WomenItemList.class);
                startActivity(send);

                return true;

            case R.id.upload_item1:

                Intent send1 = new Intent(ProductViewActivity.this, MenItemListActivity.class);
                startActivity(send1);


                return true;
            case R.id.copy_item:
                Intent send2 = new Intent(ProductViewActivity.this, ShoeItemListActivity.class);
                startActivity(send2);
                return true;
            case R.id.print_item:
                Intent send3 = new Intent(ProductViewActivity.this, HomeItemListActivity.class);
                startActivity(send3);
                return true;

            default:
                return false;
        }
    }
}