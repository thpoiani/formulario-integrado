package formulario.integrado.controller;

import formulario.integrado.business.CampoBusiness;
import formulario.integrado.business.ICampoBusiness;
import formulario.integrado.model.Campo;
import formulario.integrado.model.Tipo;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class CamposController extends AbstractController {
    
    private AbstractController controller;
    
    private ICampoBusiness campoBusiness;
    
    private ObservableList<Campo> dados = FXCollections.observableArrayList();
    private ObservableList<Campo> filtro = FXCollections.observableArrayList();

    @FXML
    private Button cancelar;

    @FXML
    private Button editar;

    @FXML
    private TableColumn<Campo, Integer> id;
    
    @FXML
    private TextField pesquisar;

    @FXML
    private Button remover;
    
    @FXML
    private TableView<Campo> tabela;

    @FXML
    private TableColumn<Campo, String> tipo;

    @FXML
    private TableColumn<Campo, String> titulo;

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
    void removerAction(ActionEvent event) {
    
    }

    @Override
    void initialize() {
        assert cancelar != null : "fx:id=\"cancelar\" was not injected: check your FXML file 'campos.fxml'.";
        assert editar != null : "fx:id=\"editar\" was not injected: check your FXML file 'campos.fxml'.";
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'campos.fxml'.";
        assert pesquisar != null : "fx:id=\"pesquisar\" was not injected: check your FXML file 'campos.fxml'.";
        assert remover != null : "fx:id=\"remover\" was not injected: check your FXML file 'campos.fxml'.";
        assert tabela != null : "fx:id=\"tabela\" was not injected: check your FXML file 'campos.fxml'.";
        assert tipo != null : "fx:id=\"tipo\" was not injected: check your FXML file 'campos.fxml'.";
        assert titulo != null : "fx:id=\"titulo\" was not injected: check your FXML file 'campos.fxml'.";

        this.campoBusiness = new CampoBusiness();
        
        id.setCellValueFactory(new PropertyValueFactory<Campo, Integer>("id"));
        titulo.setCellValueFactory(new PropertyValueFactory<Campo, String>("titulo"));
        tipo.setCellValueFactory(new PropertyValueFactory<Campo, String>("tipo"));
        
//        this.dados = FXCollections.observableArrayList(campoBusiness.show());
//        tabela.setItems(this.dados);
        
        testeTabela();
        
        this.filtro.addAll(this.dados);
        
        pesquisar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                filtrarResultados();
            }
        });
        
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                setWindow(cancelar.getScene().getWindow());
            }
        });
    }
    
    private void filtrarResultados() {
        filtro.clear();

        for (Campo campo : dados) {
            if (validarFiltro(campo)) {
                filtro.add(campo);
            }
        }
        
        atribuirResultados();
    }
    
    private boolean validarFiltro(Campo campo) {
        String filtro = pesquisar.getText().toLowerCase();

        if (filtro == null || filtro.isEmpty()) return true;
        
        return campo.getTitulo().toLowerCase().contains(filtro);
    }
    
    private void atribuirResultados() {
        tabela.setItems(this.filtro);
        reordenarTabela();
    }

    private void reordenarTabela() {
        ArrayList<TableColumn<Campo, ?>> resultado = new ArrayList<>(tabela.getSortOrder());
        
        tabela.getSortOrder().clear();
        tabela.getSortOrder().addAll(resultado);
    }

    @Override
    public void addParentController(AbstractController controller) {
        this.controller = controller;
    }

    @Override
    public AbstractController getParentController() {
        return this.controller;
    }

    private void testeTabela() {
        Tipo tipo = new Tipo();
        tipo.setDescricao("Texto");
        
        Campo campo1 = new Campo();
        campo1.setId(1);
        campo1.setTitulo("thiago");
        campo1.setTipo(tipo);
        
        Campo campo2 = new Campo();
        campo2.setId(2);
        campo2.setTitulo("poiani");
        campo2.setTipo(tipo);
        
        ArrayList<Campo> campos = new ArrayList<Campo>();
        campos.add(campo1);
        campos.add(campo2);

        dados = FXCollections.observableArrayList(campos);
        tabela.setItems(dados);
    }
}
