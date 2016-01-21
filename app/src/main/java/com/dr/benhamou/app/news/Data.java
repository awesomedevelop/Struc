package com.dr.benhamou.app.news;

/**
 * Created by taras on 23.12.2015.
 */
public class Data {
    int id;
    String title;
    String content;
    String image;
    String link;

    public Data(int id,String title,String image,String link){
        this.id = id;
        this.title = title;
        this.image = image;
        this.link = link;

    }
    public  int getId (){return id;}
    public String getTitle (){return title;}
    public String getLink (){return  link;}
    public String getImage (){return image;}


}