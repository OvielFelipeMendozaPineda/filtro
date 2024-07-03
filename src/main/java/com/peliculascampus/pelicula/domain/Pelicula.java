package com.peliculascampus.pelicula.domain;

public class Pelicula {
    private int id;
    private String codigointerno;
    private String nombre;
    private String duracion;
    private String sinopsis;

    public Pelicula() {
    }

    public Pelicula(int id, String codigointerno, String nombre, String duracion, String sinopsis) {
        this.id = id;
        this.codigointerno = codigointerno;
        this.nombre = nombre;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigointerno() {
        return codigointerno;
    }

    public void setCodigointerno(String codigointerno) {
        this.codigointerno = codigointerno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    @Override
    public String toString() {
        String border = "====================";
        return border + "\n" +
                "ID: " + id + "\n" +
                "Codigo Interno: " + codigointerno + "\n" +
                "Nombre: " + nombre + "\n" +
                "Duración: " + duracion + "\n" +
                "Sinopsis: " + sinopsis;
    }
}
