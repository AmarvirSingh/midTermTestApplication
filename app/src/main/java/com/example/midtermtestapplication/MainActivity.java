package com.example.midtermtestapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    public static String entername = "";
    EditText name, username, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (username.getText().toString().isEmpty() || password.getText().toString().isEmpty() || name.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Please Fill all the fields",Toast.LENGTH_LONG).show();
        }
        else if (!username.getText().toString().equals("student1") || !password.getText().toString().equals("123456")){
            Toast.makeText(getApplicationContext(),"Wrong username or password",Toast.LENGTH_LONG).show();
        }
        else {
            entername = name.getText().toString();
            Intent i = new Intent(this,MainActivity2.class);
            startActivity(i);
        }
    }
}