package co.edu.uniquindio.reservasevento.model;

import java.util.List;

public class Usuario extends Persona{

    private List<Reserva> reservasUsuario;

    public List<Reserva> getReservasUsuario() {
        return reservasUsuario;
    }

    public void setReservasUsuario(List<Reserva> reservasUsuario) {
        this.reservasUsuario = reservasUsuario;
    }

    public Usuario(String nombre, int id, String correoElectronico, List<Reserva> reservasUsuario) {
        super(nombre, id, correoElectronico);
        this.reservasUsuario = reservasUsuario;


    }
}
