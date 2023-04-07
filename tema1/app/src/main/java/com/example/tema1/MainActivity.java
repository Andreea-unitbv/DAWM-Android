package com.example.tema1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonClose = findViewById(R.id.button_close);
        buttonClose.setOnClickListener(view -> finish());
    }
    private void goToSecondFragment() {

    }


}