package com.peliculascampus;

import com.peliculascampus.genero.infrastructure.adapter.in.GeneroController;

public class Main {
    public static void main(String[] args) {
        
        GeneroController controller = new GeneroController();
        controller.generoMenu();
    }
}