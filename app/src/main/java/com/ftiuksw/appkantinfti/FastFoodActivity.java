package com.ftiuksw.appkantinfti;

import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;


public class FastFoodActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fast_food);

        Spinner dropdown = findViewById(R.id.spinner1);
        String[] items = new String[]{"Keripik", "Wafer", "Permen", "Cokelat"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);


        Button tombolProses = (Button) findViewById(R.id.orderButton);
        EditText hargaEditText = (EditText) findViewById(R.id.editTextSnackHarga);
        EditText jumlahEditText = (EditText) findViewById(R.id.editTextJumlah);
        TextView totalTextView = (TextView) findViewById(R.id.textViewTotal);
        TextView status = (TextView) findViewById(R.id.textViewStatus);


        tombolProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(FastFoodActivity.this);
                builder.setMessage("Are you sure you want to order?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                String hargaString = hargaEditText.getText().toString().trim();
                                String jumlahString = jumlahEditText.getText().toString().trim();
                                double harga = Double.parseDouble(hargaString);
                                double jumlah = Double.parseDouble(jumlahString);
                                double total = (harga * jumlah);
                                totalTextView.setText("Total : " + total);
                                status.setText("Ordered");

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();


            }
        });


    }


}
