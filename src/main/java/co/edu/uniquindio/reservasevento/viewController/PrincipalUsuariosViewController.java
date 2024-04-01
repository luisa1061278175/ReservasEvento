package co.edu.uniquindio.reservasevento.viewController;

import co.edu.uniquindio.reservasevento.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.application.Application.launch;

public class PrincipalUsuariosViewController implements Initializable {



    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PrincipalUsuario.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, 700, 550);
        stage = new Stage();
        stage.setScene(scene);
        URL url = getClass().getResource("\\src\\main\\resources\\co\\edu\\uniquindio\\reservasevento");


        stage.setTitle("Usuarios!");
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public static void main(String[] args) {

        launch();
    }
}
