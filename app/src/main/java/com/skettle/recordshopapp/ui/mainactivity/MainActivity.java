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
import com.skettle.recordshopapp.utils.ItemSpaceDecorator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    RecyclerView recyclerView;
    ArrayList<Album> albums;
    AlbumAdapter albumAdapter;
    MainActivityViewModel model;
    ActivityMainBinding binding;
    MainActivityClickHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        model = new ViewModelProvider(this).get(MainActivityViewModel.class);

        handler = new MainActivityClickHandler(this);
        binding.setClickHandler(handler);

        getAllAlbums();
    }

    private void getAllAlbums() {
        model.getData().observe(this, albumsFromData -> {
            albums = (ArrayList<Album>) albumsFromData;
            displayInRecyclerView();
        });
    }

    private void displayInRecyclerView() {
        recyclerView = binding.recyclerView;
        albumAdapter = new AlbumAdapter(albums, this, this);
        recyclerView.setAdapter(albumAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ItemSpaceDecorator decorator = new ItemSpaceDecorator(20);
        recyclerView.addItemDecoration(decorator);
        recyclerView.hasFixedSize();
        albumAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {

    }
}