package com.arandadiegoa.kindystarts.ui.base

import android.app.DatePickerDialog
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.arandadiegoa.kindystarts.R
import com.google.android.material.textfield.TextInputEditText
import java.util.Calendar

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        super.onCreate(savedInstanceState)
    }


    //Calendar
    protected fun setupDatePicker(editText: TextInputEditText) {
        editText.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                    val formattedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
                    editText.setText(formattedDate)
                },
                year,
                month,
                day
            )
            datePickerDialog.datePicker.maxDate = System.currentTimeMillis()
            datePickerDialog.show()
        }
    }

    //Obtener el nombre del archivo
    private fun getFileName(uri:Uri): String? {
        var fileName: String? = null
        val cursor: Cursor? = contentResolver.query(uri, null,null,
            null,null)
        cursor?.use {
            if(it.moveToFirst()) {
                val nameIndex = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                if(nameIndex != -1){
                    fileName = it.getString(nameIndex)
                }
            }
        }
        return fileName
    }

    //Recibe la foto
    protected val getContent = registerForActivityResult(ActivityResultContracts.GetContent())
    { uri ->
        // Este código se ejecuta cuando el usuario elige una foto
        if (uri != null) {
            val fileName = getFileName(uri)
            val uploadEditText = findViewById<TextInputEditText>(R.id.edit_text_upload_photo)
            uploadEditText.setText(fileName ?: getString(R.string.text_photo_select))
        }
    }


}