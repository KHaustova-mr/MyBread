package com.example.mybread.model;

import java.util.Date;

public class Record {
    public String text;
    public String imagePath;
    public Date date;

    public Record(String text) {
        this.text = text;
        this.date = new Date();
    }
}
