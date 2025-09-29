package com.arandadiegoa.kindystarts.ui.home

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.arandadiegoa.kindystarts.R
import com.arandadiegoa.kindystarts.ui.auth.RegisterActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)

        val welcomeText = findViewById<TextView>(R.id.textViewGreeting)
        val childName = intent.getStringExtra(RegisterActivity.extraChildName)

        if(!childName.isNullOrBlank()) {
            welcomeText.text = getString(R.string.text_hello, childName)
        }else {
            welcomeText.text = getString(R.string.text_hello)
        }
    }
}