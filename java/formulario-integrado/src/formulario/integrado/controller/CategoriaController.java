package formulario.integrado.controller;

import formulario.integrado.business.CategoriaBusiness;
import formulario.integrado.business.ICategoriaBusiness;
import formulario.integrado.model.Campo;
import formulario.integrado.model.Categoria;
import formulario.integrado.vendor.Dialog;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.WindowEvent;
import javafx.util.Callback;

public class CategoriaController extends AbstractController {

    private AbstractController controller;
    
    private ICategoriaBusiness categoriaBusiness;
    
    @FXML
    private ListView<Campo> campos;
    
    @FXML
    private Button cancelar;
    
    @FXML
    private Button desce;
    
    @FXML
    private TextField descricao;
    
    @FXML
    private Button editar;
    
    @FXML
    private Button inserir;
    
    @FXML
    private Button retirar;
    
    @FXML
    private Button salvar;
    
    @FXML
    private Button sobe;
    
    @FXML
    private TextField titulo;

    public CategoriaController() {
        this.categoriaBusiness = new CategoriaBusiness();
    }

    @Override
    void initialize() {
        assert campos != null : "fx:id=\"campos\" was not injected: check your FXML file 'categoria.fxml'.";
        assert cancelar != null : "fx:id=\"cancelar\" was not injected: check your FXML file 'categoria.fxml'.";
        assert desce != null : "fx:id=\"desce\" was not injected: check your FXML file 'categoria.fxml'.";
        assert descricao != null : "fx:id=\"descricao\" was not injected: check your FXML file 'categoria.fxml'.";
        assert editar != null : "fx:id=\"editar\" was not injected: check your FXML file 'categoria.fxml'.";
        assert inserir != null : "fx:id=\"inserir\" was not injected: check your FXML file 'categoria.fxml'.";
        assert retirar != null : "fx:id=\"retirar\" was not injected: check your FXML file 'categoria.fxml'.";
        assert salvar != null : "fx:id=\"salvar\" was not injected: check your FXML file 'categoria.fxml'.";
        assert sobe != null : "fx:id=\"sobe\" was not injected: check your FXML file 'categoria.fxml'.";
        assert titulo != null : "fx:id=\"titulo\" was not injected: check your FXML file 'categoria.fxml'.";

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                setWindow(titulo.getScene().getWindow());

                if (getParentController().model != null) {
                    // estado de edição
                    populateModel((Categoria) getParentController().model);
                } else {
                    models = new ArrayList<>();
                }

                populateListView();
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
    void desceAction(ActionEvent event) {
        if (campoIsSelected()) {
            // categoriaBusiness.moveDown(categorias.getSelectionModel().getSelectedItem());
            refreshListView();
        }
    }

    @FXML
    void editarAction(ActionEvent event) {
        if (campoIsSelected()) {
            super.start("campo.fxml", "Campo", this);
            super.hide();
        }
    }

    @FXML
    void inserirAction(ActionEvent event) {
        super.start("campo.fxml", "Campo", this);
        super.hide();
    }

    @FXML
    void retirarAction(ActionEvent event) {
        if (campoIsSelected()) {
            models.remove(campos.getSelectionModel().getSelectedItem());
            refreshListView();
        }
    }

    @FXML
    void salvarAction(ActionEvent event) {
        Categoria categoria = assemblyRequest();
        
        if (categoria.isValid()) {
            try {
                // this.categoriaBusiness.save(categoria);
                getParentController().show();
                super.close();

                Dialog.showInfo("Categoria", "Categoria "
                        + (getParentController().model == null ? "cadastrada" : "alterada")
                        + " com sucesso");
            } catch (Exception e) {
                Dialog.showError("Categoria", "Ocorreu algum problema na persistência da categoria.");
            }
        }
        
        this.showErrors(categoria);
    }

    @FXML
    void sobeAction(ActionEvent event) {
        if (campoIsSelected()) {
            // categoriaBusiness.moveUp(categorias.getSelectionModel().getSelectedItem());
            refreshListView();
        }
    }
    
    /**
     * Método para verificar se algum campo está selecionado
     *
     * @return boolean
     */
    private boolean campoIsSelected() {
        return campos.getSelectionModel().getSelectedItem() != null;
    }
    
    /**
     * Método para popular campos quando a categoria for para edição
     *
     * @param categoria
     */
    private void populateModel(Categoria categoria) {
        models = categoria.getCampos();

        titulo.setText(categoria.getTitulo());
        descricao.setText(categoria.getDescricao());
    }

    /**
     * Método para popular lista de campos
     *
     */
    @SuppressWarnings("unchecked")
    private void populateListView() {
        campos.setItems(FXCollections.observableArrayList(models));
        onShowRefreshListView();
        displayCampoTituloOnListView();
    }
    
    /**
     * Método para adicionar um Listener de onShowing. Quando exibir a tela,
     * atualiza a lista de campos
     *
     */
    private void onShowRefreshListView() {
        getWindow().setOnShowing(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                refreshListView();
            }
        });
    }

    /**
     * Método para atualizar lista de campos
     *
     */
    @SuppressWarnings("unchecked")
    private void refreshListView() {
        campos.setItems(null);
        campos.setItems(FXCollections.observableArrayList(models));
    }
    
    /**
     * Método para exibição do título da categoria na ListView
     *
     */
    private void displayCampoTituloOnListView() {
        campos.setCellFactory(new Callback<ListView<Campo>, ListCell<Campo>>() {
            @Override
            public ListCell<Campo> call(ListView<Campo> campo) {

                ListCell<Campo> cells = new ListCell<Campo>() {
                    @Override
                    protected void updateItem(Campo campo, boolean bool) {
                        super.updateItem(campo, bool);
                        if (campo != null) {
                            setText(campo.getTitulo());
                        }
                    }
                };

                return cells;
            }
        });
    }
    
    /**
     * Método para recuperar dados inseridos pelo usuário
     *
     * @return Categoria
     */
    @SuppressWarnings("unchecked")
    private Categoria assemblyRequest() {
        Categoria categoria;

        if (getParentController().model != null) {
            categoria = (Categoria) getParentController().model;
        } else {
            categoria = new Categoria();
            categoria.setData(new Date());
        }

        categoria.setTitulo(titulo.getText());
        categoria.setDescricao(descricao.getText());
        categoria.setStatus(true);

        categoria.setCampos(models);

        return categoria;
    }

    /**
     * Método para colorir borda de campos inválidos
     *
     * @param Categoria categoria
     */
    private void showErrors(Categoria categoria) {
        titulo.setStyle(super.getClearStyle());

        Iterator<String> iterator = categoria.createErrorIterator();
        while (iterator.hasNext()) {
            switch (iterator.next()) {
                case "titulo":
                    titulo.setStyle(super.getErrorStyle());
                    break;
            }
        }
    }
}
