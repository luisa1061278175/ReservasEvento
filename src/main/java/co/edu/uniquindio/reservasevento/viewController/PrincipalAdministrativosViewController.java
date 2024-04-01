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

public class PrincipalAdministrativosViewController implements Initializable {



    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PrincipalAdministrativos.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 700, 550);
        stage = new Stage();
        URL url = getClass().getResource("\\src\\main\\resources\\co\\edu\\uniquindio\\reservasevento");


        stage.setScene(scene);
        stage.setTitle("Administrativos!");
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
