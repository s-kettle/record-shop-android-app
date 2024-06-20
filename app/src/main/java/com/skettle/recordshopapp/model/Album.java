package com.skettle.recordshopapp.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.skettle.recordshopapp.BR;

public class Album extends BaseObservable {

    long id;
    String artist;
    String genre;
    String name;
    String artUrl;
    int releaseYear;
    int stockQuantity;

    public Album() {
    }

    public Album(long id, String artist, String genre, String name, String artUrl, int releaseYear, int stockQuantity) {
        this.id = id;
        this.artist = artist;
        this.genre = genre;
        this.name = name;
        this.artUrl = artUrl;
        this.releaseYear = releaseYear;
        this.stockQuantity = stockQuantity;
    }

    @Bindable
    public long getId() {
        return id;
    }

    @Bindable
    public String getArtist() {
        return artist;
    }

    @Bindable
    public String getGenre() {
        return genre;
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public String getArtUrl() {
        return artUrl;
    }

    @Bindable
    public int getReleaseYear() {
        return releaseYear;
    }

    @Bindable
    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setId(long id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    public void setArtist(String artist) {
        this.artist = artist;
        notifyPropertyChanged(BR.artist);
    }

    public void setGenre(String genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.genre);
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setArtUrl(String artUrl) {
        this.artUrl = artUrl;
        notifyPropertyChanged(BR.artUrl);
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
        notifyPropertyChanged(BR.releaseYear);
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
        notifyPropertyChanged(BR.stockQuantity);
    }
}
