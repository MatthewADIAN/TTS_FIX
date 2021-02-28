package com.ftiuksw.appkantinfti

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat

class MinumanActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.minuman)

        val dropdown = findViewById<Spinner>(R.id.spinner3)
        val items = arrayOf("Teh", "Jus", "Soft Drink", "Kopi")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
        dropdown.adapter = adapter

        val dropdownMinuman = findViewById<Spinner>(R.id.spinnerMinuman)
        val itemsMinuman = arrayOf("Diantar","Dine-in")
        val adapterMinuman = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, itemsMinuman)
        dropdownMinuman.adapter = adapterMinuman


        val tombolProses = findViewById<View>(R.id.orderButtonMinuman) as Button
        val hargaEditText = findViewById<View>(R.id.editTextMinumanHarga) as EditText
        val jumlahEditText = findViewById<View>(R.id.editTextJumlahMinuman) as EditText
        val totalTextView = findViewById<View>(R.id.textViewTotalMinuman) as TextView
        tombolProses.setOnClickListener {
            val builder = AlertDialog.Builder(this@MinumanActivity)
            builder.setMessage("Are you sure you want to order?")
                    .setCancelable(false)
                    .setPositiveButton("Yes") { dialog, id ->
                        val hargaString = hargaEditText.text.toString().trim { it <= ' ' }
                        val jumlahString = jumlahEditText.text.toString().trim { it <= ' ' }
                        val harga = hargaString.toDouble()
                        val jumlah = jumlahString.toDouble()
                        val total = harga * jumlah
                        totalTextView.text = "Total : $total"

                        val id = "updated"

                        val name = getString(R.string.abc_action_bar_home_description)

                        val description = getString(R.string.abc_action_bar_home_description)
                        val importance = NotificationManager.IMPORTANCE_HIGH
                        val mChannel = NotificationChannel(id, name, importance)

                        mChannel.description = description
                        mChannel.enableLights(true)

                        mChannel.lightColor = Color.RED
                        mChannel.enableVibration(true)

                        val CHANNEL_ID = "updated"

                        // Use NotificationCompat.Builder to add the notification objects
                        val mBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
                                .setSmallIcon(R.drawable.notification_icon_background)
                                .setContentTitle("Order Successfull")
                                .setContentText("Your Order is completed")

                        val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

                        mNotificationManager.createNotificationChannel(mChannel)
                        mNotificationManager.notify(1, mBuilder.build())

                    }
                    .setNegativeButton("No") {
                        dialogInterface: DialogInterface?, which: Int -> Toast.makeText(applicationContext,"Order cancelled",
                            Toast.LENGTH_LONG).show()
                    }
            val alert = builder.create()
            alert.show()
        }
    }
    fun go2Menu(view: View?) {
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
    }
}

