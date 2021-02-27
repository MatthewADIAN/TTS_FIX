package com.ftiuksw.appkantinfti;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }

    public void go2Snack(View view) {
        Intent intent = new Intent(this, FastFoodActivity.class);
        startActivity(intent);
    }
    public void go2Nasi(View view) {
        Intent intent = new Intent(this, NasiActivity.class);
        startActivity(intent);
    }
    public void go2Minuman(View view) {
        Intent intent = new Intent(this, MinumanActivity.class);
        startActivity(intent);
    }
}
