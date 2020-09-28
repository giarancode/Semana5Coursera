package com.example.semana3.Pojo;

public class InformacionAtributos {
    private String nombre,ubicacion, raiting;
    private int foto;

    public InformacionAtributos(String nombre, int foto, String ubicacion) {
        this.nombre = nombre;
        this.foto = foto;
        this.ubicacion = ubicacion;
    }

    public InformacionAtributos(int foto, String raiting){ //Atributo Para segunda Interface, Encontrar Foto Perro & Cuanto Se raiteo.
        this.foto = foto;
        this.raiting= raiting;
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
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public String getRaiting() {
        return raiting;
    }
    public void setRaiting(String raiting) {
        this.raiting = raiting;
    }
}
