package com.example.mybread.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Recipe implements Serializable {
    String id;
    String site;
    String text;
    String imagePath;

    public Recipe() {
    }

    public String getId() {
        return id;
    }

    public String getSite() {
        return site;
    }

    public String getText() {
        return text;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


    @NonNull
    @Override
    public String toString() {
        return this.getId() + "  " + this.getText() + "  " + this.getSite();
    }
}
