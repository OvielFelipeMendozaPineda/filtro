package com.peliculascampus.actor.infrastructure.adapter.in;

import java.util.List;
import java.util.Scanner;

import com.peliculascampus.actor.application.service.ActorService;
import com.peliculascampus.actor.domain.Actor;

/**
 * ActorController
 */
public class ActorController {

    private ActorService actorService;
    private NacionalidadController nacionalidadController;
    private GeneroController generoController;
    private Scanner input;

    public ActorController() {
        this.actorService = new ActorService();
        this.nacionalidadController = new NacionalidadController();
        this.generoController = new GeneroController();
        this.input = new Scanner(System.in);
    }

    public void actorMenu() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("Gestionar actores");
            System.out.println("1. Crear actor");
            System.out.println("2. Editar actor");
            System.out.println("3. Buscar actor por id.");
            System.out.println("4. Listar todos los actores.");
            System.out.println("5. Eliminar actor por id. ");
            System.out.println("0. Regresar.");
            opcion = input.nextInt();
            switch (opcion) {
                case 1:
                    Actor actor = new Actor();
                    System.out.println("Ingrese nombre del actor");
                    String nombre = input.nextLine();
                    actor.setNombre(nombre);
                    System.out.println("Ingrese edad del actor");
                    int edad = input.nextInt();
                    actor.setEdad(edad);
                    System.out.println("Igrese id de la nacionalidad.");
                    // nacionalidadController.list();
                    int idNacionalidad = input.nextInt();
                    System.out.println("Ingrese id del genero.");
                    // generoController.list();
                    int idGenero = input.nextInt();
                    actorService.create(actor);
                    break;
                case 2:
                    System.out.println("Ingrese nuevo  nombre del actor");
                    nombre = input.nextLine();
                    actor.setNombre(nombre);
                    System.out.println("Ingrese nuevo edad del actor");
                    edad = input.nextInt();
                    actor.setEdad(edad);
                    System.out.println("Igrese nuevo id de la nacionalidad.");
                    // nacionalidadController.list();
                    idNacionalidad = input.nextInt();
                    System.out.println("Ingrese nuevo  id del genero.");
                    // generoController.list();
                    idGenero = input.nextInt();
                    actorService.update(actor);
                    break;
                case 3:
                    System.out.println("Ingrese el id del actor.");
                    list();
                    int id = input.nextInt();
                    Actor selectedActor = actorService.getById(id);
                    System.out.println(selectedActor);
                    break;
                case 4:
                    System.out.println("Actores guardados.");
                    list();
                    break;
                case 5:
                    System.out.println("Ingrese id");
                    list();
                    id = input.nextInt();
                    actor = actorService.getById(id);
                    System.out.println("Se va a eliminar el actor: " + actor);
                    actorService.delete(id);
                    break;
                case 0:
                    return;

                default:
                    break;
            }
        }
    }
    public void list() {
        List<Actor> actores = actorService.getAll();
        actores.forEach(System.out::println);
    }
}