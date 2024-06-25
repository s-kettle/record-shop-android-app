package com.skettle.recordshopapp.ui.mainactivity;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.skettle.recordshopapp.R;
import com.skettle.recordshopapp.databinding.ActivityMainBinding;
import com.skettle.recordshopapp.model.Album;
import com.skettle.recordshopapp.ui.updatealbum.UpdateAlbumActivity;
import com.skettle.recordshopapp.utils.ItemSpaceDecorator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface, AdapterView.OnItemSelectedListener {

    RecyclerView recyclerView;
    ArrayList<Album> albums;
    AlbumAdapter albumAdapter;
    MainActivityViewModel model;
    ActivityMainBinding binding;
    MainActivityClickHandler handler;
    SearchView searchView;
    Spinner spinner;
    String spinnerSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        model = new ViewModelProvider(this).get(MainActivityViewModel.class);

        handler = new MainActivityClickHandler(this);
        binding.setClickHandler(handler);

        spinner = findViewById(R.id.dropdown);
        spinner.setOnItemSelectedListener(this);
        String[] dropItems = getResources().getStringArray(R.array.filter_items);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dropItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        
        searchView = findViewById(R.id.filterInput);
        searchView.clearFocus();
        
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filterList(s);
                return true;
            }
        });

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
        Intent intent = new Intent(MainActivity.this, UpdateAlbumActivity.class);
        intent.putExtra("ALBUM_KEY", albums.get(position));
        startActivity(intent);
    }
    
    private void filterList(String s) {
        ArrayList<Album> filteredList = new ArrayList<>();
        for (Album album : albums) {
            switch (spinnerSelection) {
                case "All": {
                    if (album.getArtist().toLowerCase().contains(s.toLowerCase()) ||
                            album.getName().toLowerCase().contains(s.toLowerCase()) ||
                            album.getGenre().toLowerCase().contains(s.toLowerCase()) ||
                            String.valueOf(album.getReleaseYear()).equals(s) ||
                            String.valueOf(album.getStockQuantity()).equals(s))
                    {
                        if (!filteredList.contains(album)) {
                            filteredList.add(album);
                        }
                    }
                }
                case "Artist": {
                    if (album.getArtist().toLowerCase().contains(s.toLowerCase())) {
                        if (!filteredList.contains(album)) {
                            filteredList.add(album);
                        }
                    }
                }
                case "Album name": {
                    if (album.getName().toLowerCase().contains(s.toLowerCase())) {
                        if (!filteredList.contains(album)) {
                            filteredList.add(album);
                        }
                    }
                }
                case "Genre": {
                    if (album.getGenre().toLowerCase().contains(s.toLowerCase())) {
                        if (!filteredList.contains(album)) {
                            filteredList.add(album);
                        }
                    }
                }
            }
        }
        if (filteredList.isEmpty()) {
            Toast.makeText(this, "No albums found", Toast.LENGTH_SHORT).show();
        } else {
            albumAdapter.setFilteredList(filteredList);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.spinnerSelection = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}