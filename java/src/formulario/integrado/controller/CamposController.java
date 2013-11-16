package formulario.integrado.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;


public class CamposController extends AbstractController {
    
    private AbstractController controller;

    @FXML
    private Button cancelar;

    @FXML
    private Button editar;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private Button remover;

    @FXML
    private TableColumn<?, ?> tipo;

    @FXML
    private TableColumn<?, ?> titulo;

    @FXML
    void cancelarAction(ActionEvent event) {
        getParentController().show();
        super.close();
    }

    @FXML
    void editarAction(ActionEvent event) {
        super.start("campo.fxml", "Campo");
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
        assert cancelar != null : "fx:id=\"cancelar\" was not injected: check your FXML file 'campos.fxml'.";
        assert editar != null : "fx:id=\"editar\" was not injected: check your FXML file 'campos.fxml'.";
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'campos.fxml'.";
        assert remover != null : "fx:id=\"remover\" was not injected: check your FXML file 'campos.fxml'.";
        assert tipo != null : "fx:id=\"tipo\" was not injected: check your FXML file 'campos.fxml'.";
        assert titulo != null : "fx:id=\"titulo\" was not injected: check your FXML file 'campos.fxml'.";

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                setWindow(cancelar.getScene().getWindow());
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
