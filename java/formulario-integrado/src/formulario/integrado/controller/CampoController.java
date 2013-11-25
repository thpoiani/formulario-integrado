package formulario.integrado.controller;

import formulario.integrado.business.CampoBusiness;
import formulario.integrado.business.ICampoBusiness;
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
import javafx.util.Callback;

public class CampoController extends AbstractController {

    private AbstractController controller;
    
    private ICampoBusiness campoBusiness;
    
    private ITipoBusiness tipoBusiness;
    
    private ObservableList<Grupo> dados = FXCollections.observableArrayList();
    
    private ObservableList<Tipo> tipos = FXCollections.observableArrayList();
    
    @FXML
    private RadioButton unicaEscolha;
    
    @FXML
    private Button cancelar;
    
    @FXML
    private Button editar;
    
    @FXML
    private TextField maxlength;
    
    @FXML
    private RadioButton multiplaEscolha;
    
    @FXML
    private Pane multiplaEscolhaPane;
    
    @FXML
    private ToggleGroup radio;
    
    @FXML
    private TextField regex;
    
    @FXML
    private Button salvar;
    
    @FXML
    private TableView<Grupo> tabela;
    
    @FXML
    private TableColumn<Grupo, Integer> tabelaId;
    
    @FXML
    private TableColumn<Grupo, String> tabelaTipo;
    
    @FXML
    private TableColumn<Grupo, String> tabelaTitulo;
    
    @FXML
    private RadioButton textoAberto;
    
    @FXML
    private Pane textoAbertoPane;
    
    @FXML
    private ComboBox<Tipo> tipo;
    
    @FXML
    private TextField titulo;

    public CampoController() {
        this.campoBusiness = new CampoBusiness();
        this.tipoBusiness = new TipoBusiness();
    }

