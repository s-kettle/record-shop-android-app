package com.skettle.recordshopapp.model;

public class Album {

    long id;
    String artist;
    String genre;
    String name;
    int releaseYear;
    int stockQuantity;

    public Album() {
    }

    public Album(long id, String artist, String genre, String name, int releaseYear, int stockQuantity) {
        this.id = id;
        this.artist = artist;
        this.genre = genre;
        this.name = name;
        this.releaseYear = releaseYear;
        this.stockQuantity = stockQuantity;
    }
}
