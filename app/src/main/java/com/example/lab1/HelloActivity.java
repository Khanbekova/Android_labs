package com.example.lab1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HelloActivity extends Activity {
    TextView textviewckicks1,textviewckicks2;
    int clicks1 = 0, clicks2 = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helloact);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        textviewckicks1=findViewById(R.id.textviewckicks1);
        textviewckicks2=findViewById(R.id.textviewckicks2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicks2++;
                button2.setEnabled(true);
                button1.setEnabled(false);
                textviewckicks2.setText(String.valueOf(clicks2));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicks1++;
                button1.setEnabled(true);
                button2.setEnabled(false);
                textviewckicks1.setText(String.valueOf(clicks1));
            }
        });

    }



}
