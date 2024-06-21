package com.skettle.recordshopapp.ui.addalbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import androidx.lifecycle.ViewModel;
import com.skettle.recordshopapp.model.Album;
import com.skettle.recordshopapp.ui.mainactivity.MainActivity;
import com.skettle.recordshopapp.ui.mainactivity.MainActivityViewModel;

public class AddAlbumClickHandlers {

    Album album;
    Context context;
    MainActivityViewModel mainActivityViewModel;

    public AddAlbumClickHandlers(Album album, Context context, MainActivityViewModel mainActivityViewModel) {
        this.album = album;
        this.context = context;
        this.mainActivityViewModel = mainActivityViewModel;
    }

    public void submitButtonClicked(View view) {
        if (album.getArtist() == null ||
                album.getName() == null ||
                album.getGenre() == null ||
                album.getReleaseYear() == 0 ||
                album.getStockQuantity() == 0) {
            Toast.makeText(context, "Fields must not be empty", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(context, MainActivity.class);
            Album submitAlbum = new Album(
                    album.getId(),
                    album.getArtist(),
                    album.getGenre(),
                    album.getName(),
                    album.getArtUrl(),
                    album.getReleaseYear(),
                    album.getStockQuantity());

            mainActivityViewModel.addAlbum(album);
            context.startActivity(intent);
        }
    }

    public void backButtonClicked(View view) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
