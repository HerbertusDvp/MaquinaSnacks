package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class crearArchivo {
    public static void main(String[] args) {
        var nombreArchivo = "miArchivo.txt";

        var archivo = new File(nombreArchivo);
        try {
            if (archivo.exists()){
                System.out.println("El archivo ya existe");
            }else{
                //Creacion del archivo
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
            }
        }catch (IOException e){
            System.out.println("Error al crear archivo: "+e.getMessage());
            e.printStackTrace();
        }
    }
}
