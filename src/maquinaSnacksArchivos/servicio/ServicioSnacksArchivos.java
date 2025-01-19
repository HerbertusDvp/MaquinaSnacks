package maquinaSnacksArchivos.servicio;

import maquinaSnacks.Snacks;
import maquinaSnacksArchivos.dominio.Snack;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ServicioSnacksArchivos implements IServicioSnacks{

    private final String NOMBRE_ARCHIVO = "snacks.txt";
    private List<Snack> snacks = new ArrayList<>();

    public ServicioSnacksArchivos(){
        //CRear el archivo si no existe

        var archivo = new File(NOMBRE_ARCHIVO);
        var existe = false;

        try {
            existe = archivo.exists();
            if (existe){
               this.snacks = obtenerSnacks();
            }else {
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se ha creado el archivo");
            }
        }catch (Exception e){
            System.out.println("Error al crear el archivo.."+ e.getMessage());
        }

        // Si no existe, cargamos algunos snacks inciales
        if (!existe){
            cargarSnacksIniciales();
        }
    }

    private void cargarSnacksIniciales(){
        this.agregarSnack(new Snack("Papas", 70));
        this.agregarSnack(new Snack("Refresco", 30));
        this.agregarSnack(new Snack("Chocoleit", 37));
    }

    private List<Snack>  obtenerSnacks(){
        var snacks = new ArrayList<Snack>();

        try {
            List<String> lista = Files.readAllLines(Paths.get(NOMBRE_ARCHIVO));

            for (String linea: lista){
                String lineaSnack [] = linea.split(",");
                var idSnack = lineaSnack[0];
                var nombre = lineaSnack[1];
                var precio = Double.parseDouble(lineaSnack[2]);

                var snack = new Snack(nombre, precio);

                snacks.add(snack);
            }
        }catch (Exception e){
            System.out.println("Error al leer el archivo de snacks.." + e.getMessage());

        }

        return snacks;
    }
    @Override
    public void agregarSnack(Snack snack) {
        // Agregarmos snakc a la lista
        this.snacks.add(snack);
        this.agregarSnackArchivo(snack);
    }

    private void agregarSnackArchivo(Snack snack){
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(snack.escribirSnack());
            salida.close();

        }catch (Exception e){
            System.out.println("Error al agregar el snack: " + e.getMessage());

        }

    }

    @Override
    public void mostrarSnacks() {
        System.out.println("--- snacks en el invetario ---");

        var inventarioSnacks = "";

        for (var snack: this.snacks){
            inventarioSnacks += snack.toString() + "\n";
        }

        System.out.println(inventarioSnacks);
    }

    @Override
    public List<Snack> getSnacks() {
        return this.snacks;
    }
}
