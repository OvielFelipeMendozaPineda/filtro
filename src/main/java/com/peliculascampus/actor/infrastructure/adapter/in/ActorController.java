package com.peliculascampus.actor.infrastructure.adapter.in;

import java.util.List;
import java.util.Scanner;

import com.peliculascampus.Helpers.Validaciones;
import com.peliculascampus.actor.application.service.ActorService;
import com.peliculascampus.actor.domain.Actor;
import com.peliculascampus.genero.infrastructure.adapter.in.GeneroController;
import com.peliculascampus.pais.infrastructure.adapter.in.PaisController;

/**
 * ActorController
 */
public class ActorController {

    private ActorService actorService;
    private PaisController paisController;
    private GeneroController generoController;
    Validaciones validar = new Validaciones();

    public ActorController() {
        this.actorService = new ActorService();
        this.paisController = new PaisController();
        this.generoController = new GeneroController();
    }

    public void actorMenu() {
        actores: while (true) {
            System.out.println("Gestionar actores");
            System.out.println("1. Crear actor");
            System.out.println("2. Editar actor");
            System.out.println("3. Buscar actor por id.");
            System.out.println("4. Listar todos los actores.");
            System.out.println("5. Eliminar actor por id. ");
            System.out.println("0. Regresar.");
            int opcion = validar.readInt("Seleccione una opcion: ");
            switch (opcion) {
                case 1:
                    Actor actor = new Actor();
                    String nombre = validar.stringNotNull("Ingrese nombre del actor: ");
                    actor.setNombre(nombre);
                    int edad = validar.readInt("Ingrese edad del actor: ");
                    actor.setEdad(edad);
                    paisController.list();
                    int idNacionalidad = validar.readInt("Ingrese id de la nacionalidad: ");
                    actor.setIdNacionalidad(idNacionalidad);
                    generoController.list();
                    int idGenero = validar.readInt("Ingrese id del genero: ");
                    actor.setIdGenero(idGenero);
                    actorService.create(actor);
                    break;
                case 2:
                    list();
                    int idAc = validar.readInt("Ingrese el id: ");
                    Actor actor2 = actorService.getById(idAc);
                    nombre = validar.stringNotNull("Ingrese nuevo  nombre del actor: ");
                    actor2.setNombre(nombre);
                    edad = validar.readInt("Ingrese nuevo edad del actor: ");
                    actor2.setEdad(edad);
                    paisController.list();
                    idNacionalidad = validar.readInt("Igrese nuevo id de la nacionalidad: ");
                    generoController.list();
                    idGenero = validar.readInt("Ingrese nuevo  id del genero: ");
                    actorService.update(actor2);
                    break;
                case 3:
                    list();
                    int id = validar.readInt("Ingrese el id del actor: ");
                    Actor selectedActor = actorService.getById(id);
                    System.out.println(selectedActor);
                    System.out.println("-----------------------------------------------");
                    break;

                case 4:
                    System.out.println("Actores guardados.");
                    list();
                    System.out.println("--------------------------------------------");
                    break;
                case 5:
                    list();
                    id = validar.readInt("Ingrese id: ");
                    actor = actorService.getById(id);
                    System.out.println("Se va a eliminar el actor: " + actor);
                    actorService.delete(actor.getId());
                    break;
                case 0:
                    break actores;

                default:
                    System.out.println("----------- la opcion no existe -----------");
                    break;
            }
        }
    }

    public void list() {
        List<Actor> actores = actorService.getAll();
        actores.forEach(System.out::println);
        System.out.println();

    }
}