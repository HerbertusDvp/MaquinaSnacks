package maquinaSnacksArchivos.dominio;

import java.io.Serializable;
import java.util.Objects;

public class Snack implements Serializable {
    private static int contadorSnaks = 0;
    private int idSnak;
    private String nombre;
    private double precio;

    public Snack(){
        this.idSnak = ++Snack.contadorSnaks;
    }

    public Snack(String nombre, double precio){
        this();
        this.nombre = nombre;
        this.precio = precio;
    }

    public static int getContadorSnaks() {
        return contadorSnaks;
    }

    public int getIdSnak() {
        return idSnak;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "idSnak=" + idSnak +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    public String escribirSnack(){
        return idSnak+","+nombre+","+precio;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Snack snack = (Snack) o;
        return idSnak == snack.idSnak && Double.compare(precio, snack.precio) == 0 && Objects.equals(nombre, snack.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSnak, nombre, precio);
    }
}
