package maquinaSnacksArchivos.servicio;

import maquinaSnacksArchivos.dominio.Snack;

import java.util.List;

public interface IServicioSnacks {
    void agregarSnack(Snack snack);
    void mostrarSnacks();
    List <Snack> getSnacks();
}
