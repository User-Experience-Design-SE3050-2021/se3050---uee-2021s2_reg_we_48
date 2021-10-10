package com.example.mirror;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Review extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        setTitle("Review Your Order");
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Spinner spinner = findViewById(R.id.spDelivery);
        ImageButton edit = findViewById(R.id.editAdd);
        Button payment = findViewById(R.id.btn_payment);

        List<String> deliveries = new ArrayList<>();
        deliveries.add(0, "Select Shipping Method");
        deliveries.add("Courier Delivery (Delivery Within 3 Days)   Rs 200");
        deliveries.add("Registered Post Delivery (4-7 Working Days) Rs 350");

        //style and populate the spinner
        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, deliveries);

        //dropdown layout style
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (!adapterView.getItemAtPosition(i).equals("Select Shipping Method")) {
                    //on selecting a spinner item
                    String item = adapterView.getItemAtPosition(i).toString();

                    //show selected spinner item
                    Toast.makeText(adapterView.getContext(), "Selected "+item, Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(adapterView.getContext(), "Please select the delivery area", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String method = spinner.getSelectedItem().toString();
        edit.setOnClickListener(view -> {
            Intent send = new Intent(Review.this, UpdateAddress.class);
            startActivity(send);
        });

        payment.setOnClickListener(view -> {
            Intent send = new Intent(Review.this, PaymentMenu.class);
            startActivity(send);

        });

    }
}