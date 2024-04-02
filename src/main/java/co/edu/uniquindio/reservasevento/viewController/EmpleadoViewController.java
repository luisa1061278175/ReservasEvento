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
import javafx.scene.Parent;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

import static javafx.application.Application.launch;

public class EmpleadoViewController implements Initializable {

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnModificar;

    @FXML
    private Button btnRegresar;


    @FXML
    private TableView<Empleado> tabla;

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
    //para la tabla
    private ObservableList<Empleado> ListaEmpleados;



    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Empleado.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 700, 550);
        stage = new Stage();
        URL url = getClass().getResource("\\src\\main\\resources\\co\\edu\\uniquindio\\reservasevento");


        stage.setScene(scene);
        stage.setTitle("Evento!");
        stage.show();
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {

        ListaEmpleados = FXCollections.observableArrayList();

        this.colCorreoEmpleado.setCellValueFactory(new PropertyValueFactory<>("CorreoElectronico"));
        this.colIdentificacionEmpleado.setCellValueFactory(new PropertyValueFactory<>("Id"));
        this.colNombreEmpleado.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        this.colRolEmpleado.setCellValueFactory(new PropertyValueFactory<>("eventosAsiganados"));
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


            Empleado e = new Empleado(nombre, id, correo, rol);

            this.ListaEmpleados.add(e);
            this.tabla.setItems(ListaEmpleados);
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

        Empleado e = this.tabla.getSelectionModel().getSelectedItem();

    }

    @FXML
    private void eliminar() {

        try {
            Empleado e = this.tabla.getSelectionModel().getSelectedItem();


            this.ListaEmpleados.remove(e);
            this.tabla.refresh();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar eliminar el producto.");
        }
    }

    @FXML
    private void modificar() {

        Empleado p = this.tabla.getSelectionModel().getSelectedItem();
        try {
            String nombre = txtNombreEmpleados.getText();
            int codigo = Integer.parseInt(txtIdentificacionEmpleados.getText());
            String correo = txtCorreoEmpleados.getText();
            String rol = txtRolEmpleados.getText();

            Empleado aux = new Empleado(nombre, codigo, correo, rol);

            txtNombreEmpleados.setText("");
            txtCorreoEmpleados.setText("");
            txtRolEmpleados.setText("");
            txtIdentificacionEmpleados.setText("");

            p.setId(codigo);
            p.setNombre(nombre);
            p.setCorreoElectronico(correo);
            p.setEventosAsiganados(rol);

            this.tabla.refresh();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al convertir texto a número. Asegúrate de ingresar valores válidos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar modificar el producto.");
        }
    }
}

