package com.example.lab2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity1 extends Activity {
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Act1Tag" , "OnStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Act1Tag" , "OnResume");
    }
    protected void onPause() {
        super.onPause();
        Log.d("Act1Tag" , "onPause");
    }
    protected void onStop() {
        super.onStop();
        Log.d("Act1Tag" , "onStop");
    }
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Act1Tag" , "onDestroy");
    }
    protected void onRestart() {
        super.onRestart();
        Log.d("Act1Tag" , "onRestart");
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {


        setContentView(R.layout.activity_act1);
        EditText personName = findViewById(R.id.editTextTextPersonName);
        EditText password = findViewById(R.id.editTextTextPassword);

        Button btnActTwo = findViewById(R.id.button);
        super.onCreate(savedInstanceState);
        Log.d("Act1Tag" , "onCreate");
        btnActTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if ((TextUtils.isEmpty(personName.getText()))&&(TextUtils.isEmpty(password.getText()))){
                   return;
                }
               else {
                   if ((personName.getText().toString().equals("Elena"))&&(password.getText().toString().equals("1234"))) {
                       Intent intent = new Intent(Activity1.this, Activity2.class);
                       intent.putExtra("hello", (personName.getText().toString()));
                       Log.d("Act1Tag" , "CallAct2");
                       startActivity(intent);
                   }
               }
            }
        });


    }



}