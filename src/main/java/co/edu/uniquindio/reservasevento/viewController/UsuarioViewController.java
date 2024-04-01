package co.edu.uniquindio.reservasevento.viewController;

import co.edu.uniquindio.reservasevento.HelloApplication;
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
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UsuarioViewController implements Initializable {

    @FXML
    private Button btnAgregarUsuario;

    @FXML
    private Button btnEliminarUsuario;

    @FXML
    private Button btnModificarUsuario;

    @FXML
    private Button btnRegresarUsuario;

    @FXML
    private TableColumn<?, ?> colCorreoUsuario;

    @FXML
    private TableColumn<?, ?> colIdentificacionUsuario;

    @FXML
    private TableColumn<?, ?> colNombreUsuario;

    @FXML
    private TableView<Usuario> tabla;

    @FXML
    private TextField txtCorreoUsuario;

    @FXML
    private TextField txtIdentificacionUsuario;

    @FXML
    private TextField txtNombreUsuario;


    private ObservableList<Usuario> ListaUsuarios;



    public void initialize(URL url, ResourceBundle resourceBundle) {

        ListaUsuarios = FXCollections.observableArrayList();

        this.colNombreUsuario.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colCorreoUsuario.setCellValueFactory(new PropertyValueFactory<>("correoElectronico"));
        this.colIdentificacionUsuario.setCellValueFactory(new PropertyValueFactory<>("id"));

    }

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Usuario.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        stage.setWidth(700);
        stage.setHeight(550);
        URL url = getClass().getResource("\\src\\main\\resources\\co\\edu\\uniquindio\\reservasevento");



        stage.setScene(scene);

        stage.setTitle("Evento!");

        stage.show();
    }
    @FXML

        private void agregar(ActionEvent event) {

        try {
            String nombre = txtNombreUsuario.getText();
            String correo = txtCorreoUsuario.getText();
            int id = Integer.parseInt(txtIdentificacionUsuario.getText());


            txtNombreUsuario.setText("");
            txtCorreoUsuario.setText("");
            txtIdentificacionUsuario.setText("");



            Usuario u = new Usuario(nombre,id, correo);

            this.ListaUsuarios.add(u);
            this.tabla.setItems(ListaUsuarios);
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

        Usuario p = this.tabla.getSelectionModel().getSelectedItem();

    }

    @FXML
    private void eliminar() {

        try {
            Usuario u = this.tabla.getSelectionModel().getSelectedItem();


            this.ListaUsuarios.remove(u);
            this.tabla.refresh();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar eliminar el producto.");
        }
    }

    @FXML
    private void modificar() {

        Usuario p = this.tabla.getSelectionModel().getSelectedItem();
        try {
            String nombre = txtNombreUsuario.getText();
            int id = Integer.parseInt(txtIdentificacionUsuario.getText());
            String correo=txtCorreoUsuario.getText();

           Usuario aux = new Usuario(nombre,id,correo);



            p.setId(aux.getId());
            p.setNombre(aux.getNombre());
            p.setCorreoElectronico(aux.getCorreoElectronico());

            this.tabla.refresh();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al convertir texto a número. Asegúrate de ingresar valores válidos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar modificar el producto.");
        }
    }
}

