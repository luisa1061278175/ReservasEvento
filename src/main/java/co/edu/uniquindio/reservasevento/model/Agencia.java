package co.edu.uniquindio.reservasevento.model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Agencia {
    private static final long serialVersionUID = 1L;
    ArrayList<Usuario> listaClientes = new ArrayList<>();
    ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    ArrayList<Evento> listaEventos = new ArrayList<>();
    ArrayList<Reserva> ListaReservas = new ArrayList<>();


    public ArrayList<Usuario> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Usuario> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public ArrayList<Evento> getListaEventos() {
        return listaEventos;
    }

    public void setListaEventos(ArrayList<Evento> listaEventos) {
        this.listaEventos = listaEventos;
    }

    public ArrayList<Reserva> getListaReservas() {
        return ListaReservas;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        ListaReservas = listaReservas;
    }

    private Map<String, Empleado> empleados; // Mapa de empleados por ID

        public Agencia() {
            this.empleados = new HashMap<>();
        }

        /**
         * Agrega un nuevo empleado a la agencia.
         *
         * @param empleado El empleado a agregar.
         * @return true si el empleado fue agregado exitosamente, false si ya existe.
         */
        public boolean agregarEmpleado(Empleado empleado) {
            if (empleados.containsKey(empleado.getId())) {
                return false; // El empleado ya existe
            }
            empleados.put(empleado.getId(), empleado);
            return true;
        }

        /**
         * Elimina un empleado de la agencia por su ID.
         *
         * @param id El ID del empleado a eliminar.
         * @return true si el empleado fue eliminado, false si no se encontró.
         */
        public boolean eliminarEmpleado(String id) {
            if (!empleados.containsKey(id)) {
                return false;
            }
            empleados.remove(id);
            return true;
        }

        /**
         * Actualiza la información de un empleado existente.
         *
         * @param id El ID del empleado a actualizar.
         * @param nuevoEmpleado La nueva información del empleado.
         * @return true si se actualizó correctamente, false si no se encontró el empleado.
         */
        public boolean actualizarEmpleado(String id, Empleado nuevoEmpleado) {
            if (!empleados.containsKey(id)) {
                return false;
            }
            empleados.put(id, nuevoEmpleado);
            return true;
        }

        /**
         * Obtiene una lista de todos los empleados en la agencia.
         *
         * @return Una lista de empleados.
         */
        public List<Empleado> getListaEmpleados() {
            return new ArrayList<>(empleados.values());
        }

        /**
         * Verifica si un empleado existe en la agencia por su ID.
         *
         * @param id El ID del empleado a verificar.
         * @return true si el empleado existe, false si no.
         */
        public boolean verificarEmpleadoExistente(String id) {
            return empleados.containsKey(id);
        }
    }