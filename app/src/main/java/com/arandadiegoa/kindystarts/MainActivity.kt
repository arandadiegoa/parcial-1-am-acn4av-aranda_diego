package com.arandadiegoa.kindystarts

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextSwitcher
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var textMessages: Array<String>
    private lateinit var textSwitcher: TextSwitcher

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // AÑADE ESTE BLOQUE DE CÓDIGO
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        //Reference
        textSwitcher = findViewById(R.id.textSwitcherWelcome)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        val buttonRegister = findViewById<Button>(R.id.buttonRegister)

        //load Arrays
        textMessages = resources.getStringArray(R.array.mensajes_bienvenida)

        //wiews and actions
        setupTextSwitcher()

        //actions buttons
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

        //start
        startCarousel()
    }

    private fun setupTextSwitcher(){
        textSwitcher.setFactory {
            val textView = TextView(this@MainActivity)
            textView.textSize = 22f
            textView.gravity = Gravity.CENTER_HORIZONTAL
            //textView.setBackgroundResource(R.drawable.dialogo_background)
            textView.setPadding(48,48,48,48)
            textView
        }
        textSwitcher.setInAnimation(this, R.anim.fade_in)
        textSwitcher.setOutAnimation(this, R.anim.fade_out)
    }

        //coroutine
        private fun startCarousel(){
        lifecycleScope.launch {
            var currentIndex = 0
            while (isActive) {
                textSwitcher.setText(textMessages[currentIndex])
                currentIndex = (currentIndex + 1) % textMessages.size
                delay(4000)
            }
        }


    }
}