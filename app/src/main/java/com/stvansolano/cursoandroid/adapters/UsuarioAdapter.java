package com.stvansolano.cursoandroid.adapters;

import com.stvansolano.cursoandroid.modelos.Usuario;

import java.util.ArrayList;

public class UsuarioAdapter {
    private ArrayList<Usuario> items;

    public UsuarioAdapter(ArrayList<Usuario> items){
        this.items = items;
    }

    public ArrayList<Usuario> getItems(){
        return items;
    }
}
