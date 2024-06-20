package com.skettle.recordshopapp.ui.mainactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.skettle.recordshopapp.R;
import com.skettle.recordshopapp.databinding.AlbumItemBinding;
import com.skettle.recordshopapp.model.Album;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    List<Album> albumList;
    Context context;

    public AlbumAdapter(List<Album> albumList, Context context) {
        this.albumList = albumList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
        return new AlbumViewHolder(AlbumItemBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull AlbumViewHolder albumViewHolder, int position) {

        Album album = albumList.get(position);
        albumViewHolder.albumItemBinding.setAlbum(album);
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public static class AlbumViewHolder extends RecyclerView.ViewHolder {

        AlbumItemBinding albumItemBinding;

        public AlbumViewHolder(AlbumItemBinding albumItemBinding) {
            super(albumItemBinding.getRoot());
            this.albumItemBinding = albumItemBinding;
        }
    }
}
