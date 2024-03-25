package co.edu.uniquindio.reservasevento.model;

import java.util.Date;
import java.util.List;

public class Reserva {

    private int id;
    private Usuario usuario;
    private Evento evento;
    private Date fechaSolicitud;
    private String estado;
}
