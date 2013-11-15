/**
 * Sample Skeleton for "campo.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package formulario.integrado.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;


public class CampoController extends AbstractController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="UnicaEscolha"
    private RadioButton UnicaEscolha; // Value injected by FXMLLoader

    @FXML // fx:id="cancelar"
    private Button cancelar; // Value injected by FXMLLoader

    @FXML // fx:id="editar"
    private Button editar; // Value injected by FXMLLoader

    @FXML // fx:id="maxlength"
    private TextField maxlength; // Value injected by FXMLLoader

    @FXML // fx:id="multiplaEscolha"
    private RadioButton multiplaEscolha; // Value injected by FXMLLoader

    @FXML // fx:id="multiplaEscolhaPane"
    private Pane multiplaEscolhaPane; // Value injected by FXMLLoader

    @FXML // fx:id="radio"
    private ToggleGroup radio; // Value injected by FXMLLoader

    @FXML // fx:id="regex"
    private TextField regex; // Value injected by FXMLLoader

    @FXML // fx:id="salvar"
    private Button salvar; // Value injected by FXMLLoader

    @FXML // fx:id="textoAberto"
    private RadioButton textoAberto; // Value injected by FXMLLoader

    @FXML // fx:id="textoAbertoPane"
    private Pane textoAbertoPane; // Value injected by FXMLLoader

    @FXML // fx:id="tipo"
    private ComboBox<?> tipo; // Value injected by FXMLLoader

    @FXML // fx:id="titulo"
    private TextField titulo; // Value injected by FXMLLoader


    // Handler for RadioButton[fx:id="UnicaEscolha"] onAction
    @FXML
    void UnicaEscolhaAction(ActionEvent event) {
        // handle the event here
        super.start("grupo.fxml", "Grupo");
        textoAbertoPane.setVisible(false);
        multiplaEscolhaPane.setVisible(true);
        editar.setVisible(true);
    }

    // Handler for Button[fx:id="cancelar"] onAction
    @FXML
    void cancelarAction(ActionEvent event) {
        // handle the event here
    }

    // Handler for Button[fx:id="editar"] onAction
    @FXML
    void editarAction(ActionEvent event) {
        // handle the event here
        super.start("grupos.fxml", "Grupo");
    }

    // Handler for RadioButton[fx:id="multiplaEscolha"] onAction
    @FXML
    void multiplaEscolhaAction(ActionEvent event) {
        // handle the event here
        super.start("grupo.fxml", "Grupo");
        textoAbertoPane.setVisible(false);
        multiplaEscolhaPane.setVisible(true);
        editar.setVisible(true);
    }

    // Handler for Button[fx:id="salvar"] onAction
    @FXML
    void salvarAction(ActionEvent event) {
        // handle the event here
    }

    // Handler for RadioButton[fx:id="textoAberto"] onAction
    @FXML
    void textoAbertoAction(ActionEvent event) {
        // handle the event here
        multiplaEscolhaPane.setVisible(false);
        textoAbertoPane.setVisible(true);
        editar.setVisible(false);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert UnicaEscolha != null : "fx:id=\"UnicaEscolha\" was not injected: check your FXML file 'campo.fxml'.";
        assert cancelar != null : "fx:id=\"cancelar\" was not injected: check your FXML file 'campo.fxml'.";
        assert editar != null : "fx:id=\"editar\" was not injected: check your FXML file 'campo.fxml'.";
        assert maxlength != null : "fx:id=\"maxlength\" was not injected: check your FXML file 'campo.fxml'.";
        assert multiplaEscolha != null : "fx:id=\"multiplaEscolha\" was not injected: check your FXML file 'campo.fxml'.";
        assert multiplaEscolhaPane != null : "fx:id=\"multiplaEscolhaPane\" was not injected: check your FXML file 'campo.fxml'.";
        assert radio != null : "fx:id=\"radio\" was not injected: check your FXML file 'campo.fxml'.";
        assert regex != null : "fx:id=\"regex\" was not injected: check your FXML file 'campo.fxml'.";
        assert salvar != null : "fx:id=\"salvar\" was not injected: check your FXML file 'campo.fxml'.";
        assert textoAberto != null : "fx:id=\"textoAberto\" was not injected: check your FXML file 'campo.fxml'.";
        assert textoAbertoPane != null : "fx:id=\"textoAbertoPane\" was not injected: check your FXML file 'campo.fxml'.";
        assert tipo != null : "fx:id=\"tipo\" was not injected: check your FXML file 'campo.fxml'.";
        assert titulo != null : "fx:id=\"titulo\" was not injected: check your FXML file 'campo.fxml'.";

        // Initialize your logic here: all @FXML variables will have been injected

    }

}
