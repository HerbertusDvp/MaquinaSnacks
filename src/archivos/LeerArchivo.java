package archivos;

import java.io.*;

public class LeerArchivo {
    public static void main(String[] args) {
        var nombreArchivo = "miArchivo.txt";
        var archivo = new File(nombreArchivo);

        try{
            System.out.println("Contenido del archivo");
            // Arbrir archivo apra su lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            var linea = entrada.readLine(); // LEe la primera linea

            while (linea != null){
                System.out.println(linea);
                linea = entrada.readLine();
            }
            entrada.close();
        }catch (Exception e){
            System.out.println("Sea ha producido un error"+e.getMessage());
        }
    }
}
