package com.example.abhi.saarangbeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/*Main Activity - App starts here*/

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ActionBar initialization and properties
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Saarang 2017");

        /*actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.callicon);   //To set an icon on toolbar */

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);                // Setting toolbar as the ActionBar with setSupportActionBar() call*/

        //Setting RecyclerView layout and adapter (Adapter is in SimpleAdapter.java)
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter( new SimpleAdapter() );
    }
}