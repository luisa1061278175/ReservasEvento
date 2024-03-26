package co.edu.uniquindio.reservasevento.controller;

import co.edu.uniquindio.reservasevento.HelloApplication;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;

public class VPrincipalController extends Application {

    @FXML
    private Button btnGuardar;

    @FXML
    private RadioButton rbAdmin;

    @FXML
    private RadioButton rbUsuario;



    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("VPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

public void guardar() throws IOException {

    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("InicioSesion.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    Stage stage= new Stage();
    stage.setScene(scene);
    stage.show();



}

    public static void main(String[] args) {

        launch();
    }
}


