package com.example.myapplication;

// MusicItem.java
public class MusicItem {
    private int imageResId;
    private String title;
    private String artist;
    private boolean isSelected;

    public MusicItem(int imageResId, String title, String artist) {
        this.imageResId = imageResId;
        this.title = title;
        this.artist = artist;
        this.isSelected = false;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
