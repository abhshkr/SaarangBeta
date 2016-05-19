package com.example.abhi.saarangbeta;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class displayDetails extends AppCompatActivity {
    public String title, subtitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_details);

        TextView titleView = (TextView) findViewById(R.id.detailsTitle);
        TextView subtitleView = (TextView) findViewById(R.id.detailsSubtitle);

        Intent intent = getIntent();
        title = intent.getStringExtra(SimpleAdapter.TITLE_MESSAGE);
        subtitle = intent.getStringExtra(SimpleAdapter.SUBTITLE_MESSAGE);
        titleView.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        titleView.setText(title);
        subtitleView.setTypeface(null, Typeface.ITALIC);
        subtitleView.setText(subtitle);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(title);
    }
    public final static String TITLE_MESSAGE = "abhi.android";
    public final static String SUBTITLE_MESSAGE="abhi.android2";
    public final static String POS_MESSAGE="abhi.android3";

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent;

        switch (item.getItemId()) {
            case R.id.regActivity:
                myIntent = new Intent(getApplicationContext(), regActivity.class);
                myIntent.putExtra(TITLE_MESSAGE,title);
                myIntent.putExtra(SUBTITLE_MESSAGE,subtitle);
                myIntent.putExtra(POS_MESSAGE,"Hello");
                startActivityForResult(myIntent, 0);
                break;
            case android.R.id.home:
//                myIntent = new Intent(getApplicationContext(), MainActivity.class);
                NavUtils.navigateUpFromSameTask(this);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

}
