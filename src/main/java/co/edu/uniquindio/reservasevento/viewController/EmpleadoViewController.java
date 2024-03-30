package co.edu.uniquindio.reservasevento.viewController;

import co.edu.uniquindio.reservasevento.HelloApplication;
import co.edu.uniquindio.reservasevento.controller.EmpleadoController;
import co.edu.uniquindio.reservasevento.model.Empleado;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.application.Application.launch;

public class EmpleadoViewController implements Initializable  {


    EmpleadoController empleadoControllerService;



    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Empleado.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void eliminar(){


    }

    @FXML
    public void agregar(){


    }
    @FXML
    public void modificar(){


    }
    @FXML
    public void regresar(){


    }



    public static void main(String[] args) {

        launch();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
