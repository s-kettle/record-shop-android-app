package com.skettle.recordshopapp.service;

import com.skettle.recordshopapp.model.Album;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface AlbumApiService {

    @GET("albums")
    Call<List<Album>> getAlbums();

    @POST("albums")
    Call<Album> createAlbum(@Body Album album);
}
