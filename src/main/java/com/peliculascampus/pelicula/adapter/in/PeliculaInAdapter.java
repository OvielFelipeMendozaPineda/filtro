package com.peliculascampus.pelicula.adapter.in;

import com.peliculascampus.pelicula.domain.Pelicula;
import com.peliculascampus.pelicula.application.PeliculaService;
import com.peliculascampus.pelicula.domain.Pelicula;
import com.peliculascampus.pelicula.infrastructure.PeliculaRepository;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class PeliculaInAdapter {
    private final PeliculaService peliculaService;
    Scanner input = new Scanner(System.in);

    public PeliculaInAdapter(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
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
                    System.out.println("Peliculaes registradas");
                    List<Pelicula> peliculas =  peliculaService.listarPeliculas();
                    peliculas.forEach(peli -> System.out.println(peli));

                    System.out.println("Seleccione el ID de la pelicula que queire editar: ");
                    int idPeli = Integer.parseInt(input.nextLine());


                    System.out.println("Ingrese nuevo  nombre del pelicula");
                    nombre = input.nextLine();
                    System.out.println("Ingrese nuevo codigo interno de la pelicula");
                    codigo = input.nextLine();
                    System.out.println("Igrese nuevo duraciòn de la pelicula: ");
                    // nacionalidadController.list();
                    duracion = input.nextLine();
                    System.out.println("Ingrese nuevo  sinapsis de la pelicula.");
                    // generoController.list();
                    sinopsis = input.nextLine();

                    Pelicula pelicula1Up = new Pelicula();
                    pelicula1Up.setCodigointerno(codigo);
                    pelicula1Up.setNombre(nombre);
                    pelicula1Up.setDuracion(duracion);
                    pelicula1Up.setSinopsis(sinopsis);

                    peliculaService.actualizarPelicua(pelicula1Up);
                    break;
                case 3:
                    System.out.println("Peliculaes registradas");
                    List<Pelicula> peliculass =  peliculaService.listarPeliculas();
                    peliculass.forEach(peli -> System.out.println(peli));

                    System.out.println("Ingrese el id de la pelicula:");
                    int id = Integer.parseInt(input.nextLine());

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
                case 0:
                    return;

                default:
                    break;
            }
        }
    }
}
