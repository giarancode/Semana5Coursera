package com.example.semana3.fragment;

import com.example.semana3.Pojo.InformacionAtributos;
import com.example.semana3.adaptador.AdaptadorCardView;
import com.example.semana3.adaptador.AdaptorCardViewInterface2;

import java.util.ArrayList;

public interface InterfaceFragmentPerfilFragment {
    public void generarVista();

    public AdaptorCardViewInterface2 crearAdaptador(ArrayList<InformacionAtributos> datosInterface2);

    public void inicializaAdaptador(AdaptorCardViewInterface2 adaptador);

}
