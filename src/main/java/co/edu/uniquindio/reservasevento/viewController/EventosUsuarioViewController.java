package co.edu.uniquindio.reservasevento.viewController;

import co.edu.uniquindio.reservasevento.HelloApplication;
import co.edu.uniquindio.reservasevento.model.Evento;
import co.edu.uniquindio.reservasevento.model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.application.Application.launch;

public class EventosUsuarioViewController implements Initializable {

    @FXML
    private Button btnRegresarEventos;

    @FXML
    private Button btnSeleccionar;

    @FXML
    private TableColumn<?, ?> colCantidadMaximaEventos;

    @FXML
    private TableColumn<?, ?> colDescripcionEventos;

    @FXML
    private TableColumn<?, ?> colFechaEventos;

    @FXML
    private TableColumn<?, ?> colHoraEventos;

    @FXML
    private TableColumn<?, ?> colNombreEventos;

    @FXML
    private TableColumn<?, ?> colUbicacionEventos;

    @FXML
    private TableView<Evento> tabla;



    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Evento.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        stage.setWidth(700);
        stage.setHeight(550);

        stage.setScene(scene);
        URL url = getClass().getResource("\\src\\main\\resources\\co\\edu\\uniquindio\\reservasevento");



        stage.setTitle("Evento!");

        stage.show();
    }





    public void initialize(URL url, ResourceBundle resourceBundle) {


        this.colDescripcionEventos.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        this.colNombreEventos.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colFechaEventos.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        this.colUbicacionEventos.setCellValueFactory(new PropertyValueFactory<>("ubicacion"));
        this.colHoraEventos.setCellValueFactory(new PropertyValueFactory<>("hora"));
        this.colCantidadMaximaEventos.setCellValueFactory(new PropertyValueFactory<>("capacidadMaxima"));


    }

    @FXML

    private void seleccionar(ActionEvent event) {

    }

    @FXML
    private void regresar(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Cierra la ventana
        stage.close();
    }



}

