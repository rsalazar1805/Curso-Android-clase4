package com.stvansolano.cursoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.*;
import com.stvansolano.cursoandroid.modelos.Usuario;

public class NuevoElementoActivity extends AppCompatActivity {

    private String mensaje;
    public static final int GUARDADO_EXITOSO = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_elemento);

        Button botonGuardar = (Button) findViewById(R.id.botonGuardarNuevo);
        Intent llamadoIntent = getIntent();
        mensaje = llamadoIntent.getStringExtra("mensaje");

        final EditText editTextNombre = (EditText) findViewById(R.id.editTextNombre);

        final EditText editTextApellidos = (EditText) findViewById(R.id.editTextApellidos);

        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                Usuario nuevo = new Usuario();

                nuevo.setNombre(editTextNombre.getText().toString());
                nuevo.setApellido(editTextApellidos.getText().toString());
                //nuevo.setNombreUsuario();

                intent.putExtra(Usuario.class.toString(), nuevo);
                setResult(GUARDADO_EXITOSO, intent);
                finish();
            }
        });

        Log.d("TAG", "onCreate: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.out.println("onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();

        System.out.println("onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("onStop");
    }
}
