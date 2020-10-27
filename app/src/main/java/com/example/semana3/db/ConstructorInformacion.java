package com.example.semana3.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.semana3.Pojo.InformacionAtributos;
import com.example.semana3.R;

import java.util.ArrayList;

public class ConstructorInformacion {
    Context context;
    public ConstructorInformacion(Context context) {
        this.context = context;
    }

    public ArrayList<InformacionAtributos> obtenerInformacion(){
        /*ArrayList<InformacionAtributos> datos = new ArrayList<>();
        datos.add(new InformacionAtributos("Rafaela", R.drawable.perrito_arreglado_1,"1"));
        datos.add(new InformacionAtributos("Carmen",R.drawable.perro_arreglado_2,"2"));
        datos.add(new InformacionAtributos("Giovanny",R.drawable.perro_arreglado_3,"3"));
        datos.add(new InformacionAtributos("Wilmer",R.drawable.perro_arreglado_4,"4"));
        datos.add(new InformacionAtributos("Andres",R.drawable.perro_arreglado_5,"5"));
        return datos;*/

        //aqui se hace la conexion a la base da datos para que muestre los dato obtenidos anteriormente.
        BaseDatos baseDatos = new BaseDatos(context);
        insertarContactos(baseDatos);
        return baseDatos.obtenerDatos();
    }

    public void insertarContactos(BaseDatos baseDatos){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Rafaella");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.perrito_arreglado_1);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_RAITEADO,"5");
        baseDatos.insertarContactos(contentValues); //Estamos pasando estos datos a la clase Base Datos en el mismo metodo.

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Carmen");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.perro_arreglado_2);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_RAITEADO,"5");
        baseDatos.insertarContactos(contentValues); //Estamos pasando estos datos a la clase Base Datos en el mismo metodo.

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Juca");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.perro_arreglado_3);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_RAITEADO,"5");
        baseDatos.insertarContactos(contentValues); //Estamos pasando estos datos a la clase Base Datos en el mismo metodo.

    }
    public ArrayList<InformacionAtributos> obtenerInformacionPerfilFragment(){
        ArrayList<InformacionAtributos> datosInterface2 = new ArrayList<>();
        datosInterface2.add(new InformacionAtributos(R.drawable.perrito_arreglado_1, "1"));
        datosInterface2.add(new InformacionAtributos(R.drawable.perrito_arreglado_1, "4"));
        datosInterface2.add(new InformacionAtributos(R.drawable.perrito_arreglado_1, "5"));
        datosInterface2.add(new InformacionAtributos(R.drawable.perrito_arreglado_1, "3"));
        datosInterface2.add(new InformacionAtributos(R.drawable.perrito_arreglado_1, "3"));
        datosInterface2.add(new InformacionAtributos(R.drawable.perrito_arreglado_1, "1"));

        return datosInterface2;
    }
}
