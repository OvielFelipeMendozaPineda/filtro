package com.peliculascampus.genero.infrastructure.adapter.in;

import java.util.List;
import java.util.Scanner;

import com.peliculascampus.genero.application.service.GeneroService;
import com.peliculascampus.genero.domain.Genero;

public class GeneroController {
    private GeneroService generoService;
    private Scanner input;

    public GeneroController() {
        this.generoService = new GeneroService();
        this.input = new Scanner(System.in);
    }

    public void generoMenu() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("Gestionar actores");
            System.out.println("1. Crear genero");
            System.out.println("2. Editar genero");
            System.out.println("3. Buscar genero por id.");
            System.out.println("4. Listar todos los generoes.");
            System.out.println("5. Eliminar genero por id. ");
            System.out.println("0. Regresar.");
            opcion = input.nextInt();
            switch (opcion) {
                case 1:
                    Genero genero = new Genero();
                    System.out.println("Ingrese descripcion del genero.");
                    String descripcion = input.nextLine();
                    genero.setDescripcion(descripcion);
                    generoService.create(genero);
                    break;
                case 2:
                    list();
                    genero = generoService.getById(input.nextInt());
                    System.out.println("Ingrese nueva descripcion del genero.");
                    descripcion = input.nextLine();
                    genero.setDescripcion(descripcion);
                    generoService.create(genero);
                    break;
                case 3:
                    System.out.println("Ingrese el id del genero.");
                    list();
                    int id = input.nextInt();
                    Genero selectedGenero = generoService.getById(id);
                    System.out.println(selectedGenero);
                    break;
                case 4:
                    System.out.println("Generos guardados.");
                    list();
                    break;
                case 5:
                    System.out.println("Ingrese id");
                    list();
                    id = input.nextInt();
                    genero = generoService.getById(id);
                    System.out.println("Se va a eliminar el genero: " + genero);
                    generoService.delete(id);
                    break;
                case 0:
                    return;

                default:
                    break;
            }
        }
    }

    public void list() {
        List<Genero> generos = generoService.getAll();
        generos.forEach(System.out::println);
    }
}
