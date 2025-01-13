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
        // Creacion de la lista de porductos de tipo snakc
        List<Snack> productos = new ArrayList<>();

        System.out.println("*** Máquina de snacks ***");
        Snacks.mostrarSnacks();

        while(!salir){
            try{
                var opcion = mostrarMenu(consola);
                //salir = ejecutarOpciones
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
                4. salir                                
                """);
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpciones(int opcion, Scanner consola, List<Snack>productos){
        var salir = false;
        switch (opcion){
           // case 1 -> comprarStack(consola, productos);
        }
        return salir;
    }

}
