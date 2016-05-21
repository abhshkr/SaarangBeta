package com.example.abhi.saarangbeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/*Main Activity - App starts here*/

public class MainActivity extends AppCompatActivity {
    //data is stored here
    private static List<DataInfo> data;

    //Constructor to provide data - This data can be read from a file later
    public MainActivity(){

        data = new ArrayList<>();
        //Adding the new data to the list
        //"January 6","10:00AM",
        data.add(new DataInfo(0,"Vox","Western Music - Solo","Prerna Dhareshwar","9940510404",
                "prerana@gmail.com","Class Room Complex",new GregorianCalendar(2017,0,6,10,0,0), 2,"saarang1") );
        data.add(new DataInfo(1,"Decibels","Western Music - Band","Srikanth Musti","9790464090",
                "srikanth@gmail.com","Students Activity Center",new GregorianCalendar(2017,0,6,15,0,0),3.5,"saarang1") );
        data.add(new DataInfo(2,"Alankar","Light Music - Solo","Karun Kumar","8939233166",
                "karun@gmail.com","Central Lecture Theater",new GregorianCalendar(2017,0,7,11,0,0),3,"saarang1") );
        data.add(new DataInfo(3,"Unplugged","Light Music - Band","Anandi Puritipati","7200416557",
                "anandp@gmail.com","Central Lecture Theater",new GregorianCalendar(2017,0,7,14,0,0),3,"saarang1") );
        data.add(new DataInfo(4,"Scrabble","Word Games","Gaurav Lodha","9962121749",
                "glodha0@gmail.com","Class Room Complex",new GregorianCalendar(2017,0,8,12,0,0),2,"saarang1") );
        data.add(new DataInfo(5,"SpellBee","Word Games","Divyanjana Prashansa","9176489610",
                "divya150397@gmail.com","Class Room Complex",new GregorianCalendar(2017,0,8,16,0,0),1,"saarang1"));

        //Adding details for each data item to the list
        data.get(0).setDetails("Saarang gives you a platform to get out there and win hearts with your vocal talent. This solo singing competition" +
                " in two stages pushes you to discover the best in you. Held in one of the best venues on campus, Vox is definitely a great stage " +
                "for aspiring vocalists to showcase their talent.");
        data.get(1).setDetails("Think it’s time for your band to be launched into the limelight? Think you have what it takes to compete against " +
                "some of the best bands in the country? Then waste no time and sign your band up for Saarang Decibels 2017, one of India’s " +
                "premier competitions for semi-professional bands to make your claim to fame.");
        data.get(2).setDetails("So, you think you can go it alone onstage, be that one person army ( don't want to sound sexist there) and bring the" +
                " roof down with your vocal prowess? Looking for a spotlight that would shine on you and only you? Stop right there because now you " +
                "know where you ought to be. Introducing our one and only light music solo singing competition, Alankar, where you can battle it out " +
                "with over a hundred vocalists while being judged by the best singing talents out there. And then there is always the cash prize and " +
                "other awesome goodies to look forward to...");
        data.get(3).setDetails("“Raw, pure and sensile blend of voices, percussion, and strings”. Quaint and poignant, LM Unplugged  is here to " +
                "unleash a whole new world of music, devoid of electronic manipulation. An acoustic light music band event, Unplugged is for the " +
                "unconventional talents out there. Catapult yourself to a place where there are no distortions or pre-processing. Be it the packed " +
                "audience, the exciting prizes or the expert judges, for the potpourri of music lovers out there, Unplugged is certainly the place to be.");
        data.get(4).setDetails("Do you know what Zyzzva is? Do AA, ZA and XI make perfect sense to you? Got vocabulary that will QUIZZIFY your opponent?" +
                " Then Scrabble at Saarang is just the place for you! Have no clue what those words meant? Fret not, if you can spell, you can play " +
                "Scrabble. Just grab a partner and come battle it out for Scrabble glory. May the Q be with U!");
        data.get(5).setDetails("Do you have a knack for spelling? Fancy yourself a wizard with words? Are you enthusiastic for a battle of words with " +
                "your peers from across the country? Then sharpen your pencils and get ready, because IITM Spelling Bee is back for its fourth year " +
                "at Saarang!");
    }

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
        recyclerView.setAdapter( new SimpleAdapter(data) );
    }

    public static int getDataSize(){
        return data.size();
    }

    public static String getDataTitle(int index){
        return data.get(index).getTitle();
    }
}