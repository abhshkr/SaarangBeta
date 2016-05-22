package com.example.abhi.saarangbeta;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/* Activity which shows the details of the chosen option from MainActivity
    Parent Activity: MainActivity
 */

public class displayDetails extends AppCompatActivity {
    //Data items obtained from MainActivity
    private DataInfo dataInfo;

    //Keys for Intent.putExtra()
    public final static String REG_MESSAGE = "abhi.android";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_details);

        TextView titleView = (TextView) findViewById(R.id.detailsTitle);
        TextView subtitleView = (TextView) findViewById(R.id.detailsSubtitle);

        //Receiving data from parent activity
        Intent intent = getIntent();
        dataInfo = (DataInfo) intent.getSerializableExtra(SimpleAdapter.DATA_MESSAGE);

        //Formatting display
        titleView.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG); //underlines title
        titleView.setText(dataInfo.getTitle());
        subtitleView.setTypeface(null, Typeface.ITALIC);    //italicizes subtitle
        subtitleView.setText(dataInfo.getSubtitle());

        ((TextView) findViewById(R.id.aboutDetails)).setText(dataInfo.getDetails());
        ((TextView) findViewById(R.id.coordDetails)).setText(dataInfo.getCoordName() + "\nPhone: " + dataInfo.getCoordPhoneNumber() + "\nEmail: " + dataInfo.getCoordEmail());
        ((TextView) findViewById(R.id.locationDetails)).setText(dataInfo.getLocation() + ", IIT Madras");

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMM dd, yyyy 'at' hh:mm aa");
        String date = sdf.format(dataInfo.getCalendar().getTime());
        ((TextView) findViewById(R.id.timeDetails)).setText(date);
        ((TextView) findViewById(R.id.prizeDetails)).setText("First: "+"\u20B9"+Integer.toString(dataInfo.getPrizeMoneyFirst())+
                "\nSecond: "+"\u20B9"+Integer.toString(dataInfo.getPrizeMoneySecond())+
                "\nThird: "+"\u20B9"+Integer.toString(dataInfo.getPrizeMoneyThird()));

        //ActionBar initialization and properties
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);      //enables back button
        actionBar.setTitle(dataInfo.getTitle());        //sets Title text
    }

    //Function for Call button
    public void callButton(View view) {
        Intent call = new Intent(Intent.ACTION_DIAL); //only dials the number, does not call (use ACTION_CALL to call directly)
        call.setData(Uri.parse("tel:" + dataInfo.getCoordPhoneNumber()));
        startActivity(call);
    }

    //Function for Email button
    public void emailButton(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{dataInfo.getCoordEmail()});
        startActivity(emailIntent);
    }

    //Function for Map button
    public void mapButton(View view) {
        Uri gmmIntentUri = Uri.parse("geo:12.990071, 80.230344?q=" + Uri.encode(dataInfo.getLocation()));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    //Function for Calendar button
    public void calendarButton(View view) {
        Intent calendarIntent = new Intent(Intent.ACTION_INSERT);
        calendarIntent.setType("vnd.android.cursor.item/event");
        calendarIntent.putExtra(CalendarContract.Events.TITLE, dataInfo.getTitle()+" - Saarang, IIT Madras");    //Event Title
        calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, dataInfo.getLocation()+", IIT Madras");  //Event Location
        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, dataInfo.getCalendar().getTimeInMillis());  //Event start time/date
        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, dataInfo.getCalendar().getTimeInMillis()+(int)(dataInfo.getDuration()*60*60*1000)); //event end time/date
        startActivity(calendarIntent);
    }

    /*Functions for ActionBar operations*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.regActivity:                      //Register button
                Intent goToRegister = new Intent(getApplicationContext(), regActivity.class);
                goToRegister.putExtra(displayDetails.REG_MESSAGE, dataInfo);
                startActivity(goToRegister);
                break;
            case android.R.id.home:                     //Back button
                NavUtils.navigateUpFromSameTask(this);  //ParentActivity is defined as MainActivity in Manifest
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
