package co.edu.uniquindio.reservasevento.viewController;

import co.edu.uniquindio.reservasevento.HelloApplication;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class InicioSesionController extends Application {

    @FXML
    private Button btnAceptar;
    @FXML
    private Button btnRegresar;

    @FXML
    private RadioButton rbAdmin;

    @FXML
    private RadioButton rbUsuario;

    @FXML
    private TextField txtContraseña;

    @FXML
    private TextField txtNombre;

    public ArrayList<String> NombresAdmin;
    public ArrayList<String> ContrasenasAdmin;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("InicioSesion.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setWidth(700);
        stage.setHeight(550);
        stage.setScene(scene);
        URL url = getClass().getResource("\\src\\main\\resources\\co\\edu\\uniquindio\\reservasevento");
        stage.setTitle("Inicio de sesión");
        stage.show();
    }

    public void tabUsuario() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PrincipalUsuarios.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void tabAdmin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PrincipalAdministrativos.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void tabEmpleados() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PrincipalEmpleados.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    // Método para inicializar los administradores y sus contraseñas
    public void registroAdmin() {
        // Se inicializan los ArrayLists
        this.NombresAdmin = new ArrayList<>();
        this.ContrasenasAdmin = new ArrayList<>();
        // Agrega los nombres de usuario de los administradores al ArrayList
        NombresAdmin.add("luisa");
        ContrasenasAdmin.add("luisa");
        NombresAdmin.add("dillan");
        ContrasenasAdmin.add("dillan");
    }

    public boolean esAdmin(String nombre, String contrasena) {
        // Se llama al método registroAdmin para asegurar que los ArrayLists estén inicializados
        registroAdmin();
        // Verifica si el nombre de usuario está en la lista de nombres de administradores
        int indice = NombresAdmin.indexOf(nombre);
        if (indice != -1) {
            // Si el nombre de usuario está en la lista, compara la contraseña correspondiente
            String contraseñaAlmacenada = ContrasenasAdmin.get(indice);
            if (contraseñaAlmacenada.equals(contrasena)) {
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Datos incorrectos");
        return false;
    }

    @FXML
    public void guardar() throws IOException {
        String contrasena = txtContraseña.getText();
        String nom = txtNombre.getText();
        txtContraseña.setText("");
        txtNombre.setText("");

        if (contrasena.equals("1")) {
            // Se inicia sesión como usuario

            JOptionPane.showMessageDialog(null, "Bienvenido Usuario");
            tabUsuario();
        } else if (contrasena.equals("0")) {
            // Se inicia sesión como empleado
            JOptionPane.showMessageDialog(null, "Bienvenido Empleado");
            tabEmpleados();
        } else if (esAdmin(nom, contrasena)) {
            // Se inicia sesión como administrador
            JOptionPane.showMessageDialog(null, "Bienvenido Administrador");
            tabAdmin();
        }
    }

    @FXML
    private void regresar(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Cierra la ventana
        stage.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

