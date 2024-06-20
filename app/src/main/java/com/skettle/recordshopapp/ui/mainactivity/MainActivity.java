package com.skettle.recordshopapp.ui.mainactivity;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.skettle.recordshopapp.R;
import com.skettle.recordshopapp.databinding.ActivityMainBinding;
import com.skettle.recordshopapp.model.Album;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Album> albums;
    AlbumAdapter albumAdapter;
    MainActivityViewModel model;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        model = new ViewModelProvider(this).get(MainActivityViewModel.class);

        getAllAlbums();
    }

    private void getAllAlbums() {
        model.getData().observe(this, albumsFromData -> {
            albums = (ArrayList<Album>) albumsFromData;
            displayInRecyclerView();
            System.out.println(albums.get(0).getArtist());
        });
    }

    private void displayInRecyclerView() {
        recyclerView = binding.recyclerView;
        albumAdapter = new AlbumAdapter(albums, this);
        recyclerView.setAdapter(albumAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.hasFixedSize();
        albumAdapter.notifyDataSetChanged();
    }

}