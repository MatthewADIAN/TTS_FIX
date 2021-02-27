package com.ftiuksw.appkantinfti;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MinumanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.minuman);

        Spinner dropdown = findViewById(R.id.spinner3);
        String[] items = new String[]{"Teh", "Jus", "Soft Drink", "Kopi"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        Button tombolProses = (Button) findViewById(R.id.orderButtonMinuman);
        EditText hargaEditText = (EditText) findViewById(R.id.editTextMinumanHarga);
        EditText jumlahEditText = (EditText) findViewById(R.id.editTextJumlahMinuman);
        TextView totalTextView = (TextView) findViewById(R.id.textViewTotalMinuman);



        tombolProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MinumanActivity.this);
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

