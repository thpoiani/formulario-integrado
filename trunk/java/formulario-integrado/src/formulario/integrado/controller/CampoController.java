package formulario.integrado.controller;

import formulario.integrado.business.CampoBusiness;
import formulario.integrado.business.GrupoBusiness;
import formulario.integrado.business.ICampoBusiness;
import formulario.integrado.business.IGrupoBusiness;
import formulario.integrado.business.ITipoBusiness;
import formulario.integrado.business.TipoBusiness;
import formulario.integrado.model.Campo;
import formulario.integrado.model.Categoria;
import formulario.integrado.model.Grupo;
import formulario.integrado.model.Tipo;
import formulario.integrado.vendor.Dialog;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.WindowEvent;
import javafx.util.Callback;

public class CampoController extends AbstractController {

    private AbstractController controller;
    
    private ICampoBusiness campoBusiness;
    
    private ITipoBusiness tipoBusiness;
    
    private IGrupoBusiness grupoBusiness;
    
    private ObservableList<Grupo> dados = FXCollections.observableArrayList();
    
    private ObservableList<Tipo> tipos = FXCollections.observableArrayList();
    
    @FXML
    private Button cancelar;

    @FXML
    private Button editar;

    @FXML
    private Pane grupoPane;

    @FXML
    private Button inserir;

    @FXML
    private TextField maxlength;

    @FXML
    private RadioButton multiplaEscolha;

    @FXML
    private ToggleGroup radio;

    @FXML
    private TextField regex;

    @FXML
    private Button remover;

    @FXML
    private Button salvar;
    
    @FXML
    private TableView<Grupo> tabela;
    
    @FXML
    private TableColumn<Grupo, String> tabelaTitulo;
    
    @FXML
    private RadioButton textoAberto;

    @FXML
    private Pane textoPane;
    
    @FXML
    private ComboBox<Tipo> tipo;
    
    @FXML
    private TextField titulo;
    
    @FXML
    private RadioButton unicaEscolha;

    public CampoController() {
        this.campoBusiness = new CampoBusiness();
        this.tipoBusiness = new TipoBusiness();
        this.grupoBusiness = new GrupoBusiness();
    }

    @Override
    void initialize() {
        assert cancelar != null : "fx:id=\"cancelar\" was not injected: check your FXML file 'campo.fxml'.";
        assert editar != null : "fx:id=\"editar\" was not injected: check your FXML file 'campo.fxml'.";
        assert grupoPane != null : "fx:id=\"grupoPane\" was not injected: check your FXML file 'campo.fxml'.";
        assert inserir != null : "fx:id=\"inserir\" was not injected: check your FXML file 'campo.fxml'.";
        assert maxlength != null : "fx:id=\"maxlength\" was not injected: check your FXML file 'campo.fxml'.";
        assert multiplaEscolha != null : "fx:id=\"multiplaEscolha\" was not injected: check your FXML file 'campo.fxml'.";
        assert radio != null : "fx:id=\"radio\" was not injected: check your FXML file 'campo.fxml'.";
        assert regex != null : "fx:id=\"regex\" was not injected: check your FXML file 'campo.fxml'.";
        assert remover != null : "fx:id=\"remover\" was not injected: check your FXML file 'campo.fxml'.";
        assert salvar != null : "fx:id=\"salvar\" was not injected: check your FXML file 'campo.fxml'.";
        assert tabela != null : "fx:id=\"tabela\" was not injected: check your FXML file 'campo.fxml'.";
        assert tabelaTitulo != null : "fx:id=\"tabelaTitulo\" was not injected: check your FXML file 'campo.fxml'.";
        assert textoAberto != null : "fx:id=\"textoAberto\" was not injected: check your FXML file 'campo.fxml'.";
        assert textoPane != null : "fx:id=\"textoPane\" was not injected: check your FXML file 'campo.fxml'.";
        assert tipo != null : "fx:id=\"tipo\" was not injected: check your FXML file 'campo.fxml'.";
        assert titulo != null : "fx:id=\"titulo\" was not injected: check your FXML file 'campo.fxml'.";
        assert unicaEscolha != null : "fx:id=\"unicaEscolha\" was not injected: check your FXML file 'campo.fxml'.";

        populateComboBox();

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                setWindow(salvar.getScene().getWindow());
                
                if (getParentController().model != null && getParentController().model instanceof Campo) {
                    // estado de edição
                    populateModel((Campo) getParentController().model);
                } else {
                    models = new ArrayList<>();
                }
                
                populateTableView();
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
        if (grupoPane.isVisible() && grupoIsSelected()) {
            this.model = tabela.getSelectionModel().getSelectedItem();
            super.start("grupo.fxml", "Grupo", this);
            super.hide();
        }
    }
    
