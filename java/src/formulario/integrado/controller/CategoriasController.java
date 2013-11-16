package formulario.integrado.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class CategoriasController extends AbstractController {

    private AbstractController controller;

    @FXML
    private Button cancelar;
    
    @FXML
    private TableColumn<?, ?> descricao;
    
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
    private TableColumn<?, ?> titulo;

    @FXML
    void cancelarAction(ActionEvent event) {
        getParentController().show();
        super.close();
    }

    @FXML
    void editarAction(ActionEvent event) {
        super.start("categoria.fxml", "Categoria");
        super.hide();
    }

    @FXML
    void pesquisarAction(ActionEvent event) {
    }

    @FXML
    void removerAction(ActionEvent event) {
    }

    @Override
    void initialize() {
        assert cancelar != null : "fx:id=\"cancelar\" was not injected: check your FXML file 'categorias.fxml'.";
        assert descricao != null : "fx:id=\"descricao\" was not injected: check your FXML file 'categorias.fxml'.";
        assert editar != null : "fx:id=\"editar\" was not injected: check your FXML file 'categorias.fxml'.";
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'categorias.fxml'.";
        assert pesquisar != null : "fx:id=\"pesquisar\" was not injected: check your FXML file 'categorias.fxml'.";
        assert pesquisarField != null : "fx:id=\"pesquisarField\" was not injected: check your FXML file 'categorias.fxml'.";
        assert remover != null : "fx:id=\"remover\" was not injected: check your FXML file 'categorias.fxml'.";
        assert titulo != null : "fx:id=\"titulo\" was not injected: check your FXML file 'categorias.fxml'.";

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
