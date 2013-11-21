package formulario.integrado.controller;

import formulario.integrado.business.CategoriaBusiness;
import formulario.integrado.business.ICategoriaBusiness;
import formulario.integrado.model.Categoria;
import java.util.ArrayList;
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
//        List<Categoria> categorias = categoriaBusiness.show();
//        if (getParentController().models != null) {
//            categorias.removeAll(getParentController().models);
//        } else {
//            getParentController().models = new ArrayList<>();
//        }
//        this.dados = FXCollections.observableArrayList(categorias);
//        tabela.setItems(this.dados);

        fakeData();
    }

    /**
     * Método com dados fictícios para homologação
     * 
     */
    private void fakeData() {
        Categoria categoria1 = new Categoria();
        categoria1.setId(1);
        categoria1.setTitulo("categoria 1");
        categoria1.setDescricao("descricao 1");

        Categoria categoria2 = new Categoria();
        categoria2.setId(2);
        categoria2.setTitulo("categoria 2");
        categoria2.setDescricao("descricao 2");

        Categoria categoria3 = new Categoria();
        categoria3.setId(3);
        categoria3.setTitulo("categoria 3");
        categoria3.setDescricao("descricao 3");

        ArrayList<Categoria> categorias = new ArrayList<>();
        categorias.add(categoria1);
        categorias.add(categoria2);
        categorias.add(categoria3);

        if (getParentController().models != null) {
            categorias.removeAll(getParentController().models);
        } else {
            getParentController().models = new ArrayList<>();
        }
        
        dados = FXCollections.observableArrayList(categorias);
        tabela.setItems(dados);
    }

}
