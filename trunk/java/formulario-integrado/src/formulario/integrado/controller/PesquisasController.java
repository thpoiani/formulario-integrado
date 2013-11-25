package formulario.integrado.controller;

import formulario.integrado.business.IRespostaBusiness;
import formulario.integrado.business.RespostaBusiness;
import formulario.integrado.model.Resposta;
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

public class PesquisasController extends AbstractController {
    
    private AbstractController controller;
    
    private IRespostaBusiness respostaBusiness;

    private ObservableList<Resposta> dados = FXCollections.observableArrayList();
    private ObservableList<Resposta> filtro = FXCollections.observableArrayList();
    
    @FXML
    private TableColumn<Resposta, String> aluno;

    @FXML
    private Button cancelar;

    @FXML
    private TableColumn<Resposta, String> formulario;

    @FXML
    private TableColumn<Resposta, Integer> id;

    @FXML
    private TextField pesquisar;

    @FXML
    private TableColumn<Resposta, String> prontuario;

    @FXML
    private TableView<Resposta> tabela;

    @FXML
    private Button visualizar;

    @FXML
    void cancelarAction(ActionEvent event) {
        getParentController().show();
        super.close();
    }

    @FXML
    void visualizarAction(ActionEvent event) {

    }

    @Override
    void initialize() {
        assert aluno != null : "fx:id=\"aluno\" was not injected: check your FXML file 'pesquisas.fxml'.";
        assert cancelar != null : "fx:id=\"cancelar\" was not injected: check your FXML file 'pesquisas.fxml'.";
        assert formulario != null : "fx:id=\"formulario\" was not injected: check your FXML file 'pesquisas.fxml'.";
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'pesquisas.fxml'.";
        assert pesquisar != null : "fx:id=\"pesquisar\" was not injected: check your FXML file 'pesquisas.fxml'.";
        assert prontuario != null : "fx:id=\"prontuario\" was not injected: check your FXML file 'pesquisas.fxml'.";
        assert tabela != null : "fx:id=\"tabela\" was not injected: check your FXML file 'pesquisas.fxml'.";
        assert visualizar != null : "fx:id=\"visualizar\" was not injected: check your FXML file 'pesquisas.fxml'.";

        this.respostaBusiness = new RespostaBusiness();
        
        id.setCellValueFactory(new PropertyValueFactory<Resposta, Integer>("id"));
        prontuario.setCellValueFactory(new PropertyValueFactory<Resposta, String>("prontuario"));
        aluno.setCellValueFactory(new PropertyValueFactory<Resposta, String>("aluno"));
        formulario.setCellValueFactory(new PropertyValueFactory<Resposta, String>("formulario"));

//        this.dados = FXCollections.observableArrayList(respostaBusiness.show());
//        tabela.setItems(this.dados);
        
//        this.filtro.addAll(this.dados);

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

        for (Resposta resposta : dados) {
            if (validarFiltro(resposta)) {
                filtro.add(resposta);
            }
        }
        
        atribuirResultados();
    }
    
    private boolean validarFiltro(Resposta resposta) {
        String filtro = pesquisar.getText().toLowerCase();

        if (filtro == null || filtro.isEmpty()) {
            return true;
        }
        
        // CORRIGIR
        return resposta.getResposta().toLowerCase().contains(filtro);
    }
    
    private void atribuirResultados() {
        tabela.setItems(this.filtro);
        reordenarTabela();
    }

    private void reordenarTabela() {
        ArrayList<TableColumn<Resposta, ?>> resultado = new ArrayList<>(tabela.getSortOrder());
        
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

}
