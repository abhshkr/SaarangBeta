package com.example.abhi.saarangbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        //setSupportActionBar(toolbar);                   // Setting toolbar as the ActionBar with setSupportActionBar() call

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Saarang 2017");

        /*actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.callicon);   //To set an icon on toolbar */

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new SimpleAdapter());
    }

    //public final static String TITLE_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";
    //public final static String SUBTITLE_MESSAGE = "com.mycompany.myfirstapp.NEWMESSAGE";
    //    public void openDetails(View view) {
    //        Intent intent = new Intent(this, displayDetails.class);
    //
    //        TextView titleView = (TextView) findViewById(R.id.title);
    //        String title = titleView.getText().toString();
    //        intent.putExtra(TITLE_MESSAGE, title);
    //
    //        TextView subtitleView = (TextView) findViewById(R.id.subtitle);
    //        String subtitle = subtitleView.getText().toString();
    //        intent.putExtra(SUBTITLE_MESSAGE, subtitle);
    //
    //        startActivity(intent);
    //    }

}