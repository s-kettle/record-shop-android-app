package com.skettle.recordshopapp.service;

import com.skettle.recordshopapp.model.Album;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface AlbumApiService {

    @GET("albums")
    Call<List<Album>> getAlbums();

    @POST("albums")
    Call<Album> createAlbum(@Body Album album);

    @PUT("albums/{id}")
    Call<Album> updateAlbum(@Path("id") long id, @Body Album album);

    @DELETE("albums/{id}")
    Call<String> deleteAlbum(@Path("id") long id);
}
