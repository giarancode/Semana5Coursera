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
import com.example.semana3.adaptador.AdaptadorCardView;
import com.example.semana3.adaptador.AdaptorCardViewInterface2;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {
    ArrayList<InformacionAtributos> datosInterface2;
    RecyclerView rvReciclerViewInterface2;
    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        rvReciclerViewInterface2 = (RecyclerView) v.findViewById(R.id.rvReciclerViewInterface2);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        glm.setOrientation(GridLayoutManager.VERTICAL);
        rvReciclerViewInterface2.setLayoutManager(glm);

        //rvReciclerViewInterface2.setLayoutManager(new GridLayoutManager(getActivity(),3));
        //AdaptadorCardView adaptador = new AdaptadorCardView(datosInterface2,getActivity());
        //rvReciclerViewInterface2.setAdapter(adaptador);
        listaInformacion();
        inicializarAdaptador ();

        return v;
    }
    public void inicializarAdaptador () {
        AdaptorCardViewInterface2 adaptador = new AdaptorCardViewInterface2(datosInterface2, getActivity());
        rvReciclerViewInterface2.setAdapter(adaptador);
    }

    public void listaInformacion(){
        datosInterface2 = new ArrayList<>();
        datosInterface2.add(new InformacionAtributos(R.drawable.perrito_arreglado_1, "1"));
        datosInterface2.add(new InformacionAtributos(R.drawable.perrito_arreglado_1, "4"));
        datosInterface2.add(new InformacionAtributos(R.drawable.perrito_arreglado_1, "5"));
        datosInterface2.add(new InformacionAtributos(R.drawable.perrito_arreglado_1, "4"));
        datosInterface2.add(new InformacionAtributos(R.drawable.perrito_arreglado_1, "3"));
        datosInterface2.add(new InformacionAtributos(R.drawable.perrito_arreglado_1, "1"));


      }

}