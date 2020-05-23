package com.example.personas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CrearPersonas extends AppCompatActivity {
    private EditText cedula, nombre, apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_personas);

        cedula = findViewById(R.id.txtCedula);
        nombre = findViewById(R.id.txtNombre);
        apellido = findViewById(R.id.txtApellido);
    }

    public void guardar (View v){
        String ced, nom, apell;
        Persona persona;
        if (validar()){
            ced = cedula.getText().toString();
            nom = nombre.getText().toString();
            apell = apellido.getText().toString();
            persona = new Persona(ced, nom, apell);
            persona.guardar();
        }
    }

    public boolean validar(){
        String error_cedula, error_nombre, error_apellido;
        error_cedula = getResources().getString(R.string.error_cedula);
        error_nombre = getResources().getString(R.string.error_nombre);
        error_apellido = getResources().getString(R.string.error_apellido);
        if (cedula.getText().toString().isEmpty()){
            cedula.setError(error_cedula);
            return false;
        }else if(nombre.getText().toString().isEmpty()){
            nombre.setError(error_nombre);
            return false;
        }else if(apellido.getText().toString().isEmpty()){
            apellido.setError(error_apellido);
            return false;
        }
        return true;
    }

    public void limpiar (View v){
        cedula.setText("");
        nombre.setText("");
        apellido.setText("");
        cedula.requestFocus();
    }
}
