package com.skettle.recordshopapp.ui.updatealbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.skettle.recordshopapp.model.Album;
import com.skettle.recordshopapp.ui.mainactivity.MainActivity;
import com.skettle.recordshopapp.ui.mainactivity.MainActivityViewModel;

import java.util.Objects;

public class UpdateAlbumClickHandler {

    private Context context;
    private Album album;
    private MainActivityViewModel model;
    private long albumID;

    public UpdateAlbumClickHandler(Context context, Album album, MainActivityViewModel model) {
        this.context = context;
        this.album = album;
        this.model = model;
    }

    public void submitButtonClicked(View view) {

        Album updatedAlbum = new Album(
                album.getId(),
                album.getArtist(),
                album.getGenre(),
                album.getName(),
                album.getArtUrl(),
                album.getReleaseYear(),
                album.getStockQuantity()
        );

        if (Objects.equals(updatedAlbum.getArtist(), "") ||
                Objects.equals(updatedAlbum.getGenre(), "") ||
                Objects.equals(updatedAlbum.getName(), "") ||
                Objects.equals(updatedAlbum.getArtUrl(), "") ||
                Objects.equals(updatedAlbum.getReleaseYear(), "") ||
                Objects.equals(updatedAlbum.getStockQuantity(), "")) {
            Toast.makeText(context, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(context, MainActivity.class);
            albumID = album.getId();
            model.updateAlbum(albumID, updatedAlbum);
            context.startActivity(intent);
        }
    }

    public void deleteButtonClicked(View view) {
        Intent intent = new Intent(context, MainActivity.class);
        albumID = album.getId();
        model.deleteAlbum(albumID);
        context.startActivity(intent);
    }


}
