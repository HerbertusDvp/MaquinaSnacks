package maquinaSnacksArchivos.presentacion;

import maquinaSnacksArchivos.dominio.Snack;
import maquinaSnacksArchivos.servicio.IServicioSnacks;
import maquinaSnacksArchivos.servicio.ServicioSnacksArchivos;
import maquinaSnacksArchivos.servicio.ServicioSnacksLista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaSnacks {
    public static void main(String[] args) {
        maquinaSnacks();
    }

    public static void maquinaSnacks(){
        var salir = false;
        var consola = new Scanner(System.in);
        // creacion del objeto para obtener el servicio de snaks
        //IServicioSnacks servicioSnacks = new ServicioSnacksLista();
        IServicioSnacks servicioSnacks = new ServicioSnacksArchivos();
        // Creacion de la lista de porductos de tipo snakc
        List<Snack> productos = new ArrayList<>();

        System.out.println("*** Máquina de snacks ***");
        servicioSnacks.mostrarSnacks();

        while(!salir){
            try{
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(opcion, consola, productos, servicioSnacks);
            }catch (Exception e){
                System.out.println("Ocurrio un error: "+ e.getMessage());
            }
            finally {
                System.out.println(); // Salto por iteración
            }
        }
    }

    private static int mostrarMenu(Scanner consola){
        System.out.print("""
                Menu:                
                1. Comprar
                2. Ticket
                3. Nuevo
                4. Ver inventario
                5. salir                                
                """);
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpciones(int opcion, Scanner consola, List<Snack>productos, IServicioSnacks servicioSnacks){
        var salir = false;
        switch (opcion){
           case 1 -> comprarSnack(consola, productos, servicioSnacks);
           case 2 -> mostrarTicket(productos);
           case 3 -> agregarSnack(consola, servicioSnacks);
           case 4 -> listarInventarioSnaks(consola, servicioSnacks);
           case 5 -> {
               System.out.println("Regresa pronto..");
               salir = true;
           }
            default -> System.out.println("Opció invalida");
        }
        return salir;
    }

    private static void listarInventarioSnaks(Scanner consola, IServicioSnacks servicioSnacks){
        servicioSnacks.mostrarSnacks();
    }

    private static void comprarSnack(Scanner consola, List<Snack>productos, IServicioSnacks servicioSnacks){
        System.out.print("Que snack quieres comprar(id)?");
        var idSnack = Integer.parseInt(consola.nextLine());

        // Validar que el snack exista
        var snackEncontrado = false;
        for (var snack: servicioSnacks.getSnacks()){
            if (idSnack == snack.getIdSnak()){
                //Agregar el snack a la lista de porductos
                productos.add(snack);
                System.out.println("Snack agregado"+snack.toString());
                snackEncontrado = true;
                break;
            }
        }

        if (!snackEncontrado){
            System.out.println("Id de Snack no encontrado");
        }
    }

    private static void mostrarTicket(List<Snack>productos){
        var ticket = "*** Ticket ***";
        var total = 0.0;
        for (var producto: productos){
            ticket += "\n\t- " + producto.getNombre() + " - $"+ producto.getPrecio();
            total += producto.getPrecio();
        }

        ticket += "\n\tTotal: "+total;
        System.out.println(ticket);
    }

    private static void agregarSnack(Scanner consola, IServicioSnacks servicioSnacks){
        System.out.print("Nombre del snack: ");
        var nombre = consola.nextLine();
        System.out.print("Precio del snack: ");
        var precio = Double.parseDouble(consola.nextLine());
        servicioSnacks.agregarSnack(new Snack(nombre, precio));
        System.out.println("Tu snack se ha agregado");

        servicioSnacks.mostrarSnacks();
    }
}