    @FXML
    void inserirAction(ActionEvent event) {
        if (grupoPane.isVisible()) {
            if (getParentController().model != null) {
                this.model = getParentController().model;
            } else {
                this.model = null;
            }

            super.start("grupo.fxml", "Grupo", this);
            super.hide();
        }
    }

    @FXML
    void multiplaEscolhaAction(ActionEvent event) {
        if (multiplaEscolha.isSelected()) {
            setPaneVisible(false, true);
        }
    }
    
    @FXML
    void removerAction(ActionEvent event) {
        if (grupoPane.isVisible() && grupoIsSelected()) {
            if (getParentController().model != null) {
                try {
                    this.grupoBusiness.remove(tabela.getSelectionModel().getSelectedItem());                    
                    Dialog.showInfo("Campo", "Grupo removido com sucesso");
                } catch (Exception e) {
                    Dialog.showError("Campo", "Ocorreu algum problema na remoção do grupo.");
                }
            } else {
                models.remove(tabela.getSelectionModel().getSelectedItem());
                Dialog.showInfo("Categoria", "Campo removido com sucesso");
            }
            
            refreshTableView();
        }
    }
    
    @FXML
    @SuppressWarnings("unchecked")
    void salvarAction(ActionEvent event) {
        Campo campo = assemblyRequest();

        if (campo.isValid()) {
            if (getParentController().model != null && getParentController().model instanceof Campo) {
                if (((Campo) getParentController().model).getCategoriaId() > 0) {
                    try {
                        this.campoBusiness.save(campo);
                    } catch (Exception e) {
                        Dialog.showError("Categoria", "Ocorreu algum problema na persistência do campo.");
                    }
                }
            } else {
                if (getParentController().model == null) {
                    getParentController().models.add(campo);
                } else if (getParentController().model instanceof Categoria) {
                    try {
                        this.campoBusiness.save(campo);
                    } catch (Exception e) {
                        Dialog.showError("Categoria", "Ocorreu algum problema na persistência do campo.");
                    }
                }
            }
            
            getParentController().show();
            super.close();

            Dialog.showInfo("Campo", "Campo "
                    + (getParentController().model == null ? "cadastrado" : "alterado")
                    + " com sucesso");
        }

        this.showErrors(campo);
    }

    @FXML
    void textoAbertoAction(ActionEvent event) {
        if (textoAberto.isSelected()) {
            setPaneVisible(true, false);
        }
    }
    
    @FXML
    void unicaEscolhaAction(ActionEvent event) {
        if (unicaEscolha.isSelected()) {
            setPaneVisible(false, true);
        }
    }
    
    /**
     * Método para verificar se algum grupo está selecionada
     *
     * @return boolean
     */
    private boolean grupoIsSelected() {
        return tabela.getSelectionModel().getSelectedItem() != null;
    }

    /**
     * Método para atribuir os dados exibidos na combobox
     * 
     */
    private void populateComboBox() {
        try {
            this.tipos = FXCollections.observableArrayList(tipoBusiness.show());
            tipo.setItems(this.tipos);
            displayTipoDescricaoOnComboBox();
            tipo.getSelectionModel().selectFirst();
        } catch (SQLException ex) {
            Dialog.showError("Campo", "Ocorreu algum problema na recuperação dos tipos.");
        }
    }

