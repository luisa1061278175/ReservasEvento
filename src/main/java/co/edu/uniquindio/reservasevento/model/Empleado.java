package co.edu.uniquindio.reservasevento.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Empleado extends Persona implements Serializable {

    private String eventosAsiganados;

    ArrayList<Empleado>listaEmpleados= new ArrayList<>();

    public Empleado(String nombre, String id, String correoElectronico, String eventosAsiganados, String listaEmpleados) {
        super(nombre, id, correoElectronico);
        this.eventosAsiganados = eventosAsiganados;
        this.listaEmpleados = listaEmpleados;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public String getEventosAsiganados() {
        return eventosAsiganados;
    }

    public void setEventosAsiganados(String eventosAsiganados) {
        this.eventosAsiganados = eventosAsiganados;
    }
}

