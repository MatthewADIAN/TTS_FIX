package com.ftiuksw.appkantinfti

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
    }

    fun go2Home(view: View?) {
        val intent = Intent(this, HomeActivity::class.java)
        val editText = findViewById<View>(R.id.FirstName_ID) as EditText
        val message = editText.text.toString()
        intent.putExtra("Username", message)
        startActivity(intent)
    }
}