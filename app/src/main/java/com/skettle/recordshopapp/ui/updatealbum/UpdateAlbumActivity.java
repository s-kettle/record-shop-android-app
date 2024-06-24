package com.skettle.recordshopapp.ui.updatealbum;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import com.skettle.recordshopapp.R;
import com.skettle.recordshopapp.databinding.ActivityUpdateAlbumBinding;
import com.skettle.recordshopapp.model.Album;
import com.skettle.recordshopapp.ui.mainactivity.MainActivityViewModel;

public class UpdateAlbumActivity extends AppCompatActivity {

    ActivityUpdateAlbumBinding binding;
    UpdateAlbumClickHandler clickHandler;
    MainActivityViewModel model;
    Album album;

    private static final String ALBUM_KEY = "album";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_album);

        album = getIntent().getParcelableExtra("ALBUM_KEY", Album.class);

        binding.setAlbum(album);

        binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_update_album
        );

        clickHandler = new UpdateAlbumClickHandler(
                this,
                album,
                model
        );
    }
}