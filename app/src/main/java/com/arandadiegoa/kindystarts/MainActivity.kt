package com.arandadiegoa.kindystarts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Reference buttons
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        val buttonRegister = findViewById<Button>(R.id.buttonRegister)

        //Asign butto acccion
            buttonLogin.setOnClickListener {
                //create intent
                val intent = Intent(this, LoginActivity::class.java)

                startActivity(intent)
            }

            buttonRegister.setOnClickListener {
                //create intent
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }

    }
}