package co.edu.uniquindio.reservasevento.viewController;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ReservaViewController extends Application implements Initializable {



    @FXML
    private Button btnAgregarEventos;

    @FXML
    private Button btnEliminarEventos;

    @FXML
    private Button btnModificarEventos;

    @FXML
    private Button btnRegresarEventos;

    @FXML
    private TableColumn<?, ?> colCantidadMaximaEventos;

    @FXML
    private TableColumn<?, ?> colDescripcionEventos;

    @FXML
    private TableColumn<?, ?> colEstado;

    @FXML
    private TableColumn<?, ?> colFechaEventos;

    @FXML
    private TableColumn<?, ?> colHoraEventos;

    @FXML
    private TableColumn<?, ?> colUbicacionEventos;

    @FXML
    private TableView<?> tabla11;

    @FXML
    private TextField txtCantidadMaximaEventos;

    @FXML
    private TextField txtFechaEventos;

    @FXML
    private TextField txtHoraEventos;

    @FXML
    private TextField txtIdentificacionEventos;

    @FXML
    private TextField txtNombreEventos;

    @FXML
    private TextField txtUbicacionEventos;


    @Override
    public void start(Stage stage) throws Exception {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
}
