package com.example.semana3.adaptador;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.semana3.Pojo.InformacionAtributos;
import com.example.semana3.R;

import java.util.ArrayList;

public class AdaptorCardViewInterface2 extends RecyclerView.Adapter<AdaptorCardViewInterface2.TarjetaViewHolder2> {
    ArrayList<InformacionAtributos> datosInterface2;
    Activity activity;
    public AdaptorCardViewInterface2(ArrayList<InformacionAtributos> datosInterface2, Activity activity){
        this.datosInterface2 = datosInterface2;
        this.activity = activity;
    }

    @NonNull
    @Override
    public TarjetaViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_nterface_2,parent,false);
        return new TarjetaViewHolder2(v);
    }
    @Override
    public void onBindViewHolder(@NonNull TarjetaViewHolder2 holder, int position) {
        final InformacionAtributos informacion = datosInterface2.get(position);
        holder.ivPerro.setImageResource(informacion.getFoto());
        holder.tvNumeroPerro.setText(informacion.getRaiting());
    }

    @Override
    public int getItemCount() {
        return datosInterface2.size();
    }

    public static class TarjetaViewHolder2 extends RecyclerView.ViewHolder{
        public ImageView ivPerro,Huesito_Amarillo; //Se relacionan los elementos View que se crearon en card_nterface_2
        public TextView  tvNumeroPerro;
        public CardView TarjetaCardViewInterface2;

        public TarjetaViewHolder2(@NonNull View itemView) {
            super(itemView);
            ivPerro         = itemView.findViewById(R.id.ivPerro);//Se le asigna la variable del Layout con la parte logica.
            tvNumeroPerro   = itemView.findViewById(R.id.tvNumeroPerro);
            Huesito_Amarillo= itemView.findViewById(R.id.Huesito_Amarillo);
            TarjetaCardViewInterface2 = itemView.findViewById(R.id.cvTarjetaCardViewInterface2);

        }
    }
}
