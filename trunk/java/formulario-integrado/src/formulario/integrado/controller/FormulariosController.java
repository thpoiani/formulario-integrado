package formulario.integrado.controller;

import formulario.integrado.business.FormularioBusiness;
import formulario.integrado.business.IFormularioBusiness;
import formulario.integrado.model.Formulario;
import formulario.integrado.model.IModel;
import formulario.integrado.vendor.Dialog;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FormulariosController extends AbstractController {

    private AbstractController controller;

    private IFormularioBusiness formularioBusiness;
    private IModel model;
    
    private ObservableList<Formulario> dados = FXCollections.observableArrayList();
    private ObservableList<Formulario> filtro = FXCollections.observableArrayList();
    
    @FXML
    private TableColumn<Formulario, String> aberto;
    
    @FXML
    private Button cancelar;
    
    @FXML
    private Button editar;
    
    @FXML
    private TableColumn<Formulario, Integer> id;
    
    @FXML
    private TextField pesquisar;
    
    @FXML
    private Button remover;
    
    @FXML
    private TableView<Formulario> tabela;
    
    @FXML
    private TableColumn<Formulario, String> titulo;
    
    @FXML
    private Button visualizar;
    
    @FXML
    void cancelarAction(ActionEvent event) {
        getParentController().show();
        super.close();
    }

    @FXML
    void editarAction(ActionEvent event) {
        Formulario formulario = tabela.getSelectionModel().getSelectedItem();

        if (formulario != null) {
            super.model = formulario;
            super.start("formulario.fxml", "Formulário", this);
            super.hide();
        }
    }
    
    @FXML
    void removerAction(ActionEvent event) {
        Formulario formulario = tabela.getSelectionModel().getSelectedItem();

        if (formulario != null) {
            Dialog.buildConfirmation("Remover formulário", "Deseja remover o formulário '" + formulario.getTitulo() + "'?")
                    .addYesButton(new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            remover(tabela.getSelectionModel().getSelectedItem());
                        }
                    })
                    .addNoButton(null)
                    .build()
                    .show();
        }
    }

    @FXML
    void visualizarAction(ActionEvent event) throws IOException, URISyntaxException {
        Formulario formulario = tabela.getSelectionModel().getSelectedItem();

        if (formulario != null) {
            Desktop.getDesktop().browse(new URI("http://formulario-integrado.com/formulario/" + formulario.getId()));
        }
    }

    @Override
    void initialize() {
        assert aberto != null : "fx:id=\"aberto\" was not injected: check your FXML file 'formularios.fxml'.";
        assert cancelar != null : "fx:id=\"cancelar\" was not injected: check your FXML file 'formularios.fxml'.";
        assert editar != null : "fx:id=\"editar\" was not injected: check your FXML file 'formularios.fxml'.";
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'formularios.fxml'.";
        assert pesquisar != null : "fx:id=\"pesquisarField\" was not injected: check your FXML file 'formularios.fxml'.";
        assert remover != null : "fx:id=\"remover\" was not injected: check your FXML file 'formularios.fxml'.";
        assert tabela != null : "fx:id=\"tabela\" was not injected: check your FXML file 'formularios.fxml'.";
        assert titulo != null : "fx:id=\"titulo\" was not injected: check your FXML file 'formularios.fxml'.";
        assert visualizar != null : "fx:id=\"visualizar\" was not injected: check your FXML file 'formularios.fxml'.";

        this.formularioBusiness = new FormularioBusiness();

        aberto.setCellValueFactory(new PropertyValueFactory<Formulario, String>("aberto"));
        id.setCellValueFactory(new PropertyValueFactory<Formulario, Integer>("id"));
        titulo.setCellValueFactory(new PropertyValueFactory<Formulario, String>("titulo"));

//        this.dados = FXCollections.observableArrayList(formularioBusiness.show());
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
                setWindow(visualizar.getScene().getWindow());
            }
        });

    }

    private void filtrarResultados() {
        filtro.clear();

        for (Formulario formulario : dados) {
            if (validarFiltro(formulario)) {
                filtro.add(formulario);
            }
        }
        
        atribuirResultados();
    }

    private boolean validarFiltro(Formulario formulario) {
        String filtro = pesquisar.getText().toLowerCase();

        if (filtro == null || filtro.isEmpty()) return true;
        
        return formulario.getTitulo().toLowerCase().contains(filtro);
    }
    
    private void atribuirResultados() {
        tabela.setItems(this.filtro);
        reordenarTabela();
    }

    private void reordenarTabela() {
        ArrayList<TableColumn<Formulario, ?>> resultado = new ArrayList<>(tabela.getSortOrder());
        
        tabela.getSortOrder().clear();
        tabela.getSortOrder().addAll(resultado);
    }
    
    /**
     * Método para remoção de Formulário
     *
     * @param formulario
     */
    private void remover(Formulario formulario) {
        try {
            // this.formularioBusiness.remove(formulario);
            this.dados.remove(formulario);
            this.filtro.remove(formulario);

            Dialog.showInfo("Formulário", "Formulário removido com sucesso");
        } catch (Exception e) {
            Dialog.showError("Formulário", "Ocorreu algum problema na remoção do formulário.");
        }
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
        Formulario formulario1 = new Formulario();

        formulario1.setTitulo("thiago");
        formulario1.setId(1);
        formulario1.setAberto(true);
        formulario1.setData(new Date());
        formulario1.setStatus(false);

        Formulario formulario2 = new Formulario();
        formulario2.setId(2);
        formulario2.setTitulo("poiani");
        formulario2.setAberto(false);

        ArrayList<Formulario> formularios = new ArrayList<Formulario>();
        formularios.add(formulario1);
        formularios.add(formulario2);

        dados = FXCollections.observableArrayList(formularios);
        tabela.setItems(dados);
    }
}
