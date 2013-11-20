
package formulario.integrado.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class CategoriasListarController extends AbstractController {
    
    private AbstractController controller;

    @FXML
    private Button cancelar;

    @FXML
    private TableColumn<?, ?> descricao;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private Button salvar;

    @FXML
    private TableView<?> tabela;

    @FXML
    private TableColumn<?, ?> titulo;

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
        assert cancelar != null : "fx:id=\"cancelar\" was not injected: check your FXML file 'categorias-listar.fxml'.";
        assert descricao != null : "fx:id=\"descricao\" was not injected: check your FXML file 'categorias-listar.fxml'.";
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'categorias-listar.fxml'.";
        assert salvar != null : "fx:id=\"salvar\" was not injected: check your FXML file 'categorias-listar.fxml'.";
        assert tabela != null : "fx:id=\"tabela\" was not injected: check your FXML file 'categorias-listar.fxml'.";
        assert titulo != null : "fx:id=\"titulo\" was not injected: check your FXML file 'categorias-listar.fxml'.";

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
