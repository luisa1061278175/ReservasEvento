package co.edu.uniquindio.reservasevento.viewController;

import co.edu.uniquindio.reservasevento.HelloApplication;
import co.edu.uniquindio.reservasevento.model.Usuario;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RegistroUsuarioViewController extends Application implements Initializable {

    @FXML
    private Button btnAceptar;


    @FXML
    private TextField txtContraseña;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtVerificacionContraseña;


    // Lista para almacenar los usuarios registrados
    private ArrayList<Usuario> usuarios = new ArrayList<>();




    @Override
    public void start(Stage stage) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RegistroUsuarios.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, 700, 550);
        scene.getStylesheets().add(getClass().getResource("estilos.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Registro de Usuarios");
        stage.show();
    }

    public void iniciarSesion() throws IOException {

       Stage stage;

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("InicioSesion.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 700, 550);
        stage = new Stage();
        URL url = getClass().getResource("\\src\\main\\resources\\co\\edu\\uniquindio\\reservasevento");

        stage.setScene(scene);
        stage.setTitle("Evento!");
        stage.show();
    }

    @FXML
    public void registrarUsuario(ActionEvent event) throws IOException {
        Stage stage;

        String nombre = txtNombre.getText();
        int id = Integer.parseInt(txtId.getText());
        String contrasena1 = txtContraseña.getText();
        String contrasena2 = txtVerificacionContraseña.getText();
        String correo = txtCorreo.getText();

        //Guardar datos
        Usuario usuario = new Usuario(nombre, id, correo);
        // Agregar el usuario a la lista de usuarios
        usuarios.add(usuario);

        iniciarSesion();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

}



