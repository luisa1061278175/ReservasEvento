package co.edu.uniquindio.reservasevento.viewController;

import co.edu.uniquindio.reservasevento.controller.EmpleadoController;
import co.edu.uniquindio.reservasevento.model.Empleado;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EmpleadoViewController {


    EmpleadoController empleadoControllerService;

    //ObservableList<EmpleadoDto> listaEmpleadosDto= fxCollection......


    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnModificar;

    @FXML
    private Button btnRegresar;

    @FXML
    private TextField txtCorreoEmpleados;

    @FXML
    private TextField txtIdentificacionEmpleados;

    @FXML
    private TextField txtNombreEmpleados;

    @FXML
    private TextField txtRolEmpleados;
}
