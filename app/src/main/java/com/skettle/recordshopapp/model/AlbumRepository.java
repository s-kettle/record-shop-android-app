package com.skettle.recordshopapp.model;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;
import androidx.lifecycle.MutableLiveData;
import com.skettle.recordshopapp.service.AlbumApiService;
import com.skettle.recordshopapp.service.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class AlbumRepository {

    private MutableLiveData<List<Album>> albumList = new MutableLiveData<>();
    private Application app;

    public AlbumRepository(Application app) {
        this.app = app;
    }

    public MutableLiveData<List<Album>> getMutableLiveData() {
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<List<Album>> call = albumApiService.getAlbums();

        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                List<Album> albums = response.body();
                albumList.setValue(albums);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable throwable) { }

        });
        return albumList;
    }

    public void addMutableLiveData(Album album) {

        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<Album> call = albumApiService.createAlbum(album);

        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                Toast.makeText(app.getApplicationContext(), "Album added successfully.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Album> call, Throwable throwable) {
                Toast.makeText(app.getApplicationContext(), "Unable to add book.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void updateAlbum(long id, Album album) {
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<Album> call = albumApiService.updateAlbum(id, album);

        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                Toast.makeText(app.getApplicationContext(), "Album successfully updated", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Album> call, Throwable throwable) {
                Toast.makeText(app.getApplicationContext(), "Unable to update album", Toast.LENGTH_SHORT).show();
                Log.e("UPDATE ALBUM", throwable.getMessage());
            }
        });
    }

    public void deleteAlbum(long id) {
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<String> call = albumApiService.deleteAlbum(id);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(app.getApplicationContext(), "Album deleted successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable throwable) {
                Toast.makeText(app.getApplicationContext(), "Unable to delete album", Toast.LENGTH_SHORT).show();
                Log.e("DELETE ALBUM", throwable.getMessage());
            }
        });
    }
 }
