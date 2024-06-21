package com.skettle.recordshopapp.ui.mainactivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.skettle.recordshopapp.ui.addalbum.AddNewAlbumActivity;

public class MainActivityClickHandler {

    Context context;

    public MainActivityClickHandler(Context context) {
        this.context = context;
    }

    public void addAlbumButtonClicked(View view) {
        Intent intent = new Intent(view.getContext(), AddNewAlbumActivity.class);
        context.startActivity(intent);
    }
}
