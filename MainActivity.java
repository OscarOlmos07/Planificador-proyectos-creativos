MainActivity.java

package com.luisahr.planificadordeproyectoscreativos;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.luisahr.planificadordeproyectoscreativos.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Acción del botón
        binding.btnAgregarProyecto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = binding.editTextNombreProyecto.getText().toString();
                String fecha = binding.editTextFecha.getText().toString();

                if (!nombre.isEmpty() && !fecha.isEmpty()) {
                    agregarProyecto(nombre, fecha);
                    binding.editTextNombreProyecto.setText("");
                    binding.editTextFecha.setText("");
                }
            }
        });
    }

    private void agregarProyecto(String nombre, String fecha) {
        TextView nuevoProyecto = new TextView(this);
        nuevoProyecto.setText(" " + nombre + " - " + fecha);
        nuevoProyecto.setTextSize(18);
        nuevoProyecto.setPadding(8, 8, 8, 8);

        binding.listaProyectos.addView(nuevoProyecto);
    }
}

