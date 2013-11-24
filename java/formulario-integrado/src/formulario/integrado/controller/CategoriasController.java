package formulario.integrado.controller;

import formulario.integrado.business.CategoriaBusiness;
import formulario.integrado.business.ICategoriaBusiness;
import formulario.integrado.model.Categoria;
import formulario.integrado.vendor.Dialog;
import java.sql.SQLException;
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

public class CategoriasController extends AbstractController {

    private AbstractController controller;
    
    private ICategoriaBusiness categoriaBusiness;
    
    private ObservableList<Categoria> dados = FXCollections.observableArrayList();
    
    private ObservableList<Categoria> filtro = FXCollections.observableArrayList();
    
    @FXML
    private Button cancelar;
    
    @FXML
    private TableColumn<Categoria, String> descricao;
    
    @FXML
    private Button editar;
    
    @FXML
    private TableColumn<Categoria, Integer> id;
    
    @FXML
    private TextField pesquisar;
    
    @FXML
    private Button remover;
    
    @FXML
    private TableView<Categoria> tabela;
    
    @FXML
    private TableColumn<Categoria, String> titulo;

    public CategoriasController() {
        this.categoriaBusiness = new CategoriaBusiness();
    }
    
    @Override
    void initialize() {
        assert cancelar != null : "fx:id=\"cancelar\" was not injected: check your FXML file 'categorias.fxml'.";
        assert descricao != null : "fx:id=\"descricao\" was not injected: check your FXML file 'categorias.fxml'.";
        assert editar != null : "fx:id=\"editar\" was not injected: check your FXML file 'categorias.fxml'.";
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'categorias.fxml'.";
        assert pesquisar != null : "fx:id=\"pesquisarField\" was not injected: check your FXML file 'categorias.fxml'.";
        assert remover != null : "fx:id=\"remover\" was not injected: check your FXML file 'categorias.fxml'.";
        assert tabela != null : "fx:id=\"tabela\" was not injected: check your FXML file 'formularios.fxml'.";
        assert titulo != null : "fx:id=\"titulo\" was not injected: check your FXML file 'categorias.fxml'.";

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
        if (categoriaIsSelected()) {
            super.model = tabela.getSelectionModel().getSelectedItem();
            super.start("categoria.fxml", "Categoria", this);
            super.hide();
        }
    }

    @FXML
    void removerAction(ActionEvent event) {
        if (categoriaIsSelected()) {
            Dialog.buildConfirmation(
                    "Remover categoria",
                    "Deseja remover a categoria '" 
                    + tabela.getSelectionModel().getSelectedItem().getTitulo() + "'?")
                    .addYesButton(new removerEvent())
                    .addNoButton(null)
                    .build()
                    .show();
        }
    }
    
    /**
     * Método para atribuir os dados exibidos na tabela
     * 
     */
    private void populateTableView() {
        descricao.setCellValueFactory(new PropertyValueFactory<Categoria, String>("descricao"));
        id.setCellValueFactory(new PropertyValueFactory<Categoria, Integer>("id"));
        titulo.setCellValueFactory(new PropertyValueFactory<Categoria, String>("titulo"));
        
        try {
            this.dados = FXCollections.observableArrayList(this.categoriaBusiness.show());
            tabela.setItems(this.dados);
        } catch (SQLException e) {
            Dialog.showError("Categorias", "Ocorreu algum problema na recuperação das categorias.");
        }
        
        this.filtro.addAll(this.dados);
    }
    
    /**
     * Método para verificar se alguma categoria está selecionada
     *
     * @return boolean
     */
    private boolean categoriaIsSelected() {
        return tabela.getSelectionModel().getSelectedItem() != null;
    }

    /**
     * Método para filtrar os resultados inseridos e os adicionar a ListView
     *
     */
    private void filterResults() {
        filtro.clear();

        for (Categoria categoria : dados) {
            if (matchesFilter(categoria)) {
                filtro.add(categoria);
            }
        }

        tabela.setItems(this.filtro);
    }
    
    /**
     * Método para validar o filtro com os dados existentes
     * 
     * @param Categoria categoria
     * @return boolean
     */
    private boolean matchesFilter(Categoria categoria) {
        String filtro = pesquisar.getText().toLowerCase();

        if (filtro == null || filtro.isEmpty()) {
            return true;
        }

        return categoria.getTitulo().toLowerCase().contains(filtro)
                || categoria.getDescricao().toLowerCase().contains(filtro);
    }

    /**
     * Método para reordenar tabela
     * 
     */
    private void reorderTableView() {
        ArrayList<TableColumn<Categoria, ?>> resultado = new ArrayList<>(tabela.getSortOrder());

        tabela.getSortOrder().clear();
        tabela.getSortOrder().addAll(resultado);
    }
    
    /**
     * Método para remoção de Categoria
     *
     * @param Categoria categoria
     */
    private void remover(Categoria categoria) {
        try {
            this.categoriaBusiness.remove(categoria);
            this.dados.remove(categoria);
            this.filtro.remove(categoria);

            Dialog.showInfo("Categoria", "Categoria removida com sucesso");
        } catch (Exception e) {
            Dialog.showError("Categoria", "Ocorreu algum problema na remoção da categoria.");
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
            
            this.dados = FXCollections.observableArrayList(this.categoriaBusiness.show());
            tabela.setItems(this.dados);
            this.filtro.addAll(this.dados);
            
            pesquisar.setText("");
            reorderTableView();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Dialog.showError("Categoria", "Ocorreu algum problema na recuperação das categorias.");
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
