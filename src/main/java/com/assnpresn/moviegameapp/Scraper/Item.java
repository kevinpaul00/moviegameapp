package com.assnpresn.moviegameapp.Scraper;

public class Item {
    public String sq;
    public String title;
    public String url;

    public Item(String sq, String title, String url) {
        this.title = title;
        this.url = url;
        this.sq = sq;
    }

    public Item(){

    }

    public String getSq() {
        return sq;
    }

    public void setSq(String sq) {
        this.sq = sq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
