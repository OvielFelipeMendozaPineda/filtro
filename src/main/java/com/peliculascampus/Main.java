package com.peliculascampus;

import java.util.Scanner;

import com.peliculascampus.Helpers.Credentials;
import com.peliculascampus.Helpers.Validaciones;
import com.peliculascampus.actor.infrastructure.adapter.in.ActorController;
import com.peliculascampus.formato.adapter.in.FormatoInAdapter;
import com.peliculascampus.formato.adapter.out.FormatoOutAdapter;
import com.peliculascampus.formato.application.FormatoService;
import com.peliculascampus.genero.infrastructure.adapter.in.GeneroController;
import com.peliculascampus.pais.infrastructure.adapter.in.PaisController;
import com.peliculascampus.pelicula.adapter.in.PeliculaInAdapter;
import com.peliculascampus.pelicula.adapter.out.PelicualOutAdapter;
import com.peliculascampus.pelicula.application.PeliculaService;
import com.peliculascampus.tipoActor.adapter.in.TipoActorInAdapter;
import com.peliculascampus.tipoActor.adapter.out.TipoActorOutRepository;
import com.peliculascampus.tipoActor.application.TipoActorService;

public class Main {
    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        Validaciones validar = new Validaciones();
        TipoActorOutRepository tipoActorOutRepository = new TipoActorOutRepository(Credentials.url, Credentials.username, Credentials.password);
        TipoActorService tipoActorService = new TipoActorService(tipoActorOutRepository);
        TipoActorInAdapter tipoActorInAdapter = new TipoActorInAdapter(tipoActorService);
        // tipoActorInAdapter.tipoActorMenu();
        PelicualOutAdapter pelicualOutAdapter = new PelicualOutAdapter(Credentials.url, Credentials.username, Credentials.password);
        PeliculaService peliculaService = new PeliculaService(pelicualOutAdapter, tipoActorOutRepository);

        PeliculaInAdapter peliculaInAdapter = new PeliculaInAdapter(peliculaService);

        FormatoOutAdapter formatoOutAdapter = new FormatoOutAdapter(Credentials.url, Credentials.username, Credentials.password);
        FormatoService formatoService = new FormatoService(formatoOutAdapter);
        FormatoInAdapter formatoInAdapter = new FormatoInAdapter(formatoService);
        final Scanner input = new Scanner(System.in);

        menuPrincipal: while (true) {
            System.out.println("Bienvenido a Peliculas Campus");
            System.out.println("============================");
            System.out.println("1. Menu Países");
            System.out.println("2. Menu Géneros");
            System.out.println("3. Formatos de Película");
            System.out.println("4. Tipos de Actores");
            System.out.println("5. Menu Películas");
            System.out.println("6. Menu Actores");
            System.out.println("0. Salir");
            int opcion = validar.readInt("Seleccione una opcion: ");
            switch (opcion) {
                case 1:
                    PaisController paisController = new PaisController();
                    paisController.paisMenu();
                    break;
                case 2:
                    GeneroController generoController = new GeneroController();
                    generoController.generoMenu();
                    break;
                case 3:
                    formatoInAdapter.formatoMenu();
                    break;
                case 4:
                tipoActorInAdapter.tipoActorMenu();
                    break;
                case 5:
                peliculaInAdapter.peliculaMenu();
                    break;
                case 6:
                    ActorController actorController = new ActorController();
                    actorController.actorMenu();
                    break;
                case 0:
                    break menuPrincipal;
                default:
                    System.out.println("--------La opcion seleccionada no existe --------");
                    System.out.println();
                    break;
            }
        }
    }
}