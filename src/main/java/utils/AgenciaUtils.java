package utils;

import co.edu.uniquindio.reservasevento.model.Agencia;
import co.edu.uniquindio.reservasevento.model.Empleado;

public class AgenciaUtils {
    public static Agencia inicializarDatos() {

        Agencia agencia1 = new Agencia();


        Empleado e = new Empleado("luisa","3","lu@","e43",null);
        e.setNombre("juan");
        e.setCorreoElectronico("Lui");
        e.setEventosAsiganados("na");
        e.setId("44");

        e.getListaEmpleados().add(e);
        return agencia1;
    }

}
