package com.example.mirror;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private EditText name, address, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Add New Shipping Address");
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        name = findViewById(R.id.etName);
        address = findViewById(R.id.etAddress);
        phone = findViewById(R.id.etPhone);
        Button save = findViewById(R.id.btn_save);
        Button cancel = findViewById(R.id.btn_cancel);
        Spinner spinner = findViewById(R.id.spArea);

        List<String> disticts = new ArrayList<>();
        disticts.add(0, "Delivery Area");
        disticts.add("Colombo");
        disticts.add("Gampaha");
        disticts.add("Kalutara");
        disticts.add("Galle");
        disticts.add("Matara");
        disticts.add("Nuwara Eliya");
        disticts.add("Hambanthota");
        disticts.add("Kandy");
        disticts.add("Rathnapura");

        //style and populate the spinner
        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, disticts);

        //dropdown layout style
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (!adapterView.getItemAtPosition(i).equals("Delivery Area")) {
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

        save.setOnClickListener(view -> {
            String fullName = name.getText().toString().trim();
            String fullAddress = address.getText().toString().trim();
            String Phone = phone.getText().toString().trim();
            String area = spinner.getSelectedItem().toString();

            if(fullName.isEmpty()){
                name.setError("Full Name is required!");
            }else if (fullAddress.isEmpty()){
                address.setError("Full Address is required!");
            }else if (Phone.isEmpty()){
                phone.setError("Phone number is required!");
            }else if (Phone.length() < 10) {
                phone.setError("Please enter valid phone number!");
            }else if (area.equals("Delivery Area")){
                Toast.makeText(getApplicationContext(), "Please select a delivery area", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(), "Your Address successfully saved", Toast.LENGTH_SHORT).show();
                Intent send = new Intent(MainActivity.this, Addresses.class);
                startActivity(send);
            }
        });

        cancel.setOnClickListener(view -> {
            Intent send = new Intent(MainActivity.this, Addresses.class);
            startActivity(send);
        });

    }
}