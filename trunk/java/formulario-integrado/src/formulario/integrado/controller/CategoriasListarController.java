package formulario.integrado.controller;

import formulario.integrado.business.CategoriaBusiness;
import formulario.integrado.business.ICategoriaBusiness;
import formulario.integrado.model.Categoria;
import formulario.integrado.vendor.Dialog;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CategoriasListarController extends AbstractController {

    private AbstractController controller;
    
    private ICategoriaBusiness categoriaBusiness;
    
    private ObservableList<Categoria> dados = FXCollections.observableArrayList();
    
    @FXML
    private Button cancelar;
    
    @FXML
    private TableColumn<Categoria, String> descricao;
    
    @FXML
    private TableColumn<Categoria, Integer> id;
    
    @FXML
    private Button inserir;
    
    @FXML
    private TableView<Categoria> tabela;
    
    @FXML
    private TableColumn<Categoria, String> titulo;
    
    public CategoriasListarController() {
        this.categoriaBusiness = new CategoriaBusiness();
    }    

    @Override
    void initialize() {
        assert cancelar != null : "fx:id=\"cancelar\" was not injected: check your FXML file 'categorias-listar.fxml'.";
        assert descricao != null : "fx:id=\"descricao\" was not injected: check your FXML file 'categorias-listar.fxml'.";
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'categorias-listar.fxml'.";
        assert inserir != null : "fx:id=\"salvar\" was not injected: check your FXML file 'categorias-listar.fxml'.";
        assert tabela != null : "fx:id=\"tabela\" was not injected: check your FXML file 'categorias-listar.fxml'.";
        assert titulo != null : "fx:id=\"titulo\" was not injected: check your FXML file 'categorias-listar.fxml'.";

        populateTableColumns();

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                setWindow(inserir.getScene().getWindow());
                populateTableView();
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
    @SuppressWarnings("unchecked")
    void inserirAction(ActionEvent event) {
        if (categoriaIsSelected()) {
            getParentController().models.add(tabela.getSelectionModel().getSelectedItem());;
            getParentController().show();
            super.close();
        }
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
     * Método para atribuir os valores às colunas da TableView
     */
    private void populateTableColumns() {
        descricao.setCellValueFactory(new PropertyValueFactory<Categoria, String>("descricao"));
        id.setCellValueFactory(new PropertyValueFactory<Categoria, Integer>("id"));
        titulo.setCellValueFactory(new PropertyValueFactory<Categoria, String>("titulo"));
    }
    
    /**
     * Método para popular lista de categorias
     *
     */
    private void populateTableView() {
        try {
            List<Categoria> categorias = categoriaBusiness.show();
            if (getParentController().models != null) {
                categorias.removeAll(getParentController().models);
            } else {
                getParentController().models = new ArrayList<>();
            }
            this.dados = FXCollections.observableArrayList(categorias);
            tabela.setItems(this.dados);
        } catch (SQLException ex) {
            Dialog.showError("Categoria", "Ocorreu algum problema na recuperação das categorias.");
        }
    }

}