    /**
     * Método para exibição da descrição do tipo na ComboBox
     *
     */
    private void displayTipoDescricaoOnComboBox() {
        tipo.setButtonCell(new ListCell<Tipo>() {
            @Override
            protected void updateItem(Tipo tipo, boolean bool) {
                super.updateItem(tipo, bool);
                if (tipo != null) {
                    setText(tipo.getDescricao());
                }
            }
        });
        
        tipo.setCellFactory(new Callback<ListView<Tipo>, ListCell<Tipo>>() {
            @Override
            public ListCell<Tipo> call(ListView<Tipo> tipo) {

                ListCell<Tipo> cells = new ListCell<Tipo>() {
                    @Override
                    protected void updateItem(Tipo tipo, boolean bool) {
                        super.updateItem(tipo, bool);
                        if (tipo != null) {
                            setText(tipo.getDescricao());
                        }
                    }
                };

                return cells;
            }
        });
    }

    /**
     * Método para atribuir os dados exibidos na tabela
     *
     */
    @SuppressWarnings("unchecked")
    private void populateTableView() {
        tabelaTitulo.setCellValueFactory(new PropertyValueFactory<Grupo, String>("titulo"));

        if (this.models != null) {
            this.dados = FXCollections.observableArrayList(this.models);
            tabela.setItems(this.dados);
        }
    }
    
    
    /**
     * Método para popular combobox e selecionar Pane visível, 
     * de acordo com o tipo
     * 
     * @param Tipo tipo 
     */
    private void populateByTipo(Tipo tipo) {
        selectRadioButtonByTipo(tipo);

        if (this.tipo.getItems().indexOf(tipo) != -1) {
            this.tipo.setValue(this.tipo.getItems().get(this.tipo.getItems().indexOf(tipo)));
        }
    }

    /**
     * Método para popular campos quando o Campo for para edição
     *
     * @param campo
     */
    private void populateModel(Campo campo) {
        models = campo.getGrupos();

        titulo.setText(campo.getTitulo());
        
        if (campo.getTipoModel() != null) {
            populateByTipo(campo.getTipoModel());
        } else {
            try {
                populateByTipo(this.tipoBusiness.find(campo.getTipoId()));
            } catch (SQLException ex) {
                Dialog.showError("Campo", "Ocorreu algum problema na recuperação dos tipos.");
            }
        }

        maxlength.setText(String.valueOf(campo.getMaxlength()));
        regex.setText(campo.getRegex());
    }

    /**
     * Método para verificar a qual tipo esse Campo pertence
     *
     * @param String tipo
     */
    private void selectRadioButtonByTipo(Tipo tipo) {
        switch (tipo.getDescricao().toLowerCase()) {
            case "check":
                setRadioSelected(false, true, false);
                setPaneVisible(false, true);
                break;

            case "radio":
                setRadioSelected(false, false, true);
                setPaneVisible(false, true);
                break;

            default:
                setRadioSelected(true, false, false);
                setPaneVisible(true, false);
        }
    }

    /**
     * Método para selecionar radio button
     *
     * @param boolean isTextoAberto
     * @param boolean isMultiplaEscolha
     * @param boolean isUnicaEscolha
     */
    private void setRadioSelected(boolean isTextoAberto, boolean isMultiplaEscolha, boolean isUnicaEscolha) {
        textoAberto.setSelected(isTextoAberto);
        unicaEscolha.setSelected(isUnicaEscolha);
        multiplaEscolha.setSelected(isMultiplaEscolha);
    }
    
    /**
     * Método para retonrar se o texto aberto está selecionado
     * 
     * return boolean
     */
    private boolean textoIsSelected() {
        return textoAberto.isSelected();
    }
    
