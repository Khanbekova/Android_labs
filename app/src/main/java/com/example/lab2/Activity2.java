package com.example.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class Activity2 extends AppCompatActivity {
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Act2Tag" , "OnStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Act2Tag" , "OnResume");
    }
    protected void onPause() {
        super.onPause();
        Log.d("Act2Tag" , "onPause");
    }
    protected void onStop() {
        super.onStop();
        Log.d("Act2Tag" , "onStop");
    }
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Act2Tag" , "onDestroy");
    }
    protected void onRestart() {
        super.onRestart();
        Log.d("Act2Tag" , "onRestart");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        Bundle arguments = getIntent().getExtras();
        String user = arguments.get("hello").toString();

        setContentView(R.layout.activity_2);
        ArrayList<String> StringArray = new ArrayList<String>();
        ArrayAdapter<String> TextAdapter;
        EditText editText = findViewById(R.id.editTextTextPersonName2);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        ListView listView = findViewById(R.id.textList);

        TextAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, StringArray);
        listView.setAdapter(TextAdapter);
        StringArray.add(user);
        super.onCreate(savedInstanceState);
        Log.d("Act2Tag" , "onCreate");
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringArray.add(editText.getText().toString());
                TextAdapter.notifyDataSetChanged();
                editText.setText("");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity2.this, Activity1.class);
                Log.d("Act2Tag" , "CallAct1");
                startActivity(intent);

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                listView.setSelector(R.color.green);
                // получаем нажатый элемент
                //String user = TextAdapter.getItem(position);
                listView.setItemChecked(position, true);
                listView.setSelection(position);
                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        listView.setSelector(android.R.color.transparent);
                        listView.isItemChecked(position);
                        StringArray.remove(position);

                        TextAdapter.notifyDataSetChanged();

                    }

                });

            }


        });

    }


}