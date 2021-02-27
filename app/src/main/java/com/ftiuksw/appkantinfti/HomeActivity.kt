package com.ftiuksw.appkantinfti

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)
        val intent = intent
        val message = intent.getStringExtra("Username")
        val textView = findViewById<TextView>(R.id.textViewUsername)
        textView.text = message
    }

    fun go2Menu(view: View?) {
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
    }

    fun go2Login(view: View?) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}
