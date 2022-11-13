package com.example.lab2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DelUserActivity extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    public static final String APP_PREFERENCES = "mysettings";
    public static final int APP_PREFERENCES_THEME = 1;
    int positionTheme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle bundle = getIntent().getExtras();
        String user = bundle.get("hello").toString();
        SharedPreferences sharedPrefTheme =  this.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor1 = sharedPrefTheme.edit();
        positionTheme = sharedPrefTheme.getInt(user, 1);
        if (positionTheme == 0){
            setTheme(R.style.ThemeNight_Lab2);
        }
        else{
            setTheme(R.style.ThemeLight_Lab2);
        }

        setContentView(R.layout.actuvity4);

        Button button = findViewById(R.id.button11);
        EditText editText = findViewById(R.id.editTextTextPersonName4);

        super.onCreate(savedInstanceState);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteUser(editText.getText().toString());

                Intent intent = new Intent(DelUserActivity.this, MainActivity.class);
                intent.putExtra("hello", user);
                Log.d("Act4Tag" , "CallAct2");
                startActivity(intent);
            }
        });
    }
}