package com.example.semana3.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.semana3.Pojo.InformacionAtributos;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {
    Context context;
    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryCrearTablaMascotas= "CREATE TABLE " + ConstantesBaseDatos.DATABASE_NAME + "(" +
                                         ConstantesBaseDatos.TABLE_MASCOTAS_ID           + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                         ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE       + " TEXT, " +
                                         ConstantesBaseDatos.TABLE_MASCOTAS_FOTO         + " INTEGER, " +
                                         ConstantesBaseDatos.TABLE_MASCOTAS_RAITEADO     + " TEXT " +
                                         //ConstantesBaseDatos.TABLE_MASCOTAS_NUMEROVOTADO + " INTEGER" +
                                         ")";
        String queryCrearTablaMascotasElegidas= "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS_ELEGIDAS + " (" +
                                         ConstantesBaseDatos.TABLE_MASCOTAS_ELEGIDAS_ID           + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                         ConstantesBaseDatos.TABLE_MASCOTAS_ELEGIDAS_NOMBRE       + " TEXT, " +
                                         ConstantesBaseDatos.TABLE_MASCOTAS_ELEGIDAS_FOTO         + " INTEGER, " +
                                         ConstantesBaseDatos.TABLE_MASCOTAS_ELEGIDAS_NUMEROVOTADO + " TEXT, " +
                                         "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_MASCOTAS_ELEGIDAS_NOMBRE + ") " +
                                         "REFERENCES "+ ConstantesBaseDatos.TABLE_MASCOTAS + "("+ConstantesBaseDatos.TABLE_MASCOTAS_ID+")" +
                                         ")";
        sqLiteDatabase.execSQL(queryCrearTablaMascotas);
        sqLiteDatabase.execSQL(queryCrearTablaMascotasElegidas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS_ELEGIDAS);
        onCreate(sqLiteDatabase);
    }

    public ArrayList<InformacionAtributos> obtenerDatos(){
        ArrayList<InformacionAtributos> listaDeAnimales = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor registros = sqLiteDatabase.rawQuery(query,null);

        while (registros.moveToNext()){
            InformacionAtributos posicionActual = new InformacionAtributos();
            posicionActual.setID(registros.getInt(0));          //estos son los datos que se crean en el POJO
            posicionActual.setNombre(registros.getString(1));
            posicionActual.setFoto(registros.getInt(2));
            posicionActual.setRaiting(registros.getString(3));
            listaDeAnimales.add(posicionActual);
        }
        sqLiteDatabase.close();
        return listaDeAnimales;
    }

    public void insertarContactos(ContentValues contentValues){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase(); //Abrimos la conexion de la baseDatos
        sqLiteDatabase.insert(ConstantesBaseDatos.TABLE_MASCOTAS,null,contentValues);
        sqLiteDatabase.close();
    }

}
