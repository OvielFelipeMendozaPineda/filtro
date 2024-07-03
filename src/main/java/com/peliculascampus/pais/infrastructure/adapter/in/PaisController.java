package com.peliculascampus.pais.infrastructure.adapter.in;

import java.util.List;
import java.util.Scanner;

import com.peliculascampus.pais.application.service.PaisService;
import com.peliculascampus.pais.domain.Pais;

public class PaisController {
    private PaisService paisService;
        private Scanner input;

    public PaisController() {
        this.paisService = new PaisService();
        this.input = new Scanner(System.in);
    }
    public void generoMenu() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("Gestionar paises");
            System.out.println("1. Crear pais");
            System.out.println("2. Editar pais");
            System.out.println("3. Buscar pais por id.");
            System.out.println("4. Listar todos los paises.");
            System.out.println("5. Eliminar pais por id. ");
            System.out.println("0. Regresar.");
            opcion = input.nextInt();
            switch (opcion) {
                case 1:
                input.nextLine();
                    Pais pais = new Pais();
                    System.out.println("Ingrese descripcion del paise.");
                    String descripcion = input.nextLine();
                    pais.setDescription(descripcion);
                    paisService.create(pais);
                    break;
                case 2:
                    input.nextLine();
                    list();
                    pais = paisService.getById(input.nextInt());
                    System.out.println("Ingrese nueva descripcion del paise.");
                    input.nextLine();
                    descripcion = input.nextLine();
                    pais.setDescription(descripcion);
                    paisService.update(pais);
                    break;
                case 3:
                input.nextLine();
                    System.out.println("Ingrese el id del paise.");
                    list();
                    int id = input.nextInt();
                    Pais selectedPais = paisService.getById(id);
                    System.out.println(selectedPais);
                    break;
                case 4:
                input.nextLine();
                    System.out.println("paises guardados.");
                    list();
                    break;
                case 5:
                input.nextLine();
                    System.out.println("Ingrese id");
                    list();
                    id = input.nextInt();
                    pais = paisService.getById(id);
                    System.out.println("Se va a eliminar el genero: " + pais);
                    paisService.delete(id);
                    break;
                case 0:
                input.nextLine();
                    return;

                default:
                    break;
            }
        }
    }

    public void list() {
        List<Pais> paises = paisService.getAll();
        paises.forEach(System.out::println);
    }

}
