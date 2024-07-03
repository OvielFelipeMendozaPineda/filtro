package com.peliculascampus.genero.domain;

public class Genero {
    private int id;
    private String descripcion;
    public Genero() {
    }
    public Genero(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @Override
    public String toString() {
        String border = "====================";
        return border + "\n" +
                "ID: " + id + "\n" +
                "Description: " + descripcion;
    }
    
}
