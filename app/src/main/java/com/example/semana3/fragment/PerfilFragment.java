package com.example.semana3.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.semana3.Pojo.InformacionAtributos;
import com.example.semana3.R;
import com.example.semana3.adaptador.AdaptorCardViewInterface2;
import com.example.semana3.presentador.IReciclerViewFragmentPresentador;
import com.example.semana3.presentador.ReciclerViewFragmentPresentador;

import java.util.ArrayList;

public class PerfilFragment extends Fragment implements InterfaceFragmentPerfilFragment {
    ArrayList<InformacionAtributos> datosInterface2;
    RecyclerView rvReciclerViewInterface2;
    View v;
    private IReciclerViewFragmentPresentador presentador;
    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        rvReciclerViewInterface2 = (RecyclerView) v.findViewById(R.id.rvReciclerViewInterface2);
        presentador = new ReciclerViewFragmentPresentador(this,getContext());
        return v;
    }
    public void generarVista() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        glm.setOrientation(GridLayoutManager.VERTICAL);
        rvReciclerViewInterface2.setLayoutManager(glm);
    }
    @Override
    public AdaptorCardViewInterface2 crearAdaptador(ArrayList<InformacionAtributos> datosInterface2) {
        AdaptorCardViewInterface2 adaptador = new AdaptorCardViewInterface2(datosInterface2, getActivity());
        return adaptador;
    }

    @Override
    public void inicializaAdaptador(AdaptorCardViewInterface2 adaptador) {
        rvReciclerViewInterface2.setAdapter(adaptador);
    }

}