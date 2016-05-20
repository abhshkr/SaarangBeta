package com.example.abhi.saarangbeta;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/* Activity which shows the details of the chosen option from MainActivity
    Parent Activity: MainActivity
 */

public class displayDetails extends AppCompatActivity {
    //Data items obtained from MainActivity
    public String title, subtitle;
    public int position;

    //Keys for Intent.putExtra()
    public final static String TITLE_MESSAGE = "abhi.android";
    public final static String SUBTITLE_MESSAGE = "abhi.android2";
    public final static String POS_MESSAGE = "abhi.android3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_details);

        TextView titleView = (TextView) findViewById(R.id.detailsTitle);
        TextView subtitleView = (TextView) findViewById(R.id.detailsSubtitle);

        //Receiving data from parent activity
        Intent intent = getIntent();
        title = intent.getStringExtra(SimpleAdapter.TITLE_MESSAGE);
        subtitle = intent.getStringExtra(SimpleAdapter.SUBTITLE_MESSAGE);
        position = intent.getExtras().getInt(SimpleAdapter.POS_MESSAGE);

        //Formatting the display
        titleView.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        titleView.setText(title);
        subtitleView.setTypeface(null, Typeface.ITALIC);
        subtitleView.setText(subtitle);

        //ActionBar initialization and properties
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(title);
    }

    /*Functions for calling, opening MapActivity. onClick attribute given to buttons, directing to these functions */
    public void callButton(View view) {
        Intent call = new Intent(Intent.ACTION_DIAL);
        call.setData(Uri.parse("tel:9731804361"));
        try {
            startActivity(call);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getApplicationContext(), "yourActivity is not founded", Toast.LENGTH_SHORT).show();
        }
    }

    public void mapButton(View view) {
        Intent map = new Intent(getApplicationContext(), MapActivity.class);
        try {
            startActivity(map);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getApplicationContext(), "yourActivity is not founded", Toast.LENGTH_SHORT).show();
        }
    }

    /*Functions for ActionBar operations*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.regActivity:
                Intent goToRegister;
                goToRegister = new Intent(getApplicationContext(), regActivity.class);
                goToRegister.putExtra(TITLE_MESSAGE, title);
                goToRegister.putExtra(SUBTITLE_MESSAGE, subtitle);
                goToRegister.putExtra(POS_MESSAGE, position);
                startActivity(goToRegister);
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
