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
    private DataInfo dataInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        //Receiving data from DisplayDetails.java
        dataInfo = (DataInfo) getIntent().getSerializableExtra(displayDetails.REG_MESSAGE);

        //ActionBar initialization and properties
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Registration");

        //Setting Title
        ((TextView) findViewById(R.id.testtitle)).setText("Registration for Saarang 2017");

        //List for spinner dropdown menu
        List<String> events = new ArrayList<>();

        //Adding event names to the Spinner list
        for(int i=0;i<MainActivity.getDataSize();i++){
            events.add(MainActivity.getDataTitle(i));
        }

        //set this list as the dropdown using an ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, events);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Spinner Operations
        Spinner spinner = (Spinner) findViewById(R.id.regSpinner);
        //spinner.setPrompt("Hello World!!!"); //NOT WORKING!
        spinner.setAdapter(adapter);
        spinner.setSelection(dataInfo.getId());
    }

    //Function called on clicking Register button. Goes to MainActivity after certain checks
    public void registerButton(View view) {

        EditText phno = (EditText) findViewById(R.id.phonenumber);
        /*Checking if any of the field in the form are not filled
        Check for lastname is excluded for people without last names
        Check for Spinner value is excluded since it cannot take an empty value
        Check for phno also checks if only 10 digits are included by using regex
        A variable is created for phno to avoid multiple calls to findViewById()
        */
        if (((EditText) findViewById(R.id.firstname)).getText().toString().isEmpty())
            Toast.makeText(this, "First name field is required.", Toast.LENGTH_SHORT).show();
        else if (((EditText) findViewById(R.id.email)).getText().toString().isEmpty())
            Toast.makeText(this, "Email ID field is required.", Toast.LENGTH_SHORT).show();
        else if (phno.getText().toString().isEmpty())
            Toast.makeText(this, "Phone number field is required.", Toast.LENGTH_SHORT).show();
        else if (!(phno.getText().toString().matches("[0-9]{10}")))
            Toast.makeText(this, "Please enter a valid 10 digit phone number.", Toast.LENGTH_SHORT).show();
        else if (((EditText) findViewById(R.id.collegename)).getText().toString().isEmpty())
            Toast.makeText(this, "College name field is required.", Toast.LENGTH_SHORT).show();
        else {
            Toast.makeText(this, "Successfully Registered.", Toast.LENGTH_LONG).show();
            //TODO - store the data in a file here
            Intent goHome = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(goHome);
        }
    }

    //ActionBar operations
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent backToDetails = new Intent(getApplicationContext(), displayDetails.class);
       backToDetails.putExtra(SimpleAdapter.DATA_MESSAGE,dataInfo);
        startActivity(backToDetails);
        return true;
    }
}
