package formulario.integrado.controller;

import formulario.integrado.model.Tipo;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

public class CampoController extends AbstractController {
    
    private AbstractController controller;

    @FXML
    private RadioButton UnicaEscolha;

    @FXML
    private Button cancelar;

    @FXML
    private Button editar;

    @FXML
    private TextField maxlength;

    @FXML
    private RadioButton multiplaEscolha;

    @FXML
    private Pane multiplaEscolhaPane;

    @FXML
    private ToggleGroup radio;

    @FXML
    private TextField regex;

    @FXML
    private Button salvar;

    @FXML
    private RadioButton textoAberto;

    @FXML
    private Pane textoAbertoPane;

    @FXML
    private ComboBox<Tipo> tipo;

    @FXML
    private TextField titulo;

    @FXML
    void UnicaEscolhaAction(ActionEvent event) {
        super.start("grupo.fxml", "Grupo");
        textoAbertoPane.setVisible(false);
        multiplaEscolhaPane.setVisible(true);
        editar.setVisible(true);
    }

    @FXML
    void cancelarAction(ActionEvent event) {
        getParentController().show();
        super.close();
    }

    @FXML
    void editarAction(ActionEvent event) {
        super.start("grupos.fxml", "Grupo", this);
        super.hide();
    }

    @FXML
    void multiplaEscolhaAction(ActionEvent event) {
        super.start("grupo.fxml", "Grupo");
        textoAbertoPane.setVisible(false);
        multiplaEscolhaPane.setVisible(true);
        editar.setVisible(true);
    }

    @FXML
    void salvarAction(ActionEvent event) {

    }

    @FXML
    void textoAbertoAction(ActionEvent event) {
        multiplaEscolhaPane.setVisible(false);
        textoAbertoPane.setVisible(true);
        editar.setVisible(false);
    }

    @Override
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

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                setWindow(titulo.getScene().getWindow());
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
