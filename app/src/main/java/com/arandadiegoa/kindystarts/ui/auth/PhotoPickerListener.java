package com.arandadiegoa.kindystarts.ui.auth;

import android.net.Uri;

public interface PhotoPickerListener {
    void onPhotoSelected(Uri uri); //permite al Helper devolver la Uri a la Activity
}
