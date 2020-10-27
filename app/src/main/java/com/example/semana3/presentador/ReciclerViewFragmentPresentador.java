package com.example.semana3.presentador;

import android.content.Context;

import com.example.semana3.Pojo.InformacionAtributos;
import com.example.semana3.db.ConstructorInformacion;
import com.example.semana3.fragment.InterfaceFragmentPerfilFragment;
import com.example.semana3.fragment.InterfaceFragmentReciclerViewFragment;

import java.util.ArrayList;

public class ReciclerViewFragmentPresentador implements IReciclerViewFragmentPresentador {
    InterfaceFragmentReciclerViewFragment interfaceFragmentReciclerViewFragment;
    InterfaceFragmentPerfilFragment interfaceFragmentPerfilFragment;
    Context context;
    private ArrayList<InformacionAtributos> datos;
    private ArrayList<InformacionAtributos> datosInterface2;


    public ReciclerViewFragmentPresentador(InterfaceFragmentReciclerViewFragment interfaceFragmentReciclerViewFragment, Context context) {
        this.interfaceFragmentReciclerViewFragment = interfaceFragmentReciclerViewFragment;
        this.context = context;
        obtenerInformacionBaseDatos();
    }

    public ReciclerViewFragmentPresentador(InterfaceFragmentPerfilFragment interfaceFragmentPerfilFragment, Context context){
        this.interfaceFragmentPerfilFragment = interfaceFragmentPerfilFragment;
        this.context = context;
        obtenerInformacionBaseDatosInterface2();
    }

    @Override
    public void obtenerInformacionBaseDatos() { //Aquí se trabajará el modelo
        ConstructorInformacion constructorInformacion = new ConstructorInformacion(context); //Se crea el constructor (igual que en la db)
        datos = constructorInformacion.obtenerInformacion(); // esto permitira que la informacion se pueda presentar y manejar de manera mas sencilla
        mostrarContactosRV();
    }


    @Override
    public void mostrarContactosRV() {
        interfaceFragmentReciclerViewFragment.inicializaAdaptador(interfaceFragmentReciclerViewFragment.crearAdaptador(datos));
        interfaceFragmentReciclerViewFragment.generarVista();
    }

    @Override
    public void obtenerInformacionBaseDatosInterface2() {
        ConstructorInformacion constructorInformacion2 = new ConstructorInformacion(context);
        datosInterface2 = constructorInformacion2.obtenerInformacionPerfilFragment();
        mostrarDatosRVInterface2();
    }

    @Override
    public void mostrarDatosRVInterface2() {
        interfaceFragmentPerfilFragment.inicializaAdaptador(interfaceFragmentPerfilFragment.crearAdaptador(datosInterface2));
        interfaceFragmentPerfilFragment.generarVista();
    }
}

