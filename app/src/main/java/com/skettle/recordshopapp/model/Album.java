package com.skettle.recordshopapp.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import android.widget.TextView;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import com.skettle.recordshopapp.BR;

public class Album extends BaseObservable implements Parcelable {

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

    protected Album(Parcel in) {
        id = in.readLong();
        artist = in.readString();
        genre = in.readString();
        name = in.readString();
        artUrl = in.readString();
        releaseYear = in.readInt();
        stockQuantity = in.readInt();
    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

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

    @BindingAdapter("android:text")
    public static void setText(TextView view, int value) {
        if (view.getText() != null
                && ( !view.getText().toString().isEmpty() )
                && Integer.parseInt(view.getText().toString()) != value) {
            view.setText(Integer.toString(value));
        }
    }

    @InverseBindingAdapter(attribute = "android:text")
    public static int getText(TextView view) {
        return Integer.parseInt(view.getText().toString());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(artist);
        dest.writeString(genre);
        dest.writeString(name);
        dest.writeString(artUrl);
        dest.writeInt(releaseYear);
        dest.writeInt(stockQuantity);
    }
}
