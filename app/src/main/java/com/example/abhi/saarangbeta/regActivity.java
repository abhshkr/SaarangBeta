package com.example.abhi.saarangbeta;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class regActivity extends AppCompatActivity {
    public String title, subtitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        Intent intent = getIntent();
        title = intent.getStringExtra(displayDetails.TITLE_MESSAGE);
        subtitle = intent.getStringExtra(displayDetails.SUBTITLE_MESSAGE);
        String position = intent.getExtras().getString(displayDetails.POS_MESSAGE);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle((position));
        TextView test = (TextView) findViewById(R.id.testtitle);
        test.setText(title);

        Spinner spinner = (Spinner) findViewById(R.id.regSpinner);
        //spinner.setPrompt("Hello World!!!"); //NOT WORKING!

        List<String> events = new ArrayList<>();
        events.add("Decibels");
        events.add("Acapella");
        events.add("Alankaar");
        events.add("Street Play");
        events.add("World Culture Show");
        events.add("Scrabble");
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, events);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(4);
    }
    public final static String TITLE_MESSAGE = "hello";
    public final static String SUBTITLE_MESSAGE = "hi";

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), displayDetails.class);
        myIntent.putExtra(TITLE_MESSAGE,title);
        myIntent.putExtra(SUBTITLE_MESSAGE,subtitle);
        startActivityForResult(myIntent, 0);
        return true;
    }

}
