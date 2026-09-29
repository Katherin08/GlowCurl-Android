package com.example.glowcurl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistroActivity extends AppCompatActivity {

    EditText edtNombre;
    EditText edtCorreo;
    EditText edtPassword;

    Button btnRegistrar;
    Button btnVolverInicioRegistro;

    SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registro);

        edtNombre = findViewById(R.id.edtNombre);
        edtCorreo = findViewById(R.id.edtCorreo);
        edtPassword = findViewById(R.id.edtPassword);

        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnVolverInicioRegistro =
                findViewById(R.id.btnVolverInicioRegistro);

        preferencias = getSharedPreferences(
                "GlowCurl",
                MODE_PRIVATE
        );

        btnRegistrar.setOnClickListener(v -> {

            String nombre =
                    edtNombre.getText().toString().trim();

            String correo =
                    edtCorreo.getText().toString().trim();

            String password =
                    edtPassword.getText().toString().trim();

            if (nombre.isEmpty()
                    || correo.isEmpty()
                    || password.isEmpty()) {

                Toast.makeText(
                        RegistroActivity.this,
                        "Complete todos los campos",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            preferencias.edit()
                    .putString("nombre", nombre)
                    .putString("correo", correo)
                    .putString("password", password)
                    .putBoolean("registrado", true)
                    .apply();

            Toast.makeText(
                    RegistroActivity.this,
                    "Registro exitoso",
                    Toast.LENGTH_SHORT
            ).show();

            Intent intent = new Intent(
                    RegistroActivity.this,
                    LoginActivity.class
            );

            startActivity(intent);
            finish();
        });

        btnVolverInicioRegistro.setOnClickListener(v -> {

            Intent intent = new Intent(
                    RegistroActivity.this,
                    MainActivity.class
            );

            startActivity(intent);
            finish();
        });
    }
}