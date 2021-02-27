package com.ftiuksw.appkantinfti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    public void go2Home(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        EditText editText = (EditText) findViewById(R.id.FirstName_ID);
        String message = editText.getText().toString();
        intent.putExtra("Username", message);
        startActivity(intent);
    }
}