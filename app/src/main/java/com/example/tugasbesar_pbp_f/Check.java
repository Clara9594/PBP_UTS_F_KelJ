package com.example.tugasbesar_pbp_f;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class Check extends AppCompatActivity {
    MaterialButton btnFinish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        btnFinish = findViewById(R.id.finish);

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent finish = new Intent(Check.this,MainActivity.class);
                startActivity(finish);
            }
        });
    }
}