package formulario.integrado.controller;

import formulario.integrado.business.FormularioBusiness;
import formulario.integrado.business.IFormularioBusiness;
import formulario.integrado.model.Categoria;
import formulario.integrado.model.Formulario;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.WindowEvent;
import javafx.util.Callback;

public class FormularioController extends AbstractController {

    private AbstractController controller;

    private IFormularioBusiness formularioBusiness;

    @FXML
    private RadioButton aberto;

    @FXML
    private ToggleGroup ativo;

    @FXML
    private Button cancelar;

    @FXML
    private ListView<Categoria> categorias;

    @FXML
    private Button desce;

    @FXML
    private RadioButton fechado;

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

    public FormularioController() {
        this.formularioBusiness = new FormularioBusiness();
    }

    @Override
    void initialize() {
        assert aberto != null : "fx:id=\"aberto\" was not injected: check your FXML file 'formulario.fxml'.";
        assert ativo != null : "fx:id=\"ativo\" was not injected: check your FXML file 'formulario.fxml'.";
        assert cancelar != null : "fx:id=\"cancelar\" was not injected: check your FXML file 'formulario.fxml'.";
        assert categorias != null : "fx:id=\"categorias\" was not injected: check your FXML file 'formulario.fxml'.";
        assert desce != null : "fx:id=\"desce\" was not injected: check your FXML file 'formulario.fxml'.";
        assert fechado != null : "fx:id=\"fechado\" was not injected: check your FXML file 'formulario.fxml'.";
        assert inserir != null : "fx:id=\"inserir\" was not injected: check your FXML file 'formulario.fxml'.";
        assert retirar != null : "fx:id=\"retirar\" was not injected: check your FXML file 'formulario.fxml'.";
        assert salvar != null : "fx:id=\"salvar\" was not injected: check your FXML file 'formulario.fxml'.";
        assert sobe != null : "fx:id=\"sobe\" was not injected: check your FXML file 'formulario.fxml'.";
        assert titulo != null : "fx:id=\"titulo\" was not injected: check your FXML file 'formulario.fxml'.";

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                setWindow(titulo.getScene().getWindow());

                if (getParentController().model != null) {
                    // estado de edição
                    populateModel((Formulario) getParentController().model);
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
        if (categoriaIsSelected()) {
            // formularioBusiness.moveDown(categorias.getSelectionModel().getSelectedItem());
            refreshListView();
        }
    }

    @FXML
    void inserirAction(ActionEvent event) {
        super.start("categorias-listar.fxml", "Categorias", this);
        super.hide();
    }

    @FXML
    void retirarAction(ActionEvent event) {
        if (categoriaIsSelected()) {
            if ((Formulario) getParentController().model != null) {
                try {
                    this.formularioBusiness.remove((Formulario) getParentController().model, categorias.getSelectionModel().getSelectedItem());

                    Dialog.showInfo("Categoria", "Categoria removida com sucesso");
                } catch (Exception e) {
                    Dialog.showError("Categoria", "Ocorreu algum problema na remoçao da categoria.");
                }
            } else {
                models.remove(categorias.getSelectionModel().getSelectedItem());
                Dialog.showInfo("Categoria", "Categoria removida com sucesso");
            }
            
            refreshListView();
        }
    }

    @FXML
    void salvarAction(ActionEvent event) {
        Formulario formulario = assemblyRequest();

        if (formulario.isValid()) {
            try {
                this.formularioBusiness.save(formulario);
                getParentController().show();
                super.close();
                
                Dialog.showInfo("Formulário", "Formulário "
                        + (getParentController().model == null ? "cadastrado" : "alterado")
                        + " com sucesso");
            } catch (Exception e) {
                Dialog.showError("Formulário", "Ocorreu algum problema na persistência do formulário.");
            }
        }

        this.showErrors(formulario);
    }

    @FXML
    void sobeAction(ActionEvent event) {
        if (categoriaIsSelected()) {
            // formularioBusiness.moveUp(categorias.getSelectionModel().getSelectedItem());
            refreshListView();
        }
    }

    /**
     * Método para verificar se alguma categoria está selecionada
     *
     * @return boolean
     */
    private boolean categoriaIsSelected() {
        return categorias.getSelectionModel().getSelectedItem() != null;
    }

    /**
     * Método para popular campos quando o formulário for para edição
     *
     * @param formulario
     */
    private void populateModel(Formulario formulario) {
        model = formulario;
        models = formulario.getCategorias();

        titulo.setText(formulario.getTitulo());
        aberto.setSelected(formulario.isAberto());
        fechado.setSelected(!formulario.isAberto());
    }

    /**
     * Método para popular lista de categorias
     *
     */
    @SuppressWarnings("unchecked")
    private void populateListView() {
        if (models != null) {
            categorias.setItems(FXCollections.observableArrayList(models));
        }
        
        onShowRefreshListView();
        displayCategoriaTituloOnListView();
    }

    /**
     * Método para adicionar um Listener de onShowing. Quando exibir a tela,
     * atualiza a lista de categorias
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
     * Método para atualizar lista de categorias
     *
     */
    @SuppressWarnings("unchecked")
    private void refreshListView() {
        categorias.setItems(null);
        
        if (getParentController().model != null) {
            try {
                Formulario formulario = this.formularioBusiness.find(getParentController().model.getId());
                this.models = formulario.getCategorias();
                categorias.setItems(FXCollections.observableArrayList(this.models));
            } catch (Exception e) {
                Dialog.showError("Formulário", "Ocorreu algum problema na recuperação das categorias.");
            }    
        } else {
            categorias.setItems(FXCollections.observableArrayList(models));
        }
        
    }

    /**
     * Método para exibição do título da categoria na ListView
     *
     */
    private void displayCategoriaTituloOnListView() {
        categorias.setCellFactory(new Callback<ListView<Categoria>, ListCell<Categoria>>() {
            @Override
            public ListCell<Categoria> call(ListView<Categoria> categoria) {

                ListCell<Categoria> cells = new ListCell<Categoria>() {
                    @Override
                    protected void updateItem(Categoria categoria, boolean bool) {
                        super.updateItem(categoria, bool);
                        if (categoria != null) {
                            setText(categoria.getTitulo());
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
     * @return Formulario
     */
    @SuppressWarnings("unchecked")
    private Formulario assemblyRequest() {
        Formulario formulario;

        if (getParentController().model != null) {
            formulario = (Formulario) getParentController().model;
        } else {
            formulario = new Formulario();
            formulario.setData(new Date());
        }

        formulario.setTitulo(titulo.getText());
        formulario.setAberto(ativo.getSelectedToggle() == aberto ? true : false);
        formulario.setStatus(true);

        formulario.setCategorias(models);

        return formulario;
    }

    /**
     * Método para colorir borda de campos inválidos
     *
     * @param Formulario formulario
     */
    private void showErrors(Formulario formulario) {
        titulo.setStyle(super.getClearStyle());

        Iterator<String> iterator = formulario.createErrorIterator();
        while (iterator.hasNext()) {
            switch (iterator.next()) {
                case "titulo":
                    titulo.setStyle(super.getErrorStyle());
                    break;
            }
        }
    }

}
