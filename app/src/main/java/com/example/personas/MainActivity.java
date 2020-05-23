package com.example.personas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView lista_opciones;
    private String [] opciones;
    private ArrayAdapter<String> adapter;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista_opciones = findViewById(R.id.lstOpciones);
        opciones = getResources().getStringArray(R.array.opciones);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, opciones);
        lista_opciones.setAdapter(adapter);
        lista_opciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        intent = new Intent(MainActivity.this, CrearPersonas.class);
                        startActivities(intent);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, ListarPersonas.class);
                        startActivities(intent);
                        break;
                }
            }
        });

    }
}
