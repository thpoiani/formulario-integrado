
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

    @FXML
    void cancelarAction(ActionEvent event) {
        getParentController().show();
        super.close();
    }

    @FXML
    void inserirAction(ActionEvent event) {
        Categoria categoria = tabela.getSelectionModel().getSelectedItem();
        
        if (categoria != null) {
            getParentController().models.add(categoria);
            // retornar categoria para formulario
            getParentController().show();
            super.close();
        }
    }

    @Override
    void initialize() {
        assert cancelar != null : "fx:id=\"cancelar\" was not injected: check your FXML file 'categorias-listar.fxml'.";
        assert descricao != null : "fx:id=\"descricao\" was not injected: check your FXML file 'categorias-listar.fxml'.";
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'categorias-listar.fxml'.";
        assert inserir != null : "fx:id=\"salvar\" was not injected: check your FXML file 'categorias-listar.fxml'.";
        assert tabela != null : "fx:id=\"tabela\" was not injected: check your FXML file 'categorias-listar.fxml'.";
        assert titulo != null : "fx:id=\"titulo\" was not injected: check your FXML file 'categorias-listar.fxml'.";
        
        this.categoriaBusiness = new CategoriaBusiness();
        
        descricao.setCellValueFactory(new PropertyValueFactory<Categoria, String>("descricao"));
        id.setCellValueFactory(new PropertyValueFactory<Categoria, Integer>("id"));
        titulo.setCellValueFactory(new PropertyValueFactory<Categoria, String>("titulo"));
        
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                setWindow(inserir.getScene().getWindow());
                
//                List<Categoria> categorias = categoriaBusiness.show();
//                categorias.removeAll(getParentController().models);
//                this.dados = FXCollections.observableArrayList(categorias);
//                tabela.setItems(this.dados);
                
                testeTabela();
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
    
    private void testeTabela() {
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
        
        ArrayList<Categoria> categorias = new ArrayList<Categoria>();
        categorias.add(categoria1);
        categorias.add(categoria2);
        categorias.add(categoria3);

        categorias.removeAll(getParentController().models);                
        dados = FXCollections.observableArrayList(categorias);        
        tabela.setItems(dados);
    }

}
