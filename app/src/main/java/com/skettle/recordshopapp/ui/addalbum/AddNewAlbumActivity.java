package com.skettle.recordshopapp.ui.addalbum;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import com.skettle.recordshopapp.R;
import com.skettle.recordshopapp.databinding.ActivityAddNewAlbumBinding;
import com.skettle.recordshopapp.model.Album;
import com.skettle.recordshopapp.ui.mainactivity.MainActivityViewModel;

public class AddNewAlbumActivity extends AppCompatActivity {

    ActivityAddNewAlbumBinding binding;
    MainActivityViewModel model;
    AddAlbumClickHandlers clickHandlers;
    Album album;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_album);

        album = new Album();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_album);
        model = new ViewModelProvider(this).get(MainActivityViewModel.class);
        clickHandlers = new AddAlbumClickHandlers(album, this, model);
        binding.setClickHandler(clickHandlers);
        binding.setAlbum(album);
    }
}