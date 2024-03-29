package co.edu.uniquindio.reservasevento.viewController;

import co.edu.uniquindio.reservasevento.model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class UsuarioViewController {

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
}
