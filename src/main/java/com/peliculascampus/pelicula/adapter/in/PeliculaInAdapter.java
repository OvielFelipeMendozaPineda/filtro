package com.peliculascampus.pelicula.adapter.in;

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
    Scanner input = new Scanner(System.in);

    public PeliculaInAdapter(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
        this.generoController = new GeneroController();
        this.paisController = new PaisController();
    }

    public void peliculaMenu() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("Gestionar peliculas");
            System.out.println("1. Crear pelicula");
            System.out.println("2. Editar pelicula");
            System.out.println("3. Buscar pelicula por id.");
            System.out.println("4. Listar todos los peliculaes.");
            System.out.println("5. Eliminar pelicula por id. ");
            System.out.println("6. Asignar actor a pelicula");
            System.out.println("0. Regresar.");
            opcion = input.nextInt();
            switch (opcion) {
                case 1:
                    Pelicula pelicula = new Pelicula();
                    System.out.println("Ingrese el codigo interno de la pelicula: ");
                    String codigo = input.nextLine();
                    System.out.println("Ingrese nombre de la pelicula: ");
                    String nombre = input.nextLine();

                    System.out.println("Ingrese la duraciòn de la pelicula: ");
                    String duracion  = input.nextLine();
                    System.out.println("Ingrese la sinapsis de la pelicula: .");
                    String sinopsis = input.nextLine();

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

                    System.out.println("Seleccione el ID de la pelicula que queire editar: ");
                    int idPeli = input.nextInt();

                    System.out.println("Ingrese nuevo  nombre del pelicula");
                    nombre = input.nextLine();
                    System.out.println("Ingrese nuevo codigo interno de la pelicula");
                    codigo = input.nextLine();
                    System.out.println("Igrese nuevo duraciòn de la pelicula: ");
                    paisController.list();
                    duracion = input.nextLine();
                    System.out.println("Ingrese nuevo  sinapsis de la pelicula.");
                    generoController.list();
                    sinopsis = input.nextLine();

                    Pelicula pelicula1Up = new Pelicula();
                    pelicula1Up.setCodigointerno(codigo);
                    pelicula1Up.setNombre(nombre);
                    pelicula1Up.setDuracion(duracion);
                    pelicula1Up.setSinopsis(sinopsis);
                    pelicula1Up.setId(idPeli);
                    peliculaService.actualizarPelicua(pelicula1Up);
                    break;
                case 3:
                    System.out.println("Peliculaes registradas");
                    List<Pelicula> peliculass =  peliculaService.listarPeliculas();
                    peliculass.forEach(peli -> System.out.println(peli));

                    System.out.println("Ingrese el id de la pelicula:");
                    int id = input.nextInt();

                    Optional<Pelicula> selectedPelicula = peliculaService.buscarPeliculaPorId(id);
                    System.out.println(selectedPelicula.get());
                    break;
                case 4:
                    System.out.println("Peliculaes guardados registradas");
                    List<Pelicula> peliculasss =  peliculaService.listarPeliculas();
                    peliculasss.forEach(peli -> System.out.println(peli));
                    break;
                case 5:
                    System.out.println("Peliculaes guardados registradas");
                    List<Pelicula> peliculassss =  peliculaService.listarPeliculas();
                    peliculassss.forEach(peli -> System.out.println(peli));
                    System.out.println("Ingrese id");
                    id = input.nextInt();
                    Optional<Pelicula> peliD = peliculaService.buscarPeliculaPorId(id);
                    System.out.println("Se va a eliminar el pelicula: " + peliD.get().getNombre());
                    peliculaService.eliminarPelicula(id);
                    break;
                case 6:
                    System.out.println("Peliculas registradas");
                    List<Pelicula> peliculas1 =  peliculaService.listarPeliculas();
                    peliculas1.forEach(peli -> System.out.println(peli));
                    System.out.println("Seleccione la pelicula por el ID: ");
                    int idPeliculaSelect = input.nextInt();
                    Optional<Pelicula> peliSelect = peliculaService.buscarPeliculaPorId(idPeliculaSelect);

                    System.out.println("Listado de actores registrados: ");
                    List<Actor> actores = peliculaService.listarActores();
                    actores.forEach(actor -> System.out.println(actor));
                    System.out.println("Seleccionar el actor por el ID: ");
                    int idActor = input.nextInt();
                    Actor actorSelect = peliculaService.obtenerUnActor(idActor);
                    
                    System.out.println("Tipos de actores");
                    input.nextLine();
                    List<TipoActor> tiposDeActor = peliculaService.listarTipoActor();
                    tiposDeActor.forEach(tipo -> System.out.println(tipo));
                    System.out.println("Seleccione el tipo de actor por el ID: ");
                    int tipoActorId = input.nextInt();
                    Optional<TipoActor> tipoActorSelect = peliculaService.obtenerUnTA(tipoActorId);

                    peliculaService.peliculaProtagonista(peliSelect.get().getId(), actorSelect.getId(), tipoActorSelect.get().getId());

                    break;
                case 0:
                    return;

                default:
                    break;
            }
        }
    }
}
