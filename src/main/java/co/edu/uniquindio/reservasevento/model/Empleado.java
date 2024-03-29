package co.edu.uniquindio.reservasevento.model;

import java.util.List;

public class Empleado extends Persona{

    private String eventosAsiganados;

    public Empleado(String nombre, int id, String correoElectronico, String eventosAsiganados) {
        super(nombre, id, correoElectronico);
        this.eventosAsiganados = eventosAsiganados;
    }


    public String getEventosAsiganados() {
        return eventosAsiganados;
    }

    public void setEventosAsiganados(String eventosAsiganados) {
        this.eventosAsiganados = eventosAsiganados;
    }
}

