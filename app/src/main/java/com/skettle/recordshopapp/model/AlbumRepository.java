package com.skettle.recordshopapp.model;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.skettle.recordshopapp.service.AlbumApiService;
import com.skettle.recordshopapp.service.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class AlbumRepository {

    private MutableLiveData<List<Album>> albumList;
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
}
