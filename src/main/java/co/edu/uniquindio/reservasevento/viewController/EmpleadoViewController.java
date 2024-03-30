package co.edu.uniquindio.reservasevento.viewController;

import co.edu.uniquindio.reservasevento.HelloApplication;
import co.edu.uniquindio.reservasevento.controller.EmpleadoController;
import co.edu.uniquindio.reservasevento.model.Empleado;
import co.edu.uniquindio.reservasevento.model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.application.Application.launch;

public class EmpleadoViewController implements Initializable  {

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnModificar;

    @FXML
    private Button btnRegresar;


    @FXML
    private TableView<Empleado> tablaEmpleado;

    @FXML
    private TableColumn<?, ?> colCorreoEmpleado;

    @FXML
    private TableColumn<?, ?> colIdentificacionEmpleado;

    @FXML
    private TableColumn<?, ?> colNombreEmpleado;

    @FXML
    private TableColumn<?, ?> colRolEmpleado;

    @FXML
    private TextField txtCorreoEmpleados;

    @FXML
    private TextField txtIdentificacionEmpleados;

    @FXML
    private TextField txtNombreEmpleados;

    @FXML
    private TextField txtRolEmpleados;

    EmpleadoController empleadoControllerService;

    private ObservableList<Empleado> ListaEmpleados;


    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Empleado.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {

        ListaEmpleados = FXCollections.observableArrayList();

        this.colCorreoEmpleado.setCellValueFactory(new PropertyValueFactory<>("correo"));
        this.colIdentificacionEmpleado.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
        this.colNombreEmpleado.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colRolEmpleado.setCellValueFactory(new PropertyValueFactory<>("Rol del Empleado"));
    }

    @FXML

    private void agregar(ActionEvent event) {

        try {
            String nombre = txtNombreEmpleados.getText();
            String correo = txtCorreoEmpleados.getText();
            String rol = txtRolEmpleados.getText();
            int id = Integer.parseInt(txtIdentificacionEmpleados.getText());


            txtNombreEmpleados.setText("");
            txtCorreoEmpleados.setText("");
            txtRolEmpleados.setText("");
            txtIdentificacionEmpleados.setText("");



            Empleado e = new Empleado(nombre,id, correo,rol);

            this.ListaEmpleados.add(e);
            this.tablaEmpleado.setItems(ListaEmpleados);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error ");
        }
    }

    @FXML
    private void regresar(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Cierra la ventana
        stage.close();
    }


    @FXML
    private void seleccionar(MouseEvent event) {

        Empleado e = this.tablaEmpleado.getSelectionModel().getSelectedItem();

    }

    @FXML
    private void eliminar() {

        try {
            Empleado e = this.tablaEmpleado.getSelectionModel().getSelectedItem();


            this.ListaEmpleados.remove(e);
            this.tablaEmpleado.refresh();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar eliminar el producto.");
        }
    }

    @FXML
    private void modificar() {

        Empleado p = this.tablaEmpleado.getSelectionModel().getSelectedItem();
        try {
            String nombre = txtNombreEmpleados.getText();
            int codigo = Integer.parseInt(txtIdentificacionEmpleados.getText());
            String correo=txtCorreoEmpleados.getText();
            String rol=txtRolEmpleados.getText();

            Empleado aux = new Empleado(nombre,codigo,correo,rol);


            p.setId(codigo);
            p.setNombre(nombre);
            p.setCorreoElectronico(correo);

            this.tablaEmpleado.refresh();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al convertir texto a número. Asegúrate de ingresar valores válidos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar modificar el producto.");
        }
    }
}

