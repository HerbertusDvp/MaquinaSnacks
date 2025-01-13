import java.util.ArrayList;
import java.util.List;

public class Snacks {
    private static final List<Snack> snacks;

    // Bloque inicializador

    static{
        snacks = new ArrayList<>();
        snacks.add(new Snack("Papitas", 20));
        snacks.add(new Snack("Refresco", 30));
        snacks.add(new Snack("Gelatina", 9));
    }

    public static void agregarSnack(Snack snack){
        snacks.add(snack);
    }

    public static void mostrarSnacks(){
        var inventarioSnacks = "";
        for (var snack: snacks){
            inventarioSnacks += snack.toString() + "\n";
        }
        System.out.println("--- Snacks en el inventario ---");
        System.out.println(inventarioSnacks);
    }

    public static List<Snack> getSnacks(){
        return snacks;
    }
}
