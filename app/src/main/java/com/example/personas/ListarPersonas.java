package com.example.personas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ListarPersonas extends AppCompatActivity {

    private TableLayout tabla;
    private ArrayList<Persona> personas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_personas);
        tabla = findViewById(R.id.tblPersonas);
        personas = Datos.obtener();

        for (int i = 0; i < personas.size(); i++) {
            TableRow fila = new TableRow(this);

            TextView columna_uno = new TextView(this);
            TextView columna_dos = new TextView(this);
            TextView columna_tres = new TextView(this);
            TextView columna_cuatro = new TextView(this);

            columna_uno.setText("" + (i+1));
            columna_dos.setText(personas.get(i).getCedula());
            columna_tres.setText(personas.get(i).getNombre());
            columna_cuatro.setText(personas.get(i).getApellido());

            fila.addView(columna_uno);
            fila.addView(columna_dos);
            fila.addView(columna_tres);
            fila.addView(columna_cuatro);

            tabla.addView(fila);
        }
    }
}
