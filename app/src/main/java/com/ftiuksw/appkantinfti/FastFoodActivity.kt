package com.ftiuksw.appkantinfti

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat

class FastFoodActivity : AppCompatActivity() {

        @RequiresApi(Build.VERSION_CODES.O)
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.fast_food)
            val dropdown = findViewById<Spinner>(R.id.spinner1)
            val items = arrayOf("Keripik", "Wafer", "Permen", "Cokelat")
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
            dropdown.adapter = adapter

            val dropdownAmbilFastFood = findViewById<Spinner>(R.id.spinnerPengambilan)
            val itemsFastFood = arrayOf("Diantar", "Dine-in")
            val adapterFastFood = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, itemsFastFood)
            dropdownAmbilFastFood.adapter = adapterFastFood

            val tombolProses = findViewById<View>(R.id.orderButton) as Button
            val hargaEditText = findViewById<View>(R.id.editTextSnackHarga) as EditText
            val jumlahEditText = findViewById<View>(R.id.editTextJumlah) as EditText
            val totalTextView = findViewById<View>(R.id.textViewTotal) as TextView

            tombolProses.setOnClickListener {
                val builder = AlertDialog.Builder(this@FastFoodActivity)
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
                        .setNegativeButton("No") { dialog, id -> dialog.cancel() }
                val alert = builder.create()
                alert.show()
            }
        }
    }

