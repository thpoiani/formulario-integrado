/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario.integrado.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;


public class FormularioController extends AbstractController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="ativo"
    private ToggleGroup ativo; // Value injected by FXMLLoader

    @FXML // fx:id="cancelar"
    private Button cancelar; // Value injected by FXMLLoader

    @FXML // fx:id="categorias"
    private ListView<?> categorias; // Value injected by FXMLLoader

    @FXML // fx:id="desce"
    private Button desce; // Value injected by FXMLLoader

    @FXML // fx:id="inserir"
    private Button inserir; // Value injected by FXMLLoader

    @FXML // fx:id="retirar"
    private Button retirar; // Value injected by FXMLLoader

    @FXML // fx:id="salvar"
    private Button salvar; // Value injected by FXMLLoader

    @FXML // fx:id="sobe"
    private Button sobe; // Value injected by FXMLLoader

    @FXML // fx:id="titulo"
    private TextField titulo; // Value injected by FXMLLoader


    // Handler for Button[fx:id="cancelar"] onAction
    @FXML
    void cancelarAction(ActionEvent event) {
        // handle the event here
    }

    // Handler for Button[fx:id="desce"] onAction
    @FXML
    void desceAction(ActionEvent event) {
        // handle the event here
    }

    // Handler for Button[fx:id="inserir"] onAction
    @FXML
    void inserirAction(ActionEvent event) {
        super.start("categoria.fxml", "Categoria");
        // handle the event here
    }

    // Handler for Button[fx:id="retirar"] onAction
    @FXML
    void retirarAction(ActionEvent event) {
        // handle the event here
    }

    // Handler for Button[fx:id="salvar"] onAction
    @FXML
    void salvarAction(ActionEvent event) {
        // handle the event here
    }

    // Handler for Button[fx:id="sobe"] onAction
    @FXML
    void sobeAction(ActionEvent event) {
        // handle the event here
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert ativo != null : "fx:id=\"ativo\" was not injected: check your FXML file 'formulario.fxml'.";
        assert cancelar != null : "fx:id=\"cancelar\" was not injected: check your FXML file 'formulario.fxml'.";
        assert categorias != null : "fx:id=\"categorias\" was not injected: check your FXML file 'formulario.fxml'.";
        assert desce != null : "fx:id=\"desce\" was not injected: check your FXML file 'formulario.fxml'.";
        assert inserir != null : "fx:id=\"inserir\" was not injected: check your FXML file 'formulario.fxml'.";
        assert retirar != null : "fx:id=\"retirar\" was not injected: check your FXML file 'formulario.fxml'.";
        assert salvar != null : "fx:id=\"salvar\" was not injected: check your FXML file 'formulario.fxml'.";
        assert sobe != null : "fx:id=\"sobe\" was not injected: check your FXML file 'formulario.fxml'.";
        assert titulo != null : "fx:id=\"titulo\" was not injected: check your FXML file 'formulario.fxml'.";

        // Initialize your logic here: all @FXML variables will have been injected

    }

}
