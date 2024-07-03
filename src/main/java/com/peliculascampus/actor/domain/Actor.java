package com.peliculascampus.actor.domain;

public class Actor {
    private int id;
    private String nombre;
    private int idNacionalidad;
    private int edad;
    private int idGenero;
    public Actor() {
    }
    public Actor(String nombre, int idNacionalidad, int edad, int idGenero) {
        this.nombre = nombre;
        this.idNacionalidad = idNacionalidad;
        this.edad = edad;
        this.idGenero = idGenero;
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
    public int getIdNacionalidad() {
        return idNacionalidad;
    }
    public void setIdNacionalidad(int idNacionalidad) {
        this.idNacionalidad = idNacionalidad;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getIdGenero() {
        return idGenero;
    }
    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }
    @Override
    public String toString() {
        return "Actor [id=" + id + ", nombre=" + nombre + ", idNacionalidad=" + idNacionalidad + ", edad=" + edad
                + ", idGenero=" + idGenero + "]";
    }
    
}
