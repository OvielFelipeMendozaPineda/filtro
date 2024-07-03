package com.peliculascampus.pais.domain;

public class Pais {
    private int id;
    private String description;
    public Pais() {
    }
    public Pais(String description) {
        this.description = description;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        String border = "====================";
        return border + "\n" +
                "ID: " + id + "\n" +
                "Description: " + description + "\n";
    }
    
}
