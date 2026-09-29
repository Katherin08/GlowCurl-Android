package com.example.glowcurl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText edtCorreoLogin;
    EditText edtPasswordLogin;

    Button btnIngresar;
    Button btnVolverInicioLogin;

    SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        edtCorreoLogin =
                findViewById(R.id.edtCorreoLogin);

        edtPasswordLogin =
                findViewById(R.id.edtPasswordLogin);

        btnIngresar =
                findViewById(R.id.btnIngresar);

        btnVolverInicioLogin =
                findViewById(R.id.btnVolverInicioLogin);

        preferencias = getSharedPreferences(
                "GlowCurl",
                MODE_PRIVATE
        );

        btnIngresar.setOnClickListener(v -> {

            String correo =
                    edtCorreoLogin.getText().toString().trim();

            String password =
                    edtPasswordLogin.getText().toString().trim();

            if (correo.isEmpty() || password.isEmpty()) {

                Toast.makeText(
                        LoginActivity.this,
                        "Ingrese correo y contraseña",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            boolean registrado =
                    preferencias.getBoolean(
                            "registrado",
                            false
                    );

            if (!registrado) {

                Toast.makeText(
                        LoginActivity.this,
                        "Primero debe registrarse",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            String correoGuardado =
                    preferencias.getString(
                            "correo",
                            ""
                    );

            String passwordGuardada =
                    preferencias.getString(
                            "password",
                            ""
                    );

            if (correo.equals(correoGuardado)
                    && password.equals(passwordGuardada)) {

                Toast.makeText(
                        LoginActivity.this,
                        "Bienvenida a Glow Curl",
                        Toast.LENGTH_SHORT
                ).show();

                Intent intent = new Intent(
                        LoginActivity.this,
                        PerfilActivity.class
                );

                startActivity(intent);

                finish();

            } else {

                Toast.makeText(
                        LoginActivity.this,
                        "Correo o contraseña incorrectos",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        btnVolverInicioLogin.setOnClickListener(v -> {

            Intent intent = new Intent(
                    LoginActivity.this,
                    MainActivity.class
            );

            startActivity(intent);
            finish();
        });
    }
}