package co.edu.uniquindio.reservasevento.model;

import java.util.Date;
import java.util.List;

public class Reserva {

    private int id;
    private Usuario usuario;
    private Evento evento;
    private Date fechaSolicitud;
    private String estado;

    public Reserva(int id, Usuario usuario, Evento evento, Date fechaSolicitud, String estado) {
        this.id = id;
        this.usuario = usuario;
        this.evento = evento;
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
