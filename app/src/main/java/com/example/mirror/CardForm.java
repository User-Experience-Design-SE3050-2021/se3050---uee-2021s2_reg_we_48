package com.example.mirror;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class CardForm extends AppCompatActivity {

    private EditText amount, name, number, cvv, date;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_form);
        setTitle("Card Payment");
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        context = this;
        Button payid = findViewById(R.id.paybt);
        name = findViewById(R.id.cardname);
        amount = findViewById(R.id.amount_et);
        number = findViewById(R.id.getcardnum);
        cvv = findViewById(R.id.cvv_et);
        date = findViewById(R.id.exdate_et);

        payid.setOnClickListener(v -> {

            String etName = name.getText().toString();
            String etAmount = amount.getText().toString();
            String etNumber = number.getText().toString();
            String etCvv = cvv.getText().toString();
            String etDate = date.getText().toString();

            if (TextUtils.isEmpty(etAmount)) {
                Toast.makeText(CardForm.this, "Please enter recharge amount", Toast.LENGTH_LONG).show();
                amount.setError("Amount is required");
                amount.requestFocus();
            } else if (TextUtils.isEmpty(etName)) {
                Toast.makeText(CardForm.this, "Please enter your name", Toast.LENGTH_LONG).show();
                name.setError("Name is required");
                name.requestFocus();
            } else if (TextUtils.isEmpty(etNumber)) {
                Toast.makeText(CardForm.this, "Please enter card number", Toast.LENGTH_LONG).show();
                number.setError("Number is required");
                number.requestFocus();
            } else if (TextUtils.isEmpty(etCvv)) {
                Toast.makeText(CardForm.this, "Please enter cvv", Toast.LENGTH_LONG).show();
                cvv.setError("CVV is required");
                cvv.requestFocus();
            } else if (TextUtils.isEmpty(etDate)) {
                Toast.makeText(CardForm.this, "Please enter date", Toast.LENGTH_LONG).show();
                date.setError("Date is required");
                date.requestFocus();
            } else if (etNumber.length() != 16) {
                Toast.makeText(CardForm.this, "Please re-enter your card number", Toast.LENGTH_LONG).show();
                number.setError("Card Number should be 16 digits");
                number.requestFocus();
            } else if (etCvv.length() != 3) {
                Toast.makeText(CardForm.this, "Please re-enter your cvv number", Toast.LENGTH_LONG).show();
                cvv.setError("CVV Number should be 3 digits");
                cvv.requestFocus();
            } else {
                Toast.makeText(getApplicationContext(), "Your order is confirmed", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(context, Store.class));
            }
        });
    }
}