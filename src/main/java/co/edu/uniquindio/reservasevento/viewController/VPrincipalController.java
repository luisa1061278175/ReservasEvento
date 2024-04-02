package co.edu.uniquindio.reservasevento.viewController;

import co.edu.uniquindio.reservasevento.HelloApplication;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VPrincipalController extends Application implements Initializable {

    @FXML
    private Button btnInicioSesion;

    @FXML
    private Button btnRegistrar;



    @Override


    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("VPrincipal.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        stage.setWidth(700);
        stage.setHeight(550);
        URL url = getClass().getResource("\\src\\main\\resources\\co\\edu\\uniquindio\\reservasevento");


        stage.setScene(scene);

        stage.setTitle("Evento!");

        stage.show();
    }

public void registrar() throws IOException {

    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RegistroUsuario.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    Stage stage= new Stage();
    stage.setScene(scene);
    stage.show();


}

    public void iniciarSesion() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("InicioSesion.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage= new Stage();
        stage.setScene(scene);
        stage.show();

    }

    private void cerrarVentanaActual(ActionEvent event) {
        // Obtiene el Stage (escenario) de la ventana actual
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Cierra la ventana actual
        stage.close();
    }

    public static void main(String[] args) {

        launch();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}


