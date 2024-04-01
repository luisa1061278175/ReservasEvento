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
import java.util.ResourceBundle;

public class RegistroUsuarioViewController extends Application implements Initializable {

    @FXML
    private Button btnAceptar;

    @FXML
    private RadioButton rbAdmin;

    @FXML
    private RadioButton rbUsuario;

    @FXML
    private RadioButton rbEmpleado;

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

    private final String codigoAdmin = "0000";
    private final String codigoEmpleados = "1111";

    private ObservableList<Usuario> idEmpleado;
    private ObservableList<Usuario> idUsuario;
    private ObservableList<Usuario> idAdministrativo;

    @Override
    public void start(Stage stage) throws IOException {
        idAdministrativo = FXCollections.observableArrayList();
        idUsuario = FXCollections.observableArrayList();
        idEmpleado = FXCollections.observableArrayList();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RegistroUsuarios.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, 700, 550);
        scene.getStylesheets().add(getClass().getResource("estilos.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Registro de Usuarios");
        stage.show();
    }

    public boolean contraseñasCoinciden(String contraseña, String verificacionContraseña) {
        return contraseña.equals(verificacionContraseña);
    }

    //se crea el metodo porque se llama varias veces a iniciar sesión
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
        String id = txtId.getText();
        String contrasena1 = txtContraseña.getText();
        String contrasena2 = txtVerificacionContraseña.getText();
        String correo = txtCorreo.getText();

        if (!contraseñasCoinciden(contrasena2, contrasena1)) {
            txtContraseña.setText("");
            txtVerificacionContraseña.setText("");
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            return;
        }

        if (rbUsuario.isSelected()) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("InicioSesion.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage = new Stage();
            stage.setScene(scene);
            stage.show();

        } else if (rbAdmin.isSelected()) {
            String n = JOptionPane.showInputDialog("Ingresa el código: ");

            while (!n.equals(codigoAdmin)) {
                JOptionPane.showMessageDialog(null, "Código incorrecto");
                n = JOptionPane.showInputDialog("Ingresa el código: ");
            }
            iniciarSesion();

        } else if (rbEmpleado.isSelected()) {
            String n = JOptionPane.showInputDialog("Ingresa el código: ");

            while (!n.equals(codigoEmpleados)) {
                JOptionPane.showMessageDialog(null, "Código incorrecto");
                n = JOptionPane.showInputDialog("Ingresa el código: ");
            }
        iniciarSesion();

        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna opción.");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

}



