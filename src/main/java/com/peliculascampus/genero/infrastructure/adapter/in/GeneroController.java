package com.peliculascampus.genero.infrastructure.adapter.in;

import java.util.List;
import java.util.Scanner;

import com.peliculascampus.Helpers.Validaciones;
import com.peliculascampus.genero.application.service.GeneroService;
import com.peliculascampus.genero.domain.Genero;

public class GeneroController {
    private GeneroService generoService;
    Validaciones validar = new Validaciones();

    public GeneroController() {
        this.generoService = new GeneroService();
    }

    public void generoMenu() {
        generos: while (true) {
            System.out.println("Gestionar Generos");
            System.out.println("1. Crear genero");
            System.out.println("2. Editar genero");
            System.out.println("3. Buscar genero por id.");
            System.out.println("4. Listar todos los generoes.");
            System.out.println("5. Eliminar genero por id. ");
            System.out.println("0. Regresar.");
            int opcion = validar.readInt("Seleccione una opcion: ");
            switch (opcion) {
                case 1:
                    Genero genero = new Genero();
                    String descripcion = validar.stringNotNull("Ingrese descripcion del genero.");
                    genero.setDescripcion(descripcion);
                    generoService.create(genero);
                    break;
                case 2:
                    list();
                    int idGenero = validar.readInt("Seleccione el genero por su ID: ");
                    genero = generoService.getById(idGenero);
                    descripcion = validar.stringNotNull("Ingrese nueva descripcion del genero: ");
                    genero.setDescripcion(descripcion);
                    generoService.update(genero);
                    break;
                case 3:
                    list();
                    int id = validar.readInt("Ingrese el id del genero: ");
                    Genero selectedGenero = generoService.getById(id);
                    System.out.println(selectedGenero);
                    break;
                case 4:
                    System.out.println("Generos guardados.");
                    list();
                    break;
                case 5:
                    list();
                    id = validar.readInt("Ingrese id: ");
                    genero = generoService.getById(id);
                    System.out.println("Se va a eliminar el genero: " + genero);
                    generoService.delete(id);
                    break;
                case 0:
                    break generos;
                default:
                    System.out.println("----- La opcion no existe -----");
                    break;
            }
        }
    }

    public void list() {
        List<Genero> generos = generoService.getAll();
        generos.forEach(System.out::println);
        System.out.println();
    }

}
