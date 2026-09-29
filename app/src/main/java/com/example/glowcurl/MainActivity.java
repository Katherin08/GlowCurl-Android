package com.example.glowcurl;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnRegistro;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnRegistro = findViewById(R.id.btnRegistro);
        btnLogin = findViewById(R.id.btnLogin);

        btnRegistro.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    RegistroActivity.class
            );

            startActivity(intent);
        });

        btnLogin.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    LoginActivity.class
            );

            startActivity(intent);
        });
    }
}