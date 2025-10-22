package com.arandadiegoa.kindystarts.ui.auth;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class PhotoPickerHelper {
    private final ActivityResultLauncher<String> getContent; //variable de instancia

    public PhotoPickerHelper(AppCompatActivity activity, PhotoPickerListener listener) {
        //abre galeria y recibe el resultado
        this.getContent = activity.registerForActivityResult(
                new ActivityResultContracts.GetContent(), // Obtener Contenido
                uri -> {
                    if (uri != null && listener != null) {
                        listener.onPhotoSelected(uri); //notifico al activity
                    }
                }
        );
    }

        //Abre el selector de archivos de tipo imagen
        public void launchImagePicker() {
            getContent.launch("image/*");
        }
}

