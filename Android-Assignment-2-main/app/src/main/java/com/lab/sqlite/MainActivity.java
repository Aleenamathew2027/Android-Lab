package com.lab.sqlite;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText t1;
    Button b1;
Button b2;

TextView t2;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (EditText) findViewById(R.id.t1);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        t2 = (TextView) findViewById(R.id.t2);

        dbHelper = new DatabaseHelper(this);
    }
        public void addme(View view){
            String name = t1.getText().toString().trim();

            if (dbHelper.addName(name)) {
                Toast.makeText(this, "Name added", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "failed to add name", Toast.LENGTH_SHORT).show();
            }
        }
    public void show(View view){
        String names = dbHelper.getAllNames();
        t2.setText(names);
    }
    }

