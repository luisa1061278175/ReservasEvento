package co.edu.uniquindio.reservasevento.model;

public class Persona {

    private String Nombre;
    private int Id;
    private String CorreoElectronico;

    public Persona(String nombre, int id, String correoElectronico) {
        Nombre = nombre;
        Id = id;
        CorreoElectronico = correoElectronico;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        CorreoElectronico = correoElectronico;
    }
}
