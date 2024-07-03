package com.peliculascampus.pais.infrastructure.adapter.in;

import java.util.List;
import java.util.Scanner;

import com.peliculascampus.Helpers.Validaciones;
import com.peliculascampus.pais.application.service.PaisService;
import com.peliculascampus.pais.domain.Pais;

public class PaisController {
    private PaisService paisService;
        private Validaciones validar = new Validaciones();

    public PaisController() {
        this.paisService = new PaisService();
    }
    public void paisMenu() {
        paismenu:while (true) {
            System.out.println("Gestionar paises");
            System.out.println("1. Crear pais");
            System.out.println("2. Editar pais");
            System.out.println("3. Buscar pais por id.");
            System.out.println("4. Listar todos los paises.");
            System.out.println("5. Eliminar pais por id. ");
            System.out.println("0. Regresar.");
            int opcion = validar.readInt("Seleccione una opcion");
            switch (opcion) {
                case 1:
                    Pais pais = new Pais();
                    String descripcion = validar.stringNotNull("Ingrese descripcion del paise: ");
                    pais.setDescription(descripcion);
                    paisService.create(pais);
                    break;
                case 2:
                    list();
                    int idPais = validar.readInt("Seleccione el id del pais que va a editar: ");
                    pais = paisService.getById(idPais);
                    descripcion = validar.stringNotNull("Ingrese descripcion del paise: ");
                    pais.setDescription(descripcion);
                    paisService.update(pais);
                    break;
                case 3:
                    list();
                    int id = validar.readInt("Ingrese el id del paise: ");
                    Pais selectedPais = paisService.getById(id);
                    System.out.println(selectedPais);
                    break;
                case 4:
                    System.out.println("paises guardados.");
                    list();
                    break;
                case 5:
                    list();
                    id = validar.readInt("Ingrese el id del paise: ");
                    pais = paisService.getById(id);
                    System.out.println("Se va a eliminar el genero: " + pais);
                    paisService.delete(id);
                    break;
                case 0:
                    break paismenu;
                default:
                    System.out.println("---- La opcion no existe ----");
                    System.out.println();
                    break;
            }
        }
    }

    public void list() {
        List<Pais> paises = paisService.getAll();
        paises.forEach(System.out::println);
    }
}