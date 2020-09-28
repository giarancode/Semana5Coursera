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


import java.util.ArrayList;

public class ReciclerViewFragment extends Fragment {

    ArrayList<InformacionAtributos> datos;
    RecyclerView rvReciclerView;
    public ReciclerViewFragment() {
        // Required empty public constructor
    }

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_recicler_view, container, false);

       rvReciclerView = v.findViewById(R.id.rvReciclerView);
       LinearLayoutManager llm = new LinearLayoutManager(getActivity());
       llm.setOrientation(LinearLayoutManager.VERTICAL);
       rvReciclerView.setLayoutManager(llm);

       listaInformacion();
       inicializaAdaptador();
        return v;
    }

    public void inicializaAdaptador(){
        AdaptadorCardView adaptador = new AdaptadorCardView(datos,getActivity());
        rvReciclerView.setAdapter(adaptador);
    }

    public void listaInformacion(){
        datos = new ArrayList<>();
        datos.add(new InformacionAtributos("Rafaela", R.drawable.perrito_arreglado_1,"1"));
        datos.add(new InformacionAtributos("Carmen",R.drawable.perro_arreglado_2,"2"));
        datos.add(new InformacionAtributos("Giovanny",R.drawable.perro_arreglado_3,"3"));
        datos.add(new InformacionAtributos("Wilmer",R.drawable.perro_arreglado_4,"4"));
        datos.add(new InformacionAtributos("Andres",R.drawable.perro_arreglado_5,"5"));
    }
}