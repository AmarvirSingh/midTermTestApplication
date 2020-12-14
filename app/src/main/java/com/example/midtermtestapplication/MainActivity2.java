package com.example.midtermtestapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    TextView welcome, hours, fees, totalfees, totalhours;
    Button add;
    CheckBox cb1,cb2;
    RadioButton rb1,rb2;
    Spinner spinner;

    ArrayList<data> list = new ArrayList<>();
    String course [] = {"Java", "Swift", "IOS", "Android", "Database"};
    Boolean one, two = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // creating connewctions
        welcome = findViewById(R.id.welcome);
        hours = findViewById(R.id.hours);
        fees = findViewById(R.id.fees);
        totalfees = findViewById(R.id.totalfees);
        totalhours = findViewById(R.id.totalhours);
        add = findViewById(R.id.btnAdd);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        spinner = findViewById(R.id.spinner);

        // welcome message with the name
        welcome.setText("Welcome " + MainActivity.entername);

        // filling data
        fillData();

        // creating event for spinner
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,course);
        spinner.setAdapter(aa);
        spinner.setOnItemSelectedListener(this);

        // creating even t for radioButtons

        rb1.setOnClickListener(this);
        rb1.setChecked(true);
        one = true;
        rb2.setOnClickListener(this);

        // creatinf event for checkboxes
        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);

        // caretinf event for button
        add.setOnClickListener(this);
    }

    public void fillData(){
        list.add(new data("Java","1300","6"));
        list.add(new data("Swift","1500","5"));
        list.add(new data("IOS","1350","5"));
        list.add(new data("Android","1400","7"));
        list.add(new data("Database","1000","4"));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    fees.setText(list.get(position).getFees());
    hours.setText(list.get(position).getHrs());


    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.rb1) {
            one = true;
            two = false;
            reset();
        } else if (v.getId() == R.id.rb2) {
            two = true;
            one = false;
            reset();
        } else if (v.getId() == R.id.btnAdd) {
            double totFees = Double.parseDouble(totalfees.getText().toString());
            double totHrs = Double.parseDouble(totalhours.getText().toString());
            totHrs += Double.parseDouble(hours.getText().toString());

            if (one == true ) {
                if (totHrs <= 19) {
                    totFees += Double.parseDouble(fees.getText().toString());

                 totalhours.setText(String.valueOf(totHrs));
                    totalfees.setText(String.valueOf(totFees));
                } else {
                    Toast.makeText(getApplicationContext(), "You can not add this course  ", Toast.LENGTH_LONG).show();
                }
            }
           else if (two == true ) {

                if (totHrs <= 21) {
                    totFees += Double.parseDouble(fees.getText().toString());

                    totalhours.setText(String.valueOf(totHrs));
                    totalfees.setText(String.valueOf(totFees));
                } else {
                    Toast.makeText(getApplicationContext(), "You can not add This course", Toast.LENGTH_LONG).show();
                }
            }
            }
        }



    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        double tot = Double.parseDouble(totalfees.getText().toString());

        if (buttonView.getId() == R.id.cb1){
        if(cb1.isChecked()){
            tot += 1000;
            totalfees.setText(String.valueOf(tot));
        }
        else{
            tot -= 1000;
            totalfees.setText(String.valueOf(tot));
        }
    }
    else if (buttonView.getId() == R.id.cb2){
        if (cb2.isChecked()){
            tot += 700;
            totalfees.setText(String.valueOf(tot));
        }
        else
        {
            tot-=700;
            totalfees.setText(String.valueOf(tot));
        }
    }
    }

    public void reset (){
        cb1.setChecked(false);
        cb2.setChecked(false);
        totalfees.setText(String.valueOf(0));
        totalhours.setText(String.valueOf(0));


    }
}