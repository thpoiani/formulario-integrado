/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario.integrado.controller;

/**
 * Sample Skeleton for "grupo.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


public class GrupoController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="cancelar"
    private Button cancelar; // Value injected by FXMLLoader

    @FXML // fx:id="salvar"
    private Button salvar; // Value injected by FXMLLoader

    @FXML // fx:id="tipo1"
    private ComboBox<?> tipo1; // Value injected by FXMLLoader

    @FXML // fx:id="tipo2"
    private ComboBox<?> tipo2; // Value injected by FXMLLoader

    @FXML // fx:id="tipo3"
    private ComboBox<?> tipo3; // Value injected by FXMLLoader

    @FXML // fx:id="tipo4"
    private ComboBox<?> tipo4; // Value injected by FXMLLoader

    @FXML // fx:id="tipo5"
    private ComboBox<?> tipo5; // Value injected by FXMLLoader

    @FXML // fx:id="tipo6"
    private ComboBox<?> tipo6; // Value injected by FXMLLoader

    @FXML // fx:id="titulo1"
    private TextField titulo1; // Value injected by FXMLLoader

    @FXML // fx:id="titulo2"
    private TextField titulo2; // Value injected by FXMLLoader

    @FXML // fx:id="titulo3"
    private TextField titulo3; // Value injected by FXMLLoader

    @FXML // fx:id="titulo4"
    private TextField titulo4; // Value injected by FXMLLoader

    @FXML // fx:id="titulo5"
    private TextField titulo5; // Value injected by FXMLLoader

    @FXML // fx:id="titulo6"
    private TextField titulo6; // Value injected by FXMLLoader


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
        assert cancelar != null : "fx:id=\"cancelar\" was not injected: check your FXML file 'grupo.fxml'.";
        assert salvar != null : "fx:id=\"salvar\" was not injected: check your FXML file 'grupo.fxml'.";
        assert tipo1 != null : "fx:id=\"tipo1\" was not injected: check your FXML file 'grupo.fxml'.";
        assert tipo2 != null : "fx:id=\"tipo2\" was not injected: check your FXML file 'grupo.fxml'.";
        assert tipo3 != null : "fx:id=\"tipo3\" was not injected: check your FXML file 'grupo.fxml'.";
        assert tipo4 != null : "fx:id=\"tipo4\" was not injected: check your FXML file 'grupo.fxml'.";
        assert tipo5 != null : "fx:id=\"tipo5\" was not injected: check your FXML file 'grupo.fxml'.";
        assert tipo6 != null : "fx:id=\"tipo6\" was not injected: check your FXML file 'grupo.fxml'.";
        assert titulo1 != null : "fx:id=\"titulo1\" was not injected: check your FXML file 'grupo.fxml'.";
        assert titulo2 != null : "fx:id=\"titulo2\" was not injected: check your FXML file 'grupo.fxml'.";
        assert titulo3 != null : "fx:id=\"titulo3\" was not injected: check your FXML file 'grupo.fxml'.";
        assert titulo4 != null : "fx:id=\"titulo4\" was not injected: check your FXML file 'grupo.fxml'.";
        assert titulo5 != null : "fx:id=\"titulo5\" was not injected: check your FXML file 'grupo.fxml'.";
        assert titulo6 != null : "fx:id=\"titulo6\" was not injected: check your FXML file 'grupo.fxml'.";

        // Initialize your logic here: all @FXML variables will have been injected

    }

}
