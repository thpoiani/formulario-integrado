/**
 * Sample Skeleton for "principal.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package formulario.integrado.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class PrincipalController extends Controller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="categoria"
    private Button categoria; // Value injected by FXMLLoader

    @FXML // fx:id="categorias"
    private Button categorias; // Value injected by FXMLLoader

    @FXML // fx:id="formulario"
    private Button formulario; // Value injected by FXMLLoader

    @FXML // fx:id="formularios"
    private Button formularios; // Value injected by FXMLLoader

    @FXML // fx:id="respostas"
    private Button respostas; // Value injected by FXMLLoader


    // Handler for Button[fx:id="categoria"] onAction
    @FXML
    void categoriaAction(ActionEvent event) {
        // handle the event here
        super.start("categoria.fxml", "Categoria");
    }

    // Handler for Button[fx:id="categorias"] onAction
    @FXML
    void categoriasAction(ActionEvent event) {
        // handle the event here
        super.start("categorias.fxml", "Categorias");
    }

    // Handler for Button[fx:id="formulario"] onAction
    @FXML
    void formularioAction(ActionEvent event) {
        // handle the event here
        super.start("formulario.fxml", "Formulário");
    }

    // Handler for Button[fx:id="formularios"] onAction
    @FXML
    void formulariosAction(ActionEvent event) {
        // handle the event here
        super.start("formularios.fxml", "Formulários");
    }

    // Handler for Button[fx:id="respostas"] onAction
    @FXML
    void respostasAction(ActionEvent event) {
        // handle the event here
        super.start("pesquisas.fxml", "Respostas");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert categoria != null : "fx:id=\"categoria\" was not injected: check your FXML file 'principal.fxml'.";
        assert categorias != null : "fx:id=\"categorias\" was not injected: check your FXML file 'principal.fxml'.";
        assert formulario != null : "fx:id=\"formulario\" was not injected: check your FXML file 'principal.fxml'.";
        assert formularios != null : "fx:id=\"formularios\" was not injected: check your FXML file 'principal.fxml'.";
        assert respostas != null : "fx:id=\"respostas\" was not injected: check your FXML file 'principal.fxml'.";

        // Initialize your logic here: all @FXML variables will have been injected

    }

}
