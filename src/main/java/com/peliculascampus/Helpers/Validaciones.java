package com.peliculascampus.Helpers;

import java.util.Optional;
import java.util.Scanner;
import java.util.function.Supplier;

public class Validaciones {
    Scanner scanner;
    public Validaciones(){
        this.scanner = new Scanner(System.in);
    }

    public int readInt(String mensaje){
        int valor;
        while (true){
            System.out.println(mensaje);
            try{
                valor =  Integer.parseInt(scanner.nextLine());
                break;
            }catch (NumberFormatException e){
                System.out.print("Debe ingresar un dato valido, ");
            }
        }
        return valor;
    }

    public String stringNotNull(String message){
        System.out.print(message);
        String value;
        while (true){
            value = scanner.nextLine();
            if (value.isBlank()){
                System.out.print("Este es un campo obligatorio, " + message.toLowerCase());
            }else{
                break;
            }
        }
        return value;
    }

    public String stringWithLeght(String message, int lenght){
        String value;
        while (true){
            value = this.stringNotNull(message);
            if (value.length() > lenght){
                System.out.print("Error, ");
            }else {
                break;
            }
        }
        return value;
    }

    public String stringNull(String message){
        System.out.print(message);
        return scanner.nextLine();
    }

    public String yesOrNo(String message){
        String option;
        while (true){
            option = this.stringNotNull(message);
            if (!option.equals("y") && !option.equals("n")){
                System.out.print("Ingresa una opción valida, ");
            }else {
                break;
            }
        }
        return option;
    }

    public <T> T transformAndValidateObj(Supplier<Optional<T>> supplier){
        T objetoSeleccionado = null;
        while (true) {
            Optional<T> objetoOpcional = supplier.get();
            if (objetoOpcional.isPresent()) {
                return objetoSeleccionado = objetoOpcional.get();
            } else {
                System.out.println("El id no existe");
            }
        }
    }
}
