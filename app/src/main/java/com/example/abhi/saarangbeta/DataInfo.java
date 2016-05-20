package com.example.abhi.saarangbeta;

/*Definition of a class which holds the data model for details*/
public class DataInfo {
    int id;
    private String title;
    private String subtitle;
    private String imgsrc;

    public DataInfo(int givenId, String ttl, String subttl, String imgs) {
        id = givenId;
        title = ttl;
        subtitle = subttl;
        imgsrc = imgs;
    }
    public String getTitle(){
        return title;
    }
    public String getSubtitle(){
        return subtitle;
    }

}