package com.example.glowcurl;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RecomendacionActivity extends AppCompatActivity {

    TextView txtResultado;
    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recomendacion);

        txtResultado =
                findViewById(R.id.txtResultado);

        btnVolver =
                findViewById(R.id.btnVolver);

        String tipo =
                getIntent().getStringExtra("tipo");

        String problema =
                getIntent().getStringExtra("problema");

        String objetivo =
                getIntent().getStringExtra("objetivo");

        String recomendacion =
                "Tipo de cabello: " + tipo +
                        "\n\nProblema principal: " + problema +
                        "\n\nObjetivo: " + objetivo +
                        "\n\nRutina sugerida:" +
                        "\n\n• Realizar una limpieza suave." +
                        "\n• Aplicar hidratación según la necesidad." +
                        "\n• Utilizar productos adecuados para el tipo de cabello." +
                        "\n• Evitar el exceso de calor." +
                        "\n• Mantener una rutina constante.";

        txtResultado.setText(recomendacion);

        btnVolver.setOnClickListener(v -> {

            finish();

        });
    }
}