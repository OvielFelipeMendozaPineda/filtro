package com.peliculascampus.pelicula.adapter.in;

import com.peliculascampus.Helpers.Validaciones;
import com.peliculascampus.pelicula.domain.Pelicula;
import com.peliculascampus.tipoActor.domain.TipoActor;
import com.peliculascampus.actor.domain.Actor;
import com.peliculascampus.genero.infrastructure.adapter.in.GeneroController;
import com.peliculascampus.pais.infrastructure.adapter.in.PaisController;
import com.peliculascampus.pelicula.application.PeliculaService;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class PeliculaInAdapter {
    private final PeliculaService peliculaService;
    private PaisController paisController;
    private GeneroController generoController;
    Validaciones validar = new Validaciones();
    public PeliculaInAdapter(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
        this.generoController = new GeneroController();
        this.paisController = new PaisController();
    }

    public void peliculaMenu() {
        peliculasM: while (true) {
            System.out.println("Gestionar peliculas");
            System.out.println("1. Crear pelicula");
            System.out.println("2. Editar pelicula");
            System.out.println("3. Buscar pelicula por id.");
            System.out.println("4. Listar todos los peliculaes.");
            System.out.println("5. Eliminar pelicula por id. ");
            System.out.println("6. Asignar actor a pelicula");
            System.out.println("0. Regresar.");
            int opcion = validar.readInt("Seleccione una opcion: ");
            switch (opcion) {
                case 1:
                    Pelicula pelicula = new Pelicula();
                    String codigo = validar.stringWithLeght("Ingrese el codigo interno de la pelicula, maximo 5 caracteres: ", 5);
                    String nombre = validar.stringNotNull("Ingrese nombre de la pelicula: ");
                    String duracion  = validar.stringNotNull("Ingrese la duraciòn de la pelicula: ");
                    String sinopsis = validar.stringNotNull("Ingrese la sinapsis de la pelicula: ");

                    pelicula.setCodigointerno(codigo);
                    pelicula.setNombre(nombre);
                    pelicula.setDuracion(duracion);
                    pelicula.setSinopsis(sinopsis);
                    peliculaService.guardarPelicula(pelicula);
                    break;
                case 2:
                    System.out.println("Peliculas registradas");
                    List<Pelicula> peliculas =  peliculaService.listarPeliculas();
                    peliculas.forEach(peli -> System.out.println(peli));
                    System.out.println();
                    System.out.println("Seleccione el ID de la pelicula que queire editar: ");
                    Pelicula peliSelect = validar.transformAndValidateObj(
                            () -> peliculaService.buscarPeliculaPorId(validar.readInt("Seleccione la pelicula por el ID: "))
                    );

                    nombre = validar.stringNotNull("Ingrese nuevo  nombre del pelicula: ");
                    codigo = validar.stringNotNull("Ingrese nuevo codigo interno de la pelicula: ");
                    duracion = validar.stringNotNull("Igrese nuevo duraciòn de la pelicula: ");
                    sinopsis = validar.stringNotNull("Ingrese nuevo  sinapsis de la pelicula: ");

                    Pelicula pelicula1Up = new Pelicula();
                    pelicula1Up.setCodigointerno(codigo);
                    pelicula1Up.setNombre(nombre);
                    pelicula1Up.setDuracion(duracion);
                    pelicula1Up.setSinopsis(sinopsis);
                    pelicula1Up.setId(peliSelect.getId());
                    peliculaService.actualizarPelicua(pelicula1Up);
                    break;
                case 3:
                    System.out.println("Peliculaes registradas");
                    List<Pelicula> peliculass =  peliculaService.listarPeliculas();
                    peliculass.forEach(peli -> System.out.println(peli));
                    System.out.println();
                    Pelicula peliSelectv = validar.transformAndValidateObj(
                            () -> peliculaService.buscarPeliculaPorId(validar.readInt("Seleccione la pelicula por el ID: "))
                    );
                    System.out.println(peliSelectv);
                    break;
                case 4:
                    System.out.println("Peliculaes guardados registradas");
                    List<Pelicula> peliculasss =  peliculaService.listarPeliculas();
                    peliculasss.forEach(peli -> System.out.println(peli));
                    System.out.println("-----------------------------------------------");
                    break;
                case 5:
                    System.out.println("Peliculas guardados registradas");
                    List<Pelicula> peliculassss =  peliculaService.listarPeliculas();
                    peliculassss.forEach(peli -> System.out.println(peli));
                    Pelicula peliSelectd = validar.transformAndValidateObj(
                            () -> peliculaService.buscarPeliculaPorId(validar.readInt("Seleccione la pelicula por el ID: "))
                    );
                    System.out.println("Se va a eliminar el pelicula: " + peliSelectd.getNombre());
                    peliculaService.eliminarPelicula(peliSelectd.getId());
                    break;

                case 6:
                    System.out.println("Peliculas registradas");
                    List<Pelicula> peliculas1 =  peliculaService.listarPeliculas();
                    peliculas1.forEach(peli -> System.out.println(peli));
                    System.out.println();
                    Pelicula peliculaSelect = validar.transformAndValidateObj(
                            () -> peliculaService.buscarPeliculaPorId(validar.readInt("Seleccione la pelicula por el ID: "))
                    );

                    System.out.println("Listado de actores registrados: ");
                    List<Actor> actores = peliculaService.listarActores();
                    actores.forEach(actor -> System.out.println(actor));
                    System.out.println();
                    int idActor = validar.readInt("Seleccionar el actor por el ID: ");
                    Actor actorSelect = peliculaService.obtenerUnActor(idActor);
                    
                    System.out.println("Tipos de actores");
                    List<TipoActor> tiposDeActor = peliculaService.listarTipoActor();
                    tiposDeActor.forEach(tipo -> System.out.println(tipo));
                    System.out.println();

                    TipoActor tad = validar.transformAndValidateObj(
                            () -> peliculaService.obtenerUnTA(validar.readInt("Ingrese el id del tipo de actor: "))
                    );

                    peliculaService.peliculaProtagonista(peliculaSelect.getId(), actorSelect.getId(), tad.getId());

                    break;
                case 0:
                    break peliculasM;

                default:
                    System.out.println("------ la opcion no existe ---------");
                    System.out.println();
                    break;
            }
        }
    }
}
