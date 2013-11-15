package formulario.integrado.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class PrincipalController extends AbstractController {
    
//    private AbstractController controller;
//    
//    @Override
//    public void addParentController(AbstractController controller) {
//        this.controller = controller;
//    }
//    
//    @Override
//    public AbstractController getParentController() {
//        return this.controller;
//    }
    
    @FXML
    private Button categoria;

    @FXML
    private Button categorias;

    @FXML
    private Button formulario;

    @FXML
    private Button formularios;

    @FXML
    private Button respostas;

    @FXML
    void categoriaAction(ActionEvent event) {
        super.start("categoria.fxml", "Categoria", this);
        super.hide();
    }

    @FXML
    void categoriasAction(ActionEvent event) {
        super.start("categorias.fxml", "Categorias", this);
        super.hide();
    }

    @FXML
    void formularioAction(ActionEvent event) {
        super.start("formulario.fxml", "Formulário", this);
        super.hide();
    }

    @FXML
    void formulariosAction(ActionEvent event) {
        super.start("formularios.fxml", "Formulários", this);
        super.hide();
    }

    @FXML
    void respostasAction(ActionEvent event) {
        super.start("pesquisas.fxml", "Respostas", this);
        super.hide();
        
//        getParentController().show();
    }

    @Override
    void initialize() {
        assert categoria != null : "fx:id=\"categoria\" was not injected: check your FXML file 'principal.fxml'.";
        assert categorias != null : "fx:id=\"categorias\" was not injected: check your FXML file 'principal.fxml'.";
        assert formulario != null : "fx:id=\"formulario\" was not injected: check your FXML file 'principal.fxml'.";
        assert formularios != null : "fx:id=\"formularios\" was not injected: check your FXML file 'principal.fxml'.";
        assert respostas != null : "fx:id=\"respostas\" was not injected: check your FXML file 'principal.fxml'.";
        
        Platform.runLater(new Runnable() {
            @Override public void run() {
                setWindow(respostas.getScene().getWindow());
            }
        });
    }

}
