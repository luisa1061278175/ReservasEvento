package co.edu.uniquindio.reservasevento.controller;

import co.edu.uniquindio.reservasevento.HelloApplication;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class InicioSesionController extends Application {

    @FXML
    private Button btnAceptar;

    @FXML
    private RadioButton rbAdmin;

    @FXML
    private RadioButton rbUsuario;

    @FXML
    private TextField txtContraseña;

    @FXML
    private TextField txtNombre;

    private String codigo = "0000";

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InicioSesion.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Inicio de Sesión");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void guardar() throws IOException {

        if (rbUsuario.isSelected()) {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TabuladoresUsuarios.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        } else if (rbAdmin.isSelected()) {
            String n = JOptionPane.showInputDialog("Ingresa el código: ");
            while (!n.equals(codigo)) {
                JOptionPane.showMessageDialog(null, "Código incorrecto");
                n = JOptionPane.showInputDialog("Ingresa el código: ");
            }
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TabuladoresUsuarios.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna opción.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
