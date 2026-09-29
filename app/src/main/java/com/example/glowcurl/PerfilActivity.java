package com.example.glowcurl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PerfilActivity extends AppCompatActivity {

    Spinner spTipoCabello;
    Spinner spProblema;
    Spinner spObjetivo;

    Button btnRecomendar;
    Button btnCerrarSesion;
    Button btnVolverInicioPerfil;

    TextView txtBienvenida;

    SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_perfil);

        spTipoCabello =
                findViewById(R.id.spTipoCabello);

        spProblema =
                findViewById(R.id.spProblema);

        spObjetivo =
                findViewById(R.id.spObjetivo);

        btnRecomendar =
                findViewById(R.id.btnRecomendar);

        btnCerrarSesion =
                findViewById(R.id.btnCerrarSesion);

        btnVolverInicioPerfil =
                findViewById(R.id.btnVolverInicioPerfil);

        txtBienvenida =
                findViewById(R.id.txtBienvenida);

        preferencias = getSharedPreferences(
                "GlowCurl",
                MODE_PRIVATE
        );

        String nombre =
                preferencias.getString(
                        "nombre",
                        "Usuario"
                );

        txtBienvenida.setText(
                "Bienvenida, " + nombre
        );

        String[] tipos = {
                "Ondulado",
                "Rizo",
                "Afro"
        };

        String[] problemas = {
                "Resequedad",
                "Frizz",
                "Encogimiento",
                "Caída",
                "Puntas abiertas"
        };

        String[] objetivos = {
                "Hidratación",
                "Definición",
                "Crecimiento y nutrición"
        };

        ArrayAdapter<String> adapterTipo =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_dropdown_item,
                        tipos
                );

        ArrayAdapter<String> adapterProblema =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_dropdown_item,
                        problemas
                );

        ArrayAdapter<String> adapterObjetivo =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_dropdown_item,
                        objetivos
                );

        spTipoCabello.setAdapter(adapterTipo);
        spProblema.setAdapter(adapterProblema);
        spObjetivo.setAdapter(adapterObjetivo);

        btnRecomendar.setOnClickListener(v -> {

            String tipo =
                    spTipoCabello
                            .getSelectedItem()
                            .toString();

            String problema =
                    spProblema
                            .getSelectedItem()
                            .toString();

            String objetivo =
                    spObjetivo
                            .getSelectedItem()
                            .toString();

            Intent intent = new Intent(
                    PerfilActivity.this,
                    RecomendacionActivity.class
            );

            intent.putExtra("tipo", tipo);
            intent.putExtra("problema", problema);
            intent.putExtra("objetivo", objetivo);

            startActivity(intent);
        });

        btnCerrarSesion.setOnClickListener(v -> {

            Intent intent = new Intent(
                    PerfilActivity.this,
                    MainActivity.class
            );

            startActivity(intent);
            finish();
        });

        btnVolverInicioPerfil.setOnClickListener(v -> {

            Intent intent = new Intent(
                    PerfilActivity.this,
                    MainActivity.class
            );

            startActivity(intent);
            finish();
        });
    }
}