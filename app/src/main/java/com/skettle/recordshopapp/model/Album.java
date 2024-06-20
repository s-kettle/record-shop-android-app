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

    public long getId() {
        return id;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }
}
