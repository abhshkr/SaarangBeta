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
    private String imgSrc;  //not used, as of now - can be used to change the background image
    private String details;
    private String location;
    Calendar calendar;
    double duration;
    String coordPhoneNumber;
    private String coordName;
    private String coordEmail;
    int prizeMoneyFirst;
    int prizeMoneySecond;
    int prizeMoneyThird;


    //Constructor
    public DataInfo(int givenId, String ttl, String subttl, String name, String phoneNo, String emailID, String givenlocation, Calendar givenCalendar, double givenDuration, int prizeFirst, int prizeSecond, int prizeThird, String imgs) {
        id = givenId;
        title = ttl;
        subtitle = subttl;
        imgSrc = imgs;
        calendar = givenCalendar;
        coordName = name;
        coordEmail = emailID;
        coordPhoneNumber = phoneNo;
        location = givenlocation;
        duration = givenDuration;
        prizeMoneyFirst = prizeFirst;
        prizeMoneySecond = prizeSecond;
        prizeMoneyThird = prizeThird;
    }

    //getter functions
    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getDetails() {
        return details;
    }

    public String getCoordName() {
        return coordName;
    }

    public String getCoordPhoneNumber() {
        return coordPhoneNumber;
    }

    public String getCoordEmail() {
        return coordEmail;
    }

    public String getLocation() {
        return location;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public int getId() {
        return id;
    }

    public double getDuration() {
        return duration;
    }

    public int getPrizeMoneyFirst() {
        return prizeMoneyFirst;
    }

    public int getPrizeMoneySecond() {
        return prizeMoneySecond;
    }

    public int getPrizeMoneyThird() {
        return prizeMoneyThird;
    }

    //setter functions
    public void setId(int setid) {
        id = setid;
    }

    public void setDetails(String detailsgiven) {
        details = detailsgiven;
    }
}