/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario.integrado.controller;

/**
 * Sample Skeleton for "categorias-listar.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class CategoriasListarController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="cancelar"
    private Button cancelar; // Value injected by FXMLLoader

    @FXML // fx:id="descricao"
    private TableColumn<?, ?> descricao; // Value injected by FXMLLoader

    @FXML // fx:id="id"
    private TableColumn<?, ?> id; // Value injected by FXMLLoader

    @FXML // fx:id="salvar"
    private Button salvar; // Value injected by FXMLLoader

    @FXML // fx:id="tabela"
    private TableView<?> tabela; // Value injected by FXMLLoader

    @FXML // fx:id="titulo"
    private TableColumn<?, ?> titulo; // Value injected by FXMLLoader


    // Handler for Button[fx:id="cancelar"] onAction
    @FXML
    void cancelarAction(ActionEvent event) {
        // handle the event here
    }

    // Handler for Button[fx:id="salvar"] onAction
    @FXML
    void salvarAction(ActionEvent event) {
        // handle the event here
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert cancelar != null : "fx:id=\"cancelar\" was not injected: check your FXML file 'categorias-listar.fxml'.";
        assert descricao != null : "fx:id=\"descricao\" was not injected: check your FXML file 'categorias-listar.fxml'.";
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'categorias-listar.fxml'.";
        assert salvar != null : "fx:id=\"salvar\" was not injected: check your FXML file 'categorias-listar.fxml'.";
        assert tabela != null : "fx:id=\"tabela\" was not injected: check your FXML file 'categorias-listar.fxml'.";
        assert titulo != null : "fx:id=\"titulo\" was not injected: check your FXML file 'categorias-listar.fxml'.";

        // Initialize your logic here: all @FXML variables will have been injected

    }

}
