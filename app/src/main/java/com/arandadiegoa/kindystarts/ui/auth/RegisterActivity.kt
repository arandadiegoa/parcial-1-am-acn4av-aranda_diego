package com.arandadiegoa.kindystarts.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import com.arandadiegoa.kindystarts.R
import com.arandadiegoa.kindystarts.ui.base.BaseActivity
import com.arandadiegoa.kindystarts.ui.home.HomeActivity
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val rootView = findViewById<View>(R.id.register_layout)

        rootView.post {
            rootView.requestFocus()
        }


        // Referencias
        val parentName = findViewById<TextInputEditText>(R.id.editTextParentName)
        val email = findViewById<TextInputEditText>(R.id.editTextEmail)
        val phone = findViewById<TextInputEditText>(R.id.editTextPhoneNumber)
        val password = findViewById<TextInputEditText>(R.id.editTextPassword)
        val childName = findViewById<TextInputEditText>(R.id.editTextChildName)
        val birthDate = findViewById<TextInputEditText>(R.id.editTextDateOfBirth)
        val submitButton = findViewById<Button>(R.id.buttonSubmitRegister)

        setupDatePicker(birthDate)

        /*Options Halls */

        //obtener las salas
        val halls = resources.getStringArray(R.array.option_hall)

        // Creamos el adaptador que une los datos con la vista
        val adapter = ArrayAdapter(this, R.layout.dropdown_item, halls)

        //Obtener la referencia
        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.autoCompleteHall)

        //Mostrar las opciones
        autoCompleteTextView.setAdapter(adapter)

        submitButton.setOnClickListener {
            val strParent = parentName.text.toString()
            val strEmail = email.text.toString()
            val strPhone = phone.text.toString()
            val strPassword = password.text.toString()
            val strChildName = childName.text.toString()
            val strBirthDate = birthDate.text.toString()

            if (strParent.isBlank() || strEmail.isBlank() || strPhone.isBlank() ||
                strPassword.isBlank() || strChildName.isBlank() || strBirthDate.isBlank()
                ) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}