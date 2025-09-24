package com.arandadiegoa.kindystarts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //Reference buttons and fields
        val parentName = findViewById<EditText>(R.id.editTextParentName)
        val email = findViewById<EditText>(R.id.editTextEmail)
        val phone = findViewById<EditText>(R.id.editTextPhoneNumber)
        val password = findViewById<EditText>(R.id.editTextPassword)
        val submitButton = findViewById<Button>(R.id.buttonSubmitRegister)

        //Listener button
        submitButton.setOnClickListener {
            //get string text
            val strParent = parentName.text.toString()
            val strEmail = email.text.toString()
            val strPhone = phone.text.toString()
            val strPassword = password.text.toString()

            //Validate fields
            if(strParent.isNotEmpty() && strEmail.isNotEmpty() && strPhone.isNotEmpty() && strPassword.isNotEmpty()) {
                //TO DO
                // AQUÍ iría la lógica para guardar los datos en una base de datos
                // Por ahora, simplemente lo llevamos a la pantalla principal
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}