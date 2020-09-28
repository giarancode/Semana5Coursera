package com.example.semana3.adaptador;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.semana3.Pojo.InformacionAtributos;
import com.example.semana3.R;

import java.util.ArrayList;

public class AdaptadorCardView extends RecyclerView.Adapter<AdaptadorCardView.TarjetaViewHolder>{
    ArrayList<InformacionAtributos> datos;
    Activity activity;
    public AdaptadorCardView(ArrayList<InformacionAtributos> datos, Activity activity){
        this.datos = datos;
        this.activity = activity;
    }
    @NonNull
    @Override
    public TarjetaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new TarjetaViewHolder(v);
}
    @Override
    public void onBindViewHolder(@NonNull final TarjetaViewHolder holder, final int position) {
        final InformacionAtributos informacion = datos.get(position);
        holder.tvNombre.setText(informacion.getNombre());
        holder.ivPerro.setImageResource(informacion.getFoto());
        holder.HuesoIzquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popup = new PopupMenu(activity,v);
                popup.inflate(R.menu.popup_menu);
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.item1:
                                Toast.makeText(activity,informacion.getNombre()+": Te gusto un: 5" , Toast.LENGTH_SHORT).show();
                                holder.tvNumeroPerro.setText("5");

                                return true;
                            case R.id.item2:
                                Toast.makeText(activity,informacion.getNombre()+": Te gusto un: 4" , Toast.LENGTH_SHORT).show();
                                holder.tvNumeroPerro.setText("4");
                                return true;
                            case R.id.item3:
                                Toast.makeText(activity,informacion.getNombre()+": Te gusto un: 3" , Toast.LENGTH_SHORT).show();
                                holder.tvNumeroPerro.setText("3");
                                return true;
                            case R.id.item4:
                                Toast.makeText(activity,informacion.getNombre()+": Te gusto un: 2" , Toast.LENGTH_SHORT).show();
                                holder.tvNumeroPerro.setText("2");
                                return true;
                            case R.id.item5:
                                Toast.makeText(activity,informacion.getNombre()+": Te gusto un: 1" , Toast.LENGTH_SHORT).show();
                                holder.tvNumeroPerro.setText("1");
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                popup.show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class TarjetaViewHolder extends RecyclerView.ViewHolder{
        public ImageView ivPerro,Huesito_Amarillo;
        public TextView tvNombre, tvNumeroPerro;
        public ImageButton HuesoIzquierda;


        public TarjetaViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPerro         = itemView.findViewById(R.id.ivPerro);
            tvNombre        = itemView.findViewById(R.id.tvNombre);
            tvNumeroPerro   = itemView.findViewById(R.id.tvNumeroPerro);
            HuesoIzquierda  = itemView.findViewById(R.id.HuesoIzquierda);
            Huesito_Amarillo= itemView.findViewById(R.id.Huesito_Amarillo);

        }
    }

}
