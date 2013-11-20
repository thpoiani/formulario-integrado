package formulario.integrado.controller;

import formulario.integrado.model.Categoria;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;


public class FormularioController extends AbstractController {
    
    private AbstractController controller;
    
    @FXML
    private ToggleGroup ativo;

    @FXML
    private Button cancelar;

    @FXML
    private ListView<Categoria> categorias;

    @FXML
    private Button desce;

    @FXML
    private Button inserir;

    @FXML
    private Button retirar;

    @FXML
    private Button salvar;

    @FXML
    private Button sobe;

    @FXML
    private TextField titulo;

    @FXML
    void cancelarAction(ActionEvent event) {
        getParentController().show();
        super.close();
    }

    @FXML
    void desceAction(ActionEvent event) {
    
    }

    @FXML
    void inserirAction(ActionEvent event) {
        super.start("categoria.fxml", "Categoria", this);
        super.hide();
    }

    @FXML
    void retirarAction(ActionEvent event) {
    
    }

    @FXML
    void salvarAction(ActionEvent event) {
    
    }

    @FXML
    void sobeAction(ActionEvent event) {
    
    }

    @Override
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
