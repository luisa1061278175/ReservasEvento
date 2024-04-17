package co.edu.uniquindio.reservasevento.controller.service;


import co.edu.uniquindio.reservasevento.mapping.dto.EmpleadoDto;

import java.util.List;

public interface IModelFactoryService {

    List<EmpleadoDto> obtenerEmpleados();

    /**
     * Agrega un nuevo empleado al sistema.
     *
     * @param empleadoDto Datos del empleado a agregar.
     * @return true si el empleado fue agregado exitosamente, false en caso contrario.
     */
    boolean agregarEmpleado(EmpleadoDto empleadoDto);

    /**
     * Elimina un empleado basado en su ID.
     *
     * @param id El ID del empleado a eliminar.
     * @return true si el empleado fue eliminado correctamente, false en caso contrario.
     */
    boolean eliminarEmpleado(String id);

    /**
     * Actualiza la información de un empleado existente.
     *
     * @param id El ID del empleado a actualizar.
     * @param empleadoDto Los nuevos datos del empleado.
     * @return true si el empleado fue actualizado exitosamente, false en caso contrario.
     */
    boolean actualizarEmpleado(String id, EmpleadoDto empleadoDto);
}

