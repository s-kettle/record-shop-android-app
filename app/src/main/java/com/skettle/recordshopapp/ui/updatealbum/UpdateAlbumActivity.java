package com.skettle.recordshopapp.ui.updatealbum;

import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import com.skettle.recordshopapp.R;
import com.skettle.recordshopapp.databinding.ActivityUpdateAlbumBinding;
import com.skettle.recordshopapp.model.Album;
import com.skettle.recordshopapp.ui.mainactivity.MainActivityViewModel;

public class UpdateAlbumActivity extends AppCompatActivity {

    ActivityUpdateAlbumBinding binding;
    UpdateAlbumClickHandler clickHandler;
    Album album;

    private static final String ALBUM_KEY = "album";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_album);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            album = getIntent().getParcelableExtra("ALBUM_KEY", Album.class);
        }

        binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_update_album
        );

        binding.setAlbum(album);

        MainActivityViewModel model = new ViewModelProvider(this).get(MainActivityViewModel.class);

        clickHandler = new UpdateAlbumClickHandler(
                this,
                album,
                model
        );

        binding.setClickHandler(clickHandler);
    }
}