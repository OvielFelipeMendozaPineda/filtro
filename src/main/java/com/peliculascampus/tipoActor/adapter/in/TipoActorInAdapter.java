package com.peliculascampus.tipoActor.adapter.in;

import com.peliculascampus.Helpers.Validaciones;
import com.peliculascampus.tipoActor.application.TipoActorService;
import com.peliculascampus.tipoActor.domain.TipoActor;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class TipoActorInAdapter {
    private final TipoActorService tipoActorService;
    Validaciones validar = new Validaciones();

    public TipoActorInAdapter(TipoActorService tipoActorService) {
        this.tipoActorService = tipoActorService;
    }


    public void tipoActorMenu() {
        menuTA: while (true) {
            System.out.println("Gestionar tipoActors");
            System.out.println("1. Crear tipoActor");
            System.out.println("2. Editar tipoActor");
            System.out.println("3. Buscar tipoActor por id.");
            System.out.println("4. Listar todos los tipoActors.");
            System.out.println("5. Eliminar tipoActor por id. ");
            System.out.println("0. Regresar.");
            int opcion = validar.readInt("Seleccione una opcion: ");
            switch (opcion) {
                case 1:
                    TipoActor tipoActor = new TipoActor();
                    String descripcion = validar.stringNotNull("Ingrese descripcion del tipoActor.");
                    tipoActor.setDescripcion(descripcion);
                    tipoActorService.guardarTipoActor(tipoActor);
                    break;
                case 2:
                    mostrarTipoActors();
                    TipoActor ta = validar.transformAndValidateObj(
                            () -> tipoActorService.buscarTipoActorPorId(validar.readInt("Ingrese el id del tipoActor que quiere actualizar: "))
                    );
                    descripcion = validar.stringNotNull("Ingrese nueva descripcion del tipoActor: ");
                    TipoActor tipoA = new TipoActor();
                    tipoA.setDescripcion(descripcion);
                    tipoA.setId(ta.getId());
                    tipoActorService.actualizarTipoActor(tipoA);
                    break;

                case 3:
                    mostrarTipoActors();
                    TipoActor tav = validar.transformAndValidateObj(
                            () -> tipoActorService.buscarTipoActorPorId(validar.readInt("Ingrese el id del tipoActor que quiere ver: "))
                    );

                    System.out.println(tav);
                    System.out.println("------------------------------------------");
                    break;
                case 4:
                    System.out.println("TipoActors guardados.");
                    mostrarTipoActors();
                    break;
                case 5:
                    mostrarTipoActors();
                    TipoActor tad = validar.transformAndValidateObj(
                            () -> tipoActorService.buscarTipoActorPorId(validar.readInt("Ingrese el id del tipoActor que quiere eliminar: "))
                    );
                    tipoActorService.eliminarTipoActor(tad.getId());
                    System.out.println("Tipo actor eliminado");
                    break;
                case 0:
                    break menuTA;

                default:
                    System.out.println("---- La opcion no existe ----");
                    System.out.println();
                    break;
            }
        }
    }

    public void mostrarTipoActors(){
        System.out.println("Listado de tipoActors: ");
        List<TipoActor> tipoActors = tipoActorService.listarTipoActor();
        tipoActors.forEach(tipoActor -> System.out.println(tipoActor));
        System.out.println("---------------------------------------");
    }
}
