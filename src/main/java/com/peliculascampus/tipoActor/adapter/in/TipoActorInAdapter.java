package com.peliculascampus.tipoActor.adapter.in;

import com.peliculascampus.tipoActor.application.TipoActorService;
import com.peliculascampus.tipoActor.domain.TipoActor;
import com.peliculascampus.tipoActor.infrastructure.TipoActorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class TipoActorInAdapter {
    private final TipoActorService tipoActorService;
    Scanner input = new Scanner(System.in);

    public TipoActorInAdapter(TipoActorService tipoActorService) {
        this.tipoActorService = tipoActorService;
    }


    public void tipoActorMenu() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("Gestionar tipoActors");
            System.out.println("1. Crear tipoActor");
            System.out.println("2. Editar tipoActor");
            System.out.println("3. Buscar tipoActor por id.");
            System.out.println("4. Listar todos los tipoActors.");
            System.out.println("5. Eliminar tipoActor por id. ");
            System.out.println("0. Regresar.");
            opcion = input.nextInt();
            switch (opcion) {
                case 1:
                    TipoActor tipoActor = new TipoActor();
                    System.out.println("Ingrese descripcion del tipoActor.");
                    String descripcion = input.nextLine();
                    tipoActor.setDescripcion(descripcion);
                    tipoActorService.guardarTipoActor(tipoActor);
                    break;
                case 2:
                    mostrarTipoActors();
                    System.out.println("Ingrese el id del tipoActor que quiere actualizar: ");
                    int idf = Integer.parseInt(input.nextLine());
                    Optional<TipoActor> tipoActorGet = tipoActorService.buscarTipoActorPorId(idf);
                    System.out.println("Ingrese nueva descripcion del tipoActor.");
                    descripcion = input.nextLine();
                    tipoActorGet.get().setDescripcion(descripcion);
                    tipoActorService.actualizarTipoActor(tipoActorGet.get());
                    break;
                case 3:
                    System.out.println("Ingrese el id del tipoActor.");
                    mostrarTipoActors();
                    System.out.println("Ingrese el id del tipoActor que quiere buscar: ");
                    int idfb = Integer.parseInt(input.nextLine());

                    Optional<TipoActor> tipoActorEncontrado = tipoActorService.buscarTipoActorPorId(idfb);
                    System.out.println(tipoActorEncontrado.get());
                    break;
                case 4:
                    System.out.println("TipoActors guardados.");
                    mostrarTipoActors();
                    break;
                case 5:
                    mostrarTipoActors();
                    System.out.println("Ingrese el id del tipoActor que quiere buscar: ");
                    int idfd = Integer.parseInt(input.nextLine());
                    tipoActorService.eliminarTipoActor(idfd);
                    System.out.println("TipoActor eliminado");
                    break;
                case 0:
                    return;

                default:
                    break;
            }
        }
    }

    public void mostrarTipoActors(){
        System.out.println("Listado de tipoActors: ");
        List<TipoActor> tipoActors = new ArrayList<>();
        tipoActors.forEach(tipoActor -> System.out.println(tipoActor));
    }
}
