package com.peliculascampus.formato.adapter.in;

import com.peliculascampus.Helpers.Validaciones;
import com.peliculascampus.formato.application.FormatoService;
import com.peliculascampus.formato.domain.Formato;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class FormatoInAdapter {

    private final FormatoService formatoService;
    Validaciones validar = new Validaciones();

    public FormatoInAdapter(FormatoService formatoService) {
        this.formatoService = formatoService;
    }


    public void formatoMenu() {
        menuformato: while (true) {
            System.out.println("Gestionar formatos");
            System.out.println("1. Crear formato");
            System.out.println("2. Editar formato");
            System.out.println("3. Buscar formato por id.");
            System.out.println("4. Listar todos los formatos.");
            System.out.println("5. Eliminar formato por id. ");
            System.out.println("0. Regresar.");
            int opcion = validar.readInt("Seleccione una opcion: ");
            switch (opcion) {
                case 1:
                    Formato formato = new Formato();
                    String descripcion = validar.stringNotNull("Ingrese descripcion del formato: ");
                    formato.setNombre(descripcion);
                    formatoService.guardarFormato(formato);
                    break;
                case 2:
                    mostrarFormatos();
                    Formato form = validar.transformAndValidateObj(
                            () -> formatoService.buscarFormatoPorId(validar.readInt("Ingrese el id del formato a actualizar:"))
                    );
                    descripcion = validar.stringNotNull("Ingrese nueva descripcion del formato: ");
                    Formato newFormat = new Formato();
                    newFormat.setNombre(descripcion);
                    newFormat.setId(form.getId());
                    formatoService.actualizarFormato(newFormat);
                    break;
                case 3:
                    System.out.println("Ingrese el id del formato.");
                    mostrarFormatos();
                    int idfb = validar.readInt("Ingrese el id del formato que quiere buscar: ");

                    Optional<Formato> formatoEncontrado = formatoService.buscarFormatoPorId(idfb);
                    System.out.println(formatoEncontrado.get());
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Formatos guardados:");
                    mostrarFormatos();
                    break;
                case 5:
                    mostrarFormatos();
                    int idfd = validar.readInt("Ingrese el id del formato que quiere buscar: ");
                    formatoService.eliminarFormato(idfd);
                    System.out.println("Formato eliminado");
                    break;
                case 0:
                    break menuformato;
                default:
                    System.out.println("----- La opcion seleccionada no existe -----");
                    break;
            }
        }
    }

    public void mostrarFormatos(){
        System.out.println("Listado de formatos: ");
        List<Formato> formatos = formatoService.listarFormatos();
        formatos.forEach(formato -> System.out.println(formato));
        System.out.println();
    }


}
