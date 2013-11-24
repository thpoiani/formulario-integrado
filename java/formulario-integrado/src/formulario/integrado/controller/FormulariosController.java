package formulario.integrado.controller;

import formulario.integrado.business.FormularioBusiness;
import formulario.integrado.business.IFormularioBusiness;
import formulario.integrado.model.Formulario;
import formulario.integrado.vendor.Dialog;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
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
import javafx.stage.WindowEvent;

public class FormulariosController extends AbstractController {

    private AbstractController controller;
    
    private IFormularioBusiness formularioBusiness;
    
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

    public FormulariosController() {
        this.formularioBusiness = new FormularioBusiness();
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

        populateTableView();

        pesquisar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                filterResults();
                reorderTableView();
            }
        });

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                setWindow(tabela.getScene().getWindow());
                onShowRefreshTableView();
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
   
    @FXML
    void cancelarAction(ActionEvent event) {
        getParentController().show();
        super.close();
    }

    @FXML
    void editarAction(ActionEvent event) {
        if (formularioIsSelected()) {
            super.model = tabela.getSelectionModel().getSelectedItem();
            super.start("formulario.fxml", "Formulário", this);
            super.hide();
        }
    }

    @FXML
    void removerAction(ActionEvent event) {
        if (formularioIsSelected()) {
            Dialog.buildConfirmation(
                    "Remover formulário",
                    "Deseja remover o formulário '" 
                    + tabela.getSelectionModel().getSelectedItem().getTitulo() + "'?")
                    .addYesButton(new removerEvent())
                    .addNoButton(null)
                    .build()
                    .show();
        }
    }

    @FXML
    void visualizarAction(ActionEvent event) throws IOException, URISyntaxException {
        if (formularioIsSelected()) {
            Desktop.getDesktop().browse(
                    new URI(
                    "http://formulario-integrado.com/formulario/"
                    + tabela.getSelectionModel().getSelectedItem().getId()));
        }
    }
    
    /**
     * Método para atribuir os dados exibidos na tabela
     * 
     */
    private void populateTableView() {
        aberto.setCellValueFactory(new PropertyValueFactory<Formulario, String>("aberto"));
        id.setCellValueFactory(new PropertyValueFactory<Formulario, Integer>("id"));
        titulo.setCellValueFactory(new PropertyValueFactory<Formulario, String>("titulo"));
        
        try {
            this.dados = FXCollections.observableArrayList(formularioBusiness.show());
            tabela.setItems(this.dados);
            this.filtro.addAll(this.dados);
        } catch (Exception e) {
            Dialog.showError("Formulário", "Ocorreu algum problema na recuperação dos formulários.");
            this.close();
        }
    }
    
    /**
     * Método para verificar se algum formulário está selecionado
     *
     * @return boolean
     */
    private boolean formularioIsSelected() {
        return tabela.getSelectionModel().getSelectedItem() != null;
    }

    /**
     * Método para filtrar os resultados inseridos e os adicionar a ListView
     *
     */
    private void filterResults() {
        filtro.clear();

        for (Formulario formulario : dados) {
            if (matchesFilter(formulario)) {
                filtro.add(formulario);
            }
        }

        tabela.setItems(this.filtro);
    }

    /**
     * Método para validar o filtro com os dados existentes
     * 
     * @param Formulario formulario
     * @return boolean
     */
    private boolean matchesFilter(Formulario formulario) {
        String filtro = pesquisar.getText().toLowerCase();

        if (filtro == null || filtro.isEmpty()) {
            return true;
        }

        return formulario.getTitulo().toLowerCase().contains(filtro);
    }

    /**
     * Método para reordenar tabela
     * 
     */
    private void reorderTableView() {
        ArrayList<TableColumn<Formulario, ?>> resultado = new ArrayList<>(tabela.getSortOrder());

        tabela.getSortOrder().clear();
        tabela.getSortOrder().addAll(resultado);
    }

    /**
     * Método para remoção de Formulário
     *
     * @param Formulario formulario
     */
    private void remover(Formulario formulario) {
        try {
            this.formularioBusiness.remove(formulario);
            this.dados.remove(formulario);
            this.filtro.remove(formulario);

            Dialog.showInfo("Formulário", "Formulário removido com sucesso");
        } catch (Exception e) {
            Dialog.showError("Formulário", "Ocorreu algum problema na remoção do formulário.");
            this.close();
        }
    }
    
    /**
     * Método para adicionar um Listener de onShowing. Quando exibir a tela,
     * atualiza a lista de categorias
     *
     */
    private void onShowRefreshTableView() {
        getWindow().setOnShowing(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                refreshTableView();
            }
        });
    }

    /**
     * Método para atualizar lista de categorias
     *
     */
    @SuppressWarnings("unchecked")
    private void refreshTableView() {
        try {
            tabela.setItems(null);
            tabela.setItems(FXCollections.observableArrayList(this.formularioBusiness.show()));
        } catch (Exception e) {
            Dialog.showError("Formulário", "Ocorreu algum problema na recuperação dos formulários.");
        }
    }

    /**
     * Classe privada com implementação do evento de remoção de formulário
     */
    private class removerEvent implements EventHandler {

        @Override
        public void handle(Event event) {
            remover(tabela.getSelectionModel().getSelectedItem());
        }
    }
}
