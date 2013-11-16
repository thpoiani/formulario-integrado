package formulario.integrado.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FormulariosController extends AbstractController {
    
    private AbstractController controller;

    @FXML
    private TableColumn<?, ?> aberto;

    @FXML
    private Button cancelar;

    @FXML
    private Button editar;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private Button pesquisar;

    @FXML
    private TextField pesquisarField;

    @FXML
    private Button remover;

    @FXML
    private TableView<?> tabela;

    @FXML
    private TableColumn<?, ?> titulo;

    @FXML
    private Button visualizar;

    @FXML
    void cancelarAction(ActionEvent event) {
        getParentController().show();
        super.close();
    }

    @FXML
    void editarAction(ActionEvent event) {
        super.start("formulario.fxml", "Formulário");
        super.hide();
    }

    @FXML
    void pesquisarAction(ActionEvent event) {
    
    }

    @FXML
    void visualizarAction(ActionEvent event) {
    
    }

    @Override
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

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                setWindow(pesquisar.getScene().getWindow());
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
