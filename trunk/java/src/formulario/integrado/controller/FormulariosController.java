/**
 * Sample Skeleton for "formularios.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package formulario.integrado.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class FormulariosController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="aberto"
    private TableColumn<?, ?> aberto; // Value injected by FXMLLoader

    @FXML // fx:id="cancelar"
    private Button cancelar; // Value injected by FXMLLoader

    @FXML // fx:id="editar"
    private Button editar; // Value injected by FXMLLoader

    @FXML // fx:id="id"
    private TableColumn<?, ?> id; // Value injected by FXMLLoader

    @FXML // fx:id="pesquisar"
    private Button pesquisar; // Value injected by FXMLLoader

    @FXML // fx:id="pesquisarField"
    private TextField pesquisarField; // Value injected by FXMLLoader

    @FXML // fx:id="remover"
    private Button remover; // Value injected by FXMLLoader

    @FXML // fx:id="tabela"
    private TableView<?> tabela; // Value injected by FXMLLoader

    @FXML // fx:id="titulo"
    private TableColumn<?, ?> titulo; // Value injected by FXMLLoader

    @FXML // fx:id="visualizar"
    private Button visualizar; // Value injected by FXMLLoader


    // Handler for Button[fx:id="cancelar"] onAction
    @FXML
    void cancelarAction(ActionEvent event) {
        // handle the event here
    }

    // Handler for Button[fx:id="editar"] onAction
    // Handler for Button[fx:id="remover"] onAction
    @FXML
    void editarAction(ActionEvent event) {
        // handle the event here
    }

    // Handler for Button[fx:id="pesquisar"] onAction
    @FXML
    void pesquisarAction(ActionEvent event) {
        // handle the event here
    }

    // Handler for Button[fx:id="visualizar"] onAction
    @FXML
    void visualizarAction(ActionEvent event) {
        // handle the event here
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert aberto != null : "fx:id=\"aberto\" was not injected: check your FXML file 'formularios.fxml'.";
        assert cancelar != null : "fx:id=\"cancelar\" was not injected: check your FXML file 'formularios.fxml'.";
        assert editar != null : "fx:id=\"editar\" was not injected: check your FXML file 'formularios.fxml'.";
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'formularios.fxml'.";
        assert pesquisar != null : "fx:id=\"pesquisar\" was not injected: check your FXML file 'formularios.fxml'.";
        assert pesquisarField != null : "fx:id=\"pesquisarField\" was not injected: check your FXML file 'formularios.fxml'.";
        assert remover != null : "fx:id=\"remover\" was not injected: check your FXML file 'formularios.fxml'.";
        assert tabela != null : "fx:id=\"tabela\" was not injected: check your FXML file 'formularios.fxml'.";
        assert titulo != null : "fx:id=\"titulo\" was not injected: check your FXML file 'formularios.fxml'.";
        assert visualizar != null : "fx:id=\"visualizar\" was not injected: check your FXML file 'formularios.fxml'.";

        // Initialize your logic here: all @FXML variables will have been injected

    }

}
