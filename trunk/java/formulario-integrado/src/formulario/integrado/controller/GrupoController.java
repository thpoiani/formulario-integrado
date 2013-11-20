package formulario.integrado.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class GrupoController extends AbstractController {
    
    private AbstractController controller;
    
    @FXML
    private Button cancelar;

    @FXML
    private Button salvar;

    @FXML
    private ComboBox<?> tipo1;

    @FXML
    private ComboBox<?> tipo2;

    @FXML
    private ComboBox<?> tipo3;

    @FXML
    private ComboBox<?> tipo4;

    @FXML
    private ComboBox<?> tipo5;

    @FXML
    private ComboBox<?> tipo6;

    @FXML
    private TextField titulo1;

    @FXML
    private TextField titulo2;

    @FXML
    private TextField titulo3;

    @FXML
    private TextField titulo4;

    @FXML
    private TextField titulo5;

    @FXML
    private TextField titulo6;

    @FXML
    void cancelarAction(ActionEvent event) {
        getParentController().show();
        super.close();
    }

    @FXML
    void salvarAction(ActionEvent event) {

    }

    @Override
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

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                setWindow(salvar.getScene().getWindow());
            }
        });
    }

    @Override
    public void addParentController(AbstractController controller) {
        this.controller = controller;
    }

    @Override
    public AbstractController getParentController() {
        return this.controller;
    }

}
