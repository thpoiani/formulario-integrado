package formulario.integrado.controller;

import formulario.integrado.model.Campo;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class CategoriaController extends AbstractController {

    private AbstractController controller;
    
    @FXML
    private ListView<Campo> campos;
    
    @FXML
    private Button cancelar;
    
    @FXML
    private Button desce;
    
    @FXML
    private TextField descricao;
    
    @FXML
    private Button editar;
    
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
    void editarAction(ActionEvent event) {
        super.start("campo.fxml", "Campo", this);
        super.hide();
    }

    @FXML
    void inserirAction(ActionEvent event) {
        super.start("campo.fxml", "Campo", this);
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
        assert campos != null : "fx:id=\"campos\" was not injected: check your FXML file 'categoria.fxml'.";
        assert cancelar != null : "fx:id=\"cancelar\" was not injected: check your FXML file 'categoria.fxml'.";
        assert desce != null : "fx:id=\"desce\" was not injected: check your FXML file 'categoria.fxml'.";
        assert descricao != null : "fx:id=\"descricao\" was not injected: check your FXML file 'categoria.fxml'.";
        assert editar != null : "fx:id=\"editar\" was not injected: check your FXML file 'categoria.fxml'.";
        assert inserir != null : "fx:id=\"inserir\" was not injected: check your FXML file 'categoria.fxml'.";
        assert retirar != null : "fx:id=\"retirar\" was not injected: check your FXML file 'categoria.fxml'.";
        assert salvar != null : "fx:id=\"salvar\" was not injected: check your FXML file 'categoria.fxml'.";
        assert sobe != null : "fx:id=\"sobe\" was not injected: check your FXML file 'categoria.fxml'.";
        assert titulo != null : "fx:id=\"titulo\" was not injected: check your FXML file 'categoria.fxml'.";

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
