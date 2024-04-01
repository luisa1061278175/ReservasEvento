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

public class EventoViewController implements Initializable {

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
    private TableColumn<?, ?> colFechaEventos;

    @FXML
    private TableColumn<?, ?> colHoraEventos;

    @FXML
    private TableColumn<?, ?> colNombreEventos;

    @FXML
    private TableColumn<?, ?> colUbicacionEventos;

    @FXML
    private TableView<Evento> tabla;

    @FXML
    private TextField txtCantidadMaximaEventos;

    @FXML
    private TextField txtFechaEventos;

    @FXML
    private TextField txtHoraEventos;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtNombreEventos;

    @FXML
    private TextField txtUbicacionEventos;

    private ObservableList<Evento>listaEventos;


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

        listaEventos = FXCollections.observableArrayList();

        this.colDescripcionEventos.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        this.colNombreEventos.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colFechaEventos.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        this.colUbicacionEventos.setCellValueFactory(new PropertyValueFactory<>("ubicacion"));
        this.colHoraEventos.setCellValueFactory(new PropertyValueFactory<>("hora"));
        this.colCantidadMaximaEventos.setCellValueFactory(new PropertyValueFactory<>("capacidadMaxima"));


    }

    @FXML

    private void agregar(ActionEvent event) {

        try {
            String nom = txtNombreEventos.getText();
            String descripcion = txtDescripcion.getText();
            String fecha = txtFechaEventos.getText();
            String cantMaxima = txtCantidadMaximaEventos.getText();
            String hora = txtHoraEventos.getText();
            String ubicacion = txtUbicacionEventos.getText();



            txtNombreEventos.setText("");
            txtDescripcion.setText("");
            txtCantidadMaximaEventos.setText("");
            txtFechaEventos.setText("");
            txtUbicacionEventos.setText("");
            txtHoraEventos.setText("");



           Evento e = new Evento(nom,descripcion,fecha,cantMaxima,hora,cantMaxima,null,null);

            this.listaEventos.add(e);
            this.tabla.setItems(listaEventos);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error ");
        }
    }

    @FXML
    private void regresar(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Cierra la ventana
        stage.close();
    }


    @FXML
    private void seleccionar(MouseEvent event) {

        Evento p = this.tabla.getSelectionModel().getSelectedItem();

    }

    @FXML
    private void eliminar() {

        try {
            Evento u = this.tabla.getSelectionModel().getSelectedItem();


            this.listaEventos.remove(u);
            this.tabla.refresh();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar eliminar el producto.");
        }
    }

    @FXML
    private void modificar() {

        Evento p = this.tabla.getSelectionModel().getSelectedItem();
        try {
            String nombre = txtNombreEventos.getText();
            String fecha=txtFechaEventos.getText();
            String descripcion = txtDescripcion.getText();
            String hora=txtHoraEventos.getText();
            String cantMaxima=txtCantidadMaximaEventos.getText();
            String ubicacion=txtUbicacionEventos.getText();

            Evento aux = new Evento(nombre,descripcion,fecha,ubicacion,hora,cantMaxima,null,null);



            p.setHora(aux.getHora());
            p.setCapacidadMaxima(aux.getCapacidadMaxima());
            p.setUbicacion(aux.getUbicacion());
            p.setDescripción(aux.getDescripción());
            p.setFecha(aux.getFecha());
            p.setNombre(aux.getNombre());

            this.tabla.refresh();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al convertir texto a número. Asegúrate de ingresar valores válidos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar modificar el producto.");
        }
    }
}
