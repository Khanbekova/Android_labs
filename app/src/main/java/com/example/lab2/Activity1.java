package com.example.lab2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity1 extends Activity {
    public static final String APP_PREFERENCES = "mysettings";
    public static final int APP_PREFERENCES_THEME = 1;
    int positionTheme;
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
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Act1Tag" , "onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Act1Tag" , "onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Act1Tag" , "onDestroy");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Act1Tag" , "onRestart");
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedPrefTheme = this.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        positionTheme = sharedPrefTheme.getInt("position", 1);
        Log.d("Act1TagSTYLE" , String.valueOf(positionTheme));
        if (positionTheme == 0){
            setTheme(R.style.ThemeNight_Lab2);
            Log.d("Act1TagSTYLE" , "NIGHT_MODE");
        }
        else{
            setTheme(R.style.ThemeLight_Lab2);
        }

        setContentView(R.layout.activity_act1);
        EditText personName = findViewById(R.id.editTextTextPersonName);
        EditText password = findViewById(R.id.editTextTextPassword);

        SharedPreferences sharedPref1 = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences sharedPref2 = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor1 = sharedPref1.edit();
        SharedPreferences.Editor editor2 = sharedPref2.edit();
        personName.setText(sharedPref1.getString("text1",""));
        password.setText(sharedPref2.getString("text2",""));

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

                        editor1.putString("text1", personName.getText().toString());
                        editor1.apply();
                        editor2.putString("text2", password.getText().toString());
                        editor2.apply();
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