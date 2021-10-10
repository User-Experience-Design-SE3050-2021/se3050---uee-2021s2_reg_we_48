package com.example.mirror;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Objects;

public class PaymentMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_menu);
        setTitle("Make Payment");
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        CheckBox terms = findViewById(R.id.checkBox);
        RadioButton rButton1 = findViewById(R.id.radioButton1);
        RadioButton rButton2 = findViewById(R.id.radioButton2);
        Button con = findViewById(R.id.btn_continue);

        con.setOnClickListener(view -> {
            if(terms.isChecked()) {
                if (rButton1.isChecked()) {
                    Intent intent = new Intent(PaymentMenu.this, BankTransfer.class);
                    startActivity(intent);
                } else if (rButton2.isChecked()) {
                    Intent intent = new Intent(PaymentMenu.this, CardPayment.class);
                    startActivity(intent);
                }
            }else{
                Toast.makeText(getApplicationContext(), "Your must agree to the Terms and Conditions!", Toast.LENGTH_LONG).show();
            }
        });



    }
}