    @Override
    void initialize() {
        assert unicaEscolha != null : "fx:id=\"UnicaEscolha\" was not injected: check your FXML file 'campo.fxml'.";
        assert cancelar != null : "fx:id=\"cancelar\" was not injected: check your FXML file 'campo.fxml'.";
        assert editar != null : "fx:id=\"editar\" was not injected: check your FXML file 'campo.fxml'.";
        assert maxlength != null : "fx:id=\"maxlength\" was not injected: check your FXML file 'campo.fxml'.";
        assert multiplaEscolha != null : "fx:id=\"multiplaEscolha\" was not injected: check your FXML file 'campo.fxml'.";
        assert multiplaEscolhaPane != null : "fx:id=\"multiplaEscolhaPane\" was not injected: check your FXML file 'campo.fxml'.";
        assert radio != null : "fx:id=\"radio\" was not injected: check your FXML file 'campo.fxml'.";
        assert regex != null : "fx:id=\"regex\" was not injected: check your FXML file 'campo.fxml'.";
        assert salvar != null : "fx:id=\"salvar\" was not injected: check your FXML file 'campo.fxml'.";
        assert tabela != null : "fx:id=\"tabela\" was not injected: check your FXML file 'campo.fxml'.";
        assert tabelaId != null : "fx:id=\"tabelaId\" was not injected: check your FXML file 'campo.fxml'.";
        assert tabelaTipo != null : "fx:id=\"tabelaTipo\" was not injected: check your FXML file 'campo.fxml'.";
        assert tabelaTitulo != null : "fx:id=\"tabelaTitulo\" was not injected: check your FXML file 'campo.fxml'.";
        assert textoAberto != null : "fx:id=\"textoAberto\" was not injected: check your FXML file 'campo.fxml'.";
        assert textoAbertoPane != null : "fx:id=\"textoAbertoPane\" was not injected: check your FXML file 'campo.fxml'.";
        assert tipo != null : "fx:id=\"tipo\" was not injected: check your FXML file 'campo.fxml'.";
        assert titulo != null : "fx:id=\"titulo\" was not injected: check your FXML file 'campo.fxml'.";

        populateTableView();
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
    void unicaEscolhaAction(ActionEvent event) {
        if (unicaEscolha.isSelected()) {
            super.start("grupo.fxml", "Grupo", this);
            setPaneVisible(false, true, true);
            super.hide();
        }
    }

    @FXML
    void cancelarAction(ActionEvent event) {
        getParentController().show();
        super.close();
    }

    @FXML
    void editarAction(ActionEvent event) {
        if (multiplaEscolhaPane.isVisible()) {
            super.start("grupo.fxml", "Grupo", this);
            super.hide();
        }
    }

    @FXML
    void multiplaEscolhaAction(ActionEvent event) {
        if (multiplaEscolha.isSelected()) {
            super.start("grupo.fxml", "Grupo", this);
            setPaneVisible(false, true, true);
            super.hide();
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
                        Dialog.showError("Categoria", "Ocorreu algum problema na inserção da campo.");
                    }
                }
            } else {
                if (getParentController().model == null) {
                    getParentController().models.add(campo);
                } else if (getParentController().model instanceof Categoria) {
                    try {
                        this.campoBusiness.save(campo);
                    } catch (Exception e) {
                        Dialog.showError("Categoria", "Ocorreu algum problema na inserção da campo.");
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
            setPaneVisible(true, false, false);
        }
    }

    /**
     * Método para atribuir os dados exibidos na combobox
     * 
     */
    private void populateComboBox() {
        try {
            this.tipos = FXCollections.observableArrayList(tipoBusiness.show());
            this.tipos.remove(new Tipo("Radio"));
            this.tipos.remove(new Tipo("Check"));
            
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
        tabelaId.setCellValueFactory(new PropertyValueFactory<Grupo, Integer>("id"));
        tabelaTipo.setCellValueFactory(new PropertyValueFactory<Grupo, String>("tipo"));
        tabelaTitulo.setCellValueFactory(new PropertyValueFactory<Grupo, String>("titulo"));

        if (this.models != null) {
            this.dados = FXCollections.observableArrayList(this.models);
            tabela.setItems(this.dados);
        }

//         REMOVER EM PRODUÇÃO
        // fakeData();
    }

    /**
     * Método para popular campos quando o Campo for para edição
     *
     * @param campo
     */
    private void populateModel(Campo campo) {
        models = campo.getGrupos();

        titulo.setText(campo.getTitulo());
        
        try {
            Tipo tipoModel = this.tipoBusiness.find(campo.getTipoId());
            selectRadioButtonByTipo(tipoModel);   
            tipo.setValue(tipo.getItems().get(tipo.getItems().indexOf(tipoModel)));
        } catch (SQLException ex) {
            Dialog.showError("Campo", "Ocorreu algum problema na recuperação dos tipos.");
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
                setPaneVisible(false, true, true);
                break;

            case "radio":
                setRadioSelected(false, false, true);
                setPaneVisible(false, true, true);
                break;

            default:
                setRadioSelected(true, false, false);
                setPaneVisible(true, false, false);
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
        unicaEscolha.setSelected(isMultiplaEscolha);
        multiplaEscolha.setSelected(isUnicaEscolha);
    }

    /**
     * Método para tornar visível Pane específico
     *
     * @param isTextAbertoPane
     * @param isMultiplaEscolhaPane
     * @param isEditarButton
     */
    private void setPaneVisible(boolean isTextAbertoPane, boolean isMultiplaEscolhaPane, boolean isEditarButton) {
        textoAbertoPane.setVisible(isTextAbertoPane);
        multiplaEscolhaPane.setVisible(isMultiplaEscolhaPane);
        editar.setVisible(isEditarButton);
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
        
        campo.setTipo(tipo.getValue());
        campo.setTipoId(tipo.getValue().getId());
        
        if (!campo.getTipo().toLowerCase().equals("check") || !campo.getTipo().toLowerCase().equals("radio")) {
            campo.setRegex(regex.getText());
            
            if (maxlength.getText().length() > 0) {
                try {
                    campo.setMaxlength(Integer.parseInt(maxlength.getText()));
                } catch (Exception e) {
                    campo.addErrors("maxlength");
                }
            }
        } else {
            campo.setGrupos(models);    
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

}
