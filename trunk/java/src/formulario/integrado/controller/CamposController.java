/**
 * Sample Skeleton for "campos.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package formulario.integrado.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;


public class CamposController extends AbstractController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="cancelar"
    private Button cancelar; // Value injected by FXMLLoader

    @FXML // fx:id="editar"
    private Button editar; // Value injected by FXMLLoader

    @FXML // fx:id="id"
    private TableColumn<?, ?> id; // Value injected by FXMLLoader

    @FXML // fx:id="remover"
    private Button remover; // Value injected by FXMLLoader

    @FXML // fx:id="tipo"
    private TableColumn<?, ?> tipo; // Value injected by FXMLLoader

    @FXML // fx:id="titulo"
    private TableColumn<?, ?> titulo; // Value injected by FXMLLoader


    // Handler for Button[fx:id="cancelar"] onAction
    @FXML
    void cancelarAction(ActionEvent event) {
        // handle the event here
    }

    // Handler for Button[fx:id="editar"] onAction
    @FXML
    void editarAction(ActionEvent event) {
        // handle the event here
        super.start("campo.fxml", "Campo");
    }

    // Handler for Button[id="loginButton"] onAction
    @FXML
    void pesquisarAction(ActionEvent event) {
        // handle the event here
    }

    // Handler for Button[fx:id="remover"] onAction
    @FXML
    void removerAction(ActionEvent event) {
        // handle the event here
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert cancelar != null : "fx:id=\"cancelar\" was not injected: check your FXML file 'campos.fxml'.";
        assert editar != null : "fx:id=\"editar\" was not injected: check your FXML file 'campos.fxml'.";
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'campos.fxml'.";
        assert remover != null : "fx:id=\"remover\" was not injected: check your FXML file 'campos.fxml'.";
        assert tipo != null : "fx:id=\"tipo\" was not injected: check your FXML file 'campos.fxml'.";
        assert titulo != null : "fx:id=\"titulo\" was not injected: check your FXML file 'campos.fxml'.";

        // Initialize your logic here: all @FXML variables will have been injected

    }

}
