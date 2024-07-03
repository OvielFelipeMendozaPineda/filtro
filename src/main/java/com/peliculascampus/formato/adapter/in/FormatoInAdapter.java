package com.peliculascampus.formato.adapter.in;

import com.peliculascampus.formato.application.FormatoService;
import com.peliculascampus.formato.domain.Formato;
import com.peliculascampus.genero.domain.Genero;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class FormatoInAdapter {

    private final FormatoService formatoService;
    Scanner input = new Scanner(System.in);

    public FormatoInAdapter(FormatoService formatoService) {
        this.formatoService = formatoService;
    }


    public void generoMenu() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("Gestionar formatos");
            System.out.println("1. Crear formato");
            System.out.println("2. Editar formato");
            System.out.println("3. Buscar formato por id.");
            System.out.println("4. Listar todos los formatos.");
            System.out.println("5. Eliminar formato por id. ");
            System.out.println("0. Regresar.");
            opcion = input.nextInt();
            switch (opcion) {
                case 1:
                    Formato formato = new Formato();
                    System.out.println("Ingrese descripcion del formato.");
                    String descripcion = input.nextLine();
                    formato.setNombre(descripcion);
                    formatoService.guardarFormato(formato);
                    break;
                case 2:
                    mostrarFormatos();
                    System.out.println("Ingrese el id del formato que quiere actualizar: ");
                    int idf = Integer.parseInt(input.nextLine());
                    Optional<Formato> formatoGet = formatoService.buscarFormatoPorId(idf);
                    System.out.println("Ingrese nueva descripcion del formato.");
                    descripcion = input.nextLine();
                    formatoGet.get().setNombre(descripcion);
                    formatoService.actualizarFormato(formatoGet.get());
                    break;
                case 3:
                    System.out.println("Ingrese el id del formato.");
                    mostrarFormatos();
                    System.out.println("Ingrese el id del formato que quiere buscar: ");
                    int idfb = Integer.parseInt(input.nextLine());

                    Optional<Formato> formatoEncontrado = formatoService.buscarFormatoPorId(idfb);
                    System.out.println(formatoEncontrado.get());
                    break;
                case 4:
                    System.out.println("Formatos guardados.");
                    mostrarFormatos();
                    break;
                case 5:
                    mostrarFormatos();
                    System.out.println("Ingrese el id del formato que quiere buscar: ");
                    int idfd = Integer.parseInt(input.nextLine());
                    formatoService.eliminarFormato(idfd);
                    System.out.println("Formato eliminado");
                    break;
                case 0:
                    return;

                default:
                    break;
            }
        }
    }

    public void mostrarFormatos(){
        System.out.println("Listado de formatos: ");
        List<Formato> formatos = new ArrayList<>();
        formatos.forEach(formato -> System.out.println(formato));
    }


}
