package co.edu.uniquindio.reservasevento.controller;

import co.edu.uniquindio.reservasevento.model.Usuario;
import javafx.application.Application;
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
import javax.swing.JOptionPane;
import java.net.URL;
import java.util.ResourceBundle;

public class TabuladoresUsuarioController extends Application implements Initializable {


    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnModificar;

    @FXML
    private Button btnRegresar;

    @FXML
    private TableView<Usuario> tabla;

    @FXML
    private TableColumn<?, ?> colCorreo;

    @FXML
    private TableColumn<?, ?> colIdentificacion;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private TextField txtNombre;

    private ObservableList<Usuario> usuarios;



    public void initialize(URL url, ResourceBundle resourceBundle) {

        usuarios = FXCollections.observableArrayList();

        this.colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        this.colIdentificacion.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));



    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TabuladoresUsuarios.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Inicio de Sesión");
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    private void agregar(ActionEvent event) {

        try {
            String nombre = txtNombre.getText();
            int id = Integer.parseInt(txtIdentificacion.getText());
            String correo = txtCorreo.getText();


            txtNombre.setText("");
            txtIdentificacion.setText("");
            txtCorreo.setText("");


           Usuario user = new Usuario(nombre,id,correo);

            this.usuarios.add(user);
            this.tabla.setItems(usuarios);
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

       Usuario u = this.tabla.getSelectionModel().getSelectedItem();

    }

    @FXML
    private void eliminar() {

        try {
            Usuario p = this.tabla.getSelectionModel().getSelectedItem();


            this.usuarios.remove(p);
            this.tabla.refresh();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar eliminar el producto.");
        }
    }

    @FXML
    private void modificar() {

       Usuario p = this.tabla.getSelectionModel().getSelectedItem();
        try {
            String nombre = txtNombre.getText();
            int id = Integer.parseInt(txtIdentificacion.getText());
            String correo = txtCorreo.getText();

            Usuario user = new Usuario(nombre,id,correo);

            p.setNombre(user.getNombre());
            p.setCorreoElectronico(user.getCorreoElectronico());
            p.setId(user.getId());


            this.tabla.refresh();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al convertir texto a número. Asegúrate de ingresar valores válidos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar modificar el producto.");
        }
    }



    public static void main(String[] args) {
        launch(args);
    }
}
