package co.edu.uniquindio.reservasevento.model;

import java.util.List;

public class Evento {


    private int id;
    private String nombre;
    private String descripción;
    private String fecha;
    private String capacidadMáxima;
    private Empleado empleadoEncargado;
    private Reserva reservasEvento;

    public Evento(int id, String nombre, String descripción, String fecha, String capacidadMáxima, Empleado empleadoEncargado, Reserva reservasEvento) {
        this.id = id;
        this.nombre = nombre;
        this.descripción = descripción;
        this.fecha = fecha;
        this.capacidadMáxima = capacidadMáxima;
        this.empleadoEncargado = empleadoEncargado;
        this.reservasEvento = reservasEvento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCapacidadMáxima() {
        return capacidadMáxima;
    }

    public void setCapacidadMáxima(String capacidadMáxima) {
        this.capacidadMáxima = capacidadMáxima;
    }

    public Empleado getEmpleadoEncargado() {
        return empleadoEncargado;
    }

    public void setEmpleadoEncargado(Empleado empleadoEncargado) {
        this.empleadoEncargado = empleadoEncargado;
    }

    public Reserva getReservasEvento() {
        return reservasEvento;
    }

    public void setReservasEvento(Reserva reservasEvento) {
        this.reservasEvento = reservasEvento;
    }
}