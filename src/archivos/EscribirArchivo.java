package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class EscribirArchivo {
    public static void main(String[] args) {
        boolean anexar = false;
        var nombreArchivo = "miArchivo.txt";

        var archivo = new File(nombreArchivo);

        try {
            //Revisar si el archivo esxiste
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            var nuevoContenido = "\nNuevo\ncontenido";
            salida.println(nuevoContenido);
            salida.close();
            System.out.println("Se agregó nuevo contenido");
        }catch (Exception e){
            System.out.println("Error al imprimir en el acrhivo");
            e.printStackTrace();
        }
    }
}
