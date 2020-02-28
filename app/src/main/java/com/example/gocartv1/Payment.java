package com.example.gocartv1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Button cash = (Button)findViewById(R.id.cash);
        Button upi = (Button)findViewById(R.id.upi);

        cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Payment.this,"Go to cash counter",Toast.LENGTH_LONG).show();
            }
        });
        upi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Payment.this,"UPI portal coming soon",Toast.LENGTH_LONG).show();
            }
        });
    }
}
