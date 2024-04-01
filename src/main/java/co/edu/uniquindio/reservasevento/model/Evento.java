package co.edu.uniquindio.reservasevento.model;

import java.util.List;

public class Evento {


    private String nombre;
    private String descripción;
    private String fecha;
    private String ubicacion;
    private String hora;
    private String capacidadMaxima;
    private Empleado empleadoEncargado;
    private Reserva reservasEvento;

    public Evento(String nombre, String descripción, String fecha, String ubicacion, String hora, String capacidadMaxima, Empleado empleadoEncargado, Reserva reservasEvento) {
        this.nombre = nombre;
        this.descripción = descripción;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.hora = hora;
        this.capacidadMaxima = capacidadMaxima;
        this.empleadoEncargado = empleadoEncargado;
        this.reservasEvento = reservasEvento;
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(String capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
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