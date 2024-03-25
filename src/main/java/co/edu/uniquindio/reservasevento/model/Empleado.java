package co.edu.uniquindio.reservasevento.model;

import java.util.List;

public class Empleado extends Persona{

    private List<Evento> eventos;

    public Empleado(String nombre, int id, String correoElectronico, List<Evento> eventos) {
        super(nombre, id, correoElectronico);
        this.eventos = eventos;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
}
