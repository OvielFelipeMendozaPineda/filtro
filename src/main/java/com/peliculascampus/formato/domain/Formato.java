package com.peliculascampus.formato.domain;

public class Formato {
    private int id;
    private String nombre;

    public Formato() {
    }

    public Formato(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        String border = "====================";
        return border + "\n" +
                "ID: " + id + "\n" +
                "Nombre: " + nombre;
    }
}
