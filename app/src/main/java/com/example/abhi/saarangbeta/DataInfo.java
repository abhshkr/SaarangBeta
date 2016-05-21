package com.example.abhi.saarangbeta;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

/*Definition of a class which holds the data model for details*/
public class DataInfo implements Serializable {
    int id;
    private String title;
    private String subtitle;
    private String imgSrc;
    private String details;
    private String location;
    private String date;
    private String time;
    Calendar calendar;
    double givenDuration;
    private String coordPhoneNumber;
    private String coordName;
    private String coordEmail;


    //Constructor
    //, String givendate, String giventime
    public DataInfo (int givenId, String ttl, String subttl, String name, String phoneNo, String emailID, String givenlocation, Calendar givenCalendar, double givenDuration, String imgs) {
        id = givenId;
        title = ttl;
        subtitle = subttl;
        imgSrc = imgs;
        calendar = givenCalendar;
        coordName = name;
        coordEmail = emailID;
        coordPhoneNumber = phoneNo;
        location = givenlocation;
    }
    //getter functions
    public String getTitle(){
        return title;
    }
    public String getSubtitle(){
        return subtitle;
    }
    public int getId(){
        return id;
    }
    public String getDetails(){return details;}
    public String getCoordName(){return coordName;}
    public String getCoordPhoneNumber(){return coordPhoneNumber;}
    public String getCoordEmail(){return coordEmail;}
    public String getLocation(){ return location; }
    public Calendar getCalendar() {
        return calendar;
    }

    //setter functions
    public void setId(int setid){
        id = setid;
    }
    public void setCoordPhoneNumber(String phno){
        coordPhoneNumber = phno;
    }
    public void setDetails(String detailsgiven){
        details = detailsgiven;
    }
    public void setCoordName(String name){ coordName = name;}
}