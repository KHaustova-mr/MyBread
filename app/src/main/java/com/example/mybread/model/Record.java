package com.example.mybread.model;

import java.util.Date;

public class Record {
    public String text;
    public String url;
    public Date date;

    public Record(String text) {
        this.text = text;
        this.url = url;
        this.date = new Date();
    }
}
