package com.example.semana3.Pojo;

public class InformacionAtributos {
    private String nombre, raiting;
    private int foto, ID;



    public InformacionAtributos(String nombre, int foto, String raiting) {
        this.nombre = nombre;
        this.foto = foto;
        this.raiting =raiting;
    }

    public InformacionAtributos(int foto, String raiting){ //Atributo Para segunda Interface, Encontrar Foto Perro & Cuanto Se raiteo.
        this.foto = foto;
        this.raiting= raiting;
    }

    public InformacionAtributos() {

    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getFoto() {
        return foto;
    }
    public void setFoto(int foto) {
        this.foto = foto;
    }
    public String getRaiting() {
        return raiting;
    }
    public void setRaiting(String raiting) {
        this.raiting = raiting;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
}
