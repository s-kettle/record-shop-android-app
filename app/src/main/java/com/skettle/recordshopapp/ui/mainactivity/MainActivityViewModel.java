package com.skettle.recordshopapp.ui.mainactivity;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.skettle.recordshopapp.model.Album;
import com.skettle.recordshopapp.model.AlbumRepository;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    AlbumRepository albumRepository;

    public MainActivityViewModel(@NotNull Application application) {
        super(application);
        this.albumRepository = new AlbumRepository(application);
    }

    public MutableLiveData<List<Album>> getData() {
        return albumRepository.getMutableLiveData();
    }
}
