package com.example.semana3.fragment;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.semana3.Pojo.InformacionAtributos;
import com.example.semana3.R;
import com.example.semana3.adaptador.AdaptadorCardView;
import com.example.semana3.presentador.IReciclerViewFragmentPresentador;
import com.example.semana3.presentador.ReciclerViewFragmentPresentador;


import java.util.ArrayList;

public class ReciclerViewFragment extends Fragment implements InterfaceFragmentReciclerViewFragment {

    ArrayList<InformacionAtributos> datos;
    RecyclerView rvReciclerView;
    View v;
    AdaptadorCardView adaptador;

    public ReciclerViewFragment() {
        // Required empty public constructor
    }

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       v = inflater.inflate(R.layout.fragment_recicler_view, container, false);
       rvReciclerView = v.findViewById(R.id.rvReciclerView);
       IReciclerViewFragmentPresentador presentador = new ReciclerViewFragmentPresentador(this, getContext());
       return v;
    }

    @Override
    public void generarVista() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvReciclerView.setLayoutManager(llm);
    }

    public AdaptadorCardView crearAdaptador(ArrayList<InformacionAtributos> datos){
        return new AdaptadorCardView(datos,getActivity());
    }
    public void inicializaAdaptador(AdaptadorCardView adaptador){
        rvReciclerView.setAdapter(adaptador);
    }

}