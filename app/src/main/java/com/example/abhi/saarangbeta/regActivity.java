package com.example.abhi.saarangbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

/* Class implements the registration page. Data (default spinner value) is sent from DisplayDetails*/

public class regActivity extends AppCompatActivity {
    public String title, subtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        //Receiving data from DisplayDetails.java
        title = getIntent().getExtras().getString(displayDetails.TITLE_MESSAGE);
        subtitle = getIntent().getExtras().getString(displayDetails.SUBTITLE_MESSAGE);
        int position = getIntent().getExtras().getInt(displayDetails.POS_MESSAGE);

        //ActionBar initialization and properties
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Registration");

        //Setting Title
        TextView test = (TextView) findViewById(R.id.testtitle);
        test.setText("Registration for Saarang 2017");

        //List for spinner dropdown menu
        List<String> events = new ArrayList<>();
        events.add("Decibels");
        events.add("Acapella");
        events.add("Alankaar");
        events.add("Street Play");
        events.add("World Culture Show");
        events.add("Scrabble");

        //set this list as the dropdown using an ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, events);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //spinner initialization
        Spinner spinner = (Spinner) findViewById(R.id.regSpinner);
        //spinner.setPrompt("Hello World!!!"); //NOT WORKING!
        spinner.setAdapter(adapter);
        spinner.setSelection(position);
    }

    //Function called on clicking Register button. Goes to MainActivity after certain checks
    public void registerButton(View view) {

        EditText phno = (EditText)findViewById(R.id.phonenumber);
        /*Checking if any of the field in the form are not filled
        Check for lastname is excluded for people without last names
        Check for Spinner value is excluded since it cannot take an empty value
        Check for phno also checks if only 10 digits are included by using regex
        A variable is created for phno to avoid multiple calls to findViewById()
        */
        if( ( (EditText)findViewById(R.id.firstname) ).getText().toString().isEmpty() )
            Toast.makeText(this, "First name field is required.", Toast.LENGTH_SHORT).show();
        else if( ( (EditText)findViewById(R.id.email) ).getText().toString().isEmpty() )
            Toast.makeText(this, "Email ID field is required.", Toast.LENGTH_SHORT).show();
        else if( phno.getText().toString().isEmpty() )
            Toast.makeText(this, "Phone number field is required.", Toast.LENGTH_SHORT).show();
        else if( !(phno.getText().toString().matches("[0-9]{10}")) )
            Toast.makeText(this, "Please enter a valid 10 digit phone number.", Toast.LENGTH_SHORT).show();
        else if( ( (EditText)findViewById(R.id.collegename) ).getText().toString().isEmpty() )
            Toast.makeText(this, "College name field is required.", Toast.LENGTH_SHORT).show();
        else {
            Toast.makeText(this, "Successfully Registered.", Toast.LENGTH_LONG).show();
            Intent goHome = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(goHome);
        }
    }

    //ActionBar operations
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent backToDetails = new Intent(getApplicationContext(), displayDetails.class);
        backToDetails.putExtra(SimpleAdapter.TITLE_MESSAGE, title);
        backToDetails.putExtra(SimpleAdapter.SUBTITLE_MESSAGE, subtitle);
        startActivity(backToDetails);
        return true;
    }
}
