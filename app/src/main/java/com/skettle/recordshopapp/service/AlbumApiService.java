package com.skettle.recordshopapp.service;

import com.skettle.recordshopapp.model.Album;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface AlbumApiService {

    @GET("albums")
    Call<List<Album>> getAlbums();
}