    /**
     * Método para retonrar se a unicaEscolha está selecionada
     * 
     * return boolean
     */
    private boolean unicaEscolhaIsSelected() {
        return unicaEscolha.isSelected();
    }
    
    /**
     * Método para retonrar se a multiplaEscolha está selecionada
     * 
     * return boolean
     */
    private boolean multiplaEscolhaIsSelected() {
        return multiplaEscolha.isSelected();
    }

    /**
     * Método para tornar visível Pane específico
     *
     * @param isTextoPane
     * @param isGrupoPane
     */
    private void setPaneVisible(boolean isTextoPane, boolean isGrupoPane) {
        textoPane.setVisible(isTextoPane);
        grupoPane.setVisible(isGrupoPane);
        editar.setVisible(isGrupoPane);
        inserir.setVisible(isGrupoPane);
        remover.setVisible(isGrupoPane);
    }

    /**
     * Método para recuperar dados inseridos pelo usuário
     *
     * @return Campo
     */
    @SuppressWarnings("unchecked")
    private Campo assemblyRequest() {
        Campo campo;

        if (getParentController().model != null && getParentController().model instanceof Campo) {
            campo = (Campo) getParentController().model;
        } else {
            campo = new Campo();
            campo.setData(new Date());
            
            if (getParentController().model instanceof Categoria) {
                campo.setCategoria((Categoria) getParentController().model);
            }
        }

        campo.setTitulo(titulo.getText());
        campo.setStatus(true);
        
        if (textoIsSelected()) {
            campo.setRegex(regex.getText());
            
            if (maxlength.getText().length() > 0) {
                try {
                    campo.setMaxlength(Integer.parseInt(maxlength.getText()));
                } catch (Exception e) {
                    campo.addErrors("maxlength");
                }
            }
            
            campo.setTipo(tipo.getValue());
            campo.setTipoId(tipo.getValue().getId());
            
            campo.setGrupos(null);
        } else {
            campo.setGrupos(models);
            
            try {
                Tipo tipo;
                if (unicaEscolhaIsSelected()) {
                    tipo = this.tipoBusiness.getRadio();
                    campo.setTipo(tipo);
                    campo.setTipoId(tipo.getId());
                } else if (multiplaEscolhaIsSelected()) {
                    tipo = this.tipoBusiness.getCheck();
                    campo.setTipo(tipo);
                    campo.setTipoId(tipo.getId());
                }
            } catch (SQLException ex) {
                Dialog.showError("Campo", "Ocorreu algum problema na recuperação dos tipos.");
            }
            
            campo.setMaxlength(0);
            campo.setRegex(null);
        }
        
        return campo;
    }

    /**
     * Método para colorir borda de campos inválidos
     *
     * @param Campo campo
     */
    private void showErrors(Campo campo) {
        titulo.setStyle(super.getClearStyle());
        maxlength.setStyle(super.getClearStyle());

        Iterator<String> iterator = campo.createErrorIterator();
        while (iterator.hasNext()) {
            switch (iterator.next()) {
                case "titulo":
                    titulo.setStyle(super.getErrorStyle());
                    break;
                    
                case "maxlength":
                    maxlength.setStyle(super.getErrorStyle());
                    break;
            }
        }
    }
    
    /**
     * Método para adicionar um Listener de onShowing. Quando exibir a tela,
     * atualiza a lista de grupos
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
        tabela.setItems(null);
        
        if (models != null) {
            if (getParentController().model != null) {
                try {
                    this.models = this.grupoBusiness.show((Campo)getParentController().model);
                    tabela.setItems(FXCollections.observableArrayList(this.models));
                } catch (SQLException ex) {
                    Dialog.showError("Campo", "Ocorreu algum problema na recuperação dos grupos.");
                }
            } else {
                tabela.setItems(FXCollections.observableArrayList(models));
                tabela.getSortOrder();
            }
        }
    }

}
