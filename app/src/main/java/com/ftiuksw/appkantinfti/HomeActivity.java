package com.ftiuksw.appkantinfti;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        Intent intent = getIntent();
        String message = intent.getStringExtra("Username");

        TextView textView = findViewById(R.id.textViewUsername);
        textView.setText(message);

    }

    public void go2Menu(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void go2Login(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
