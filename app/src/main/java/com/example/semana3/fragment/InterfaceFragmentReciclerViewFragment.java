package com.example.semana3.fragment;

import com.example.semana3.Pojo.InformacionAtributos;
import com.example.semana3.adaptador.AdaptadorCardView;

import java.util.ArrayList;

public interface InterfaceFragmentReciclerViewFragment {
    public void generarVista();

    public AdaptadorCardView crearAdaptador(ArrayList<InformacionAtributos> datos);

    public void inicializaAdaptador(AdaptadorCardView adaptador);


}
