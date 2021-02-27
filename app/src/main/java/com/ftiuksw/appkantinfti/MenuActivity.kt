package com.ftiuksw.appkantinfti

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)
    }

    fun go2Snack(view: View?) {
        val intent = Intent(this, FastFoodActivity::class.java)
        startActivity(intent)
    }

    fun go2Nasi(view: View?) {
        val intent = Intent(this, NasiActivity::class.java)
        startActivity(intent)
    }

    fun go2Minuman(view: View?) {
        val intent = Intent(this, MinumanActivity::class.java)
        startActivity(intent)
    }
}
