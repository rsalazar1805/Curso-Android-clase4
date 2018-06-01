package com.stvansolano.cursoandroid;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.stvansolano.cursoandroid.adapters.UsuarioAdapter;
import com.stvansolano.cursoandroid.modelos.Usuario;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private View.OnClickListener nuevoListener;
    private UsuarioAdapter adapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.botonMenuNuevo){
            AgregarNuevo();
        }
        else if (item.getItemId() == R.id.botonMenuBusqueda){

        }
        else if (item.getItemId() == R.id.botonMenuConfiguracion){

        }
        return true;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botonContinuar = (Button) findViewById(R.id.botonContinuar);
        Button botonNuevo = (Button)findViewById(R.id.botonNuevo);

        final Context actividadContext = this;

        botonContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(actividadContext, "Ha hecho click", Toast.LENGTH_LONG).show();
            }
        });

        nuevoListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               AgregarNuevo();
            }
        };

        botonNuevo.setOnClickListener(nuevoListener);
        //botonContinuar.setOnClickListener(
        //System.out.print("");

        adapter = new UsuarioAdapter(new ArrayList<Usuario>());
    }

    private void AgregarNuevo() {
        Intent mensajero = new Intent(this, NuevoElementoActivity.class);
        mensajero.putExtra("mensaje", "hola desde MainActivity");

        startActivityForResult(mensajero, 110);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == NuevoElementoActivity.GUARDADO_EXITOSO)
        {
            Usuario usuario = (Usuario) data.getSerializableExtra(Usuario.class.toString());
            adapter.getItems().add(usuario);

            Toast.makeText(this, "Se ha guardado con exito", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
