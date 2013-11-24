package formulario.integrado.controller;

import formulario.integrado.business.GrupoBusiness;
import formulario.integrado.business.IGrupoBusiness;
import formulario.integrado.business.ITipoBusiness;
import formulario.integrado.business.TipoBusiness;
import formulario.integrado.model.Grupo;
import formulario.integrado.model.Tipo;
import formulario.integrado.vendor.Dialog;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;

public class GrupoController extends AbstractController {
    
    private AbstractController controller;
    
    private IGrupoBusiness grupoBusiness;
    
    private ITipoBusiness tipoBusiness;
    
    private ObservableList<Tipo> tipos = FXCollections.observableArrayList();
    
    @FXML
    private Button cancelar;

    @FXML
    private Button salvar;

    @FXML
    private ComboBox<Tipo> tipo1;

    @FXML
    private ComboBox<Tipo> tipo2;

    @FXML
    private ComboBox<Tipo> tipo3;

    @FXML
    private ComboBox<Tipo> tipo4;

    @FXML
    private ComboBox<Tipo> tipo5;

    @FXML
    private ComboBox<Tipo> tipo6;

    @FXML
    private TextField titulo1;

    @FXML
    private TextField titulo2;

    @FXML
    private TextField titulo3;

    @FXML
    private TextField titulo4;

    @FXML
    private TextField titulo5;

    @FXML
    private TextField titulo6;
    
    public GrupoController() {
        this.tipoBusiness = new TipoBusiness();
        this.grupoBusiness = new GrupoBusiness();
    }

    @Override
    void initialize() {
        assert cancelar != null : "fx:id=\"cancelar\" was not injected: check your FXML file 'grupo.fxml'.";
        assert salvar != null : "fx:id=\"salvar\" was not injected: check your FXML file 'grupo.fxml'.";
        assert tipo1 != null : "fx:id=\"tipo1\" was not injected: check your FXML file 'grupo.fxml'.";
        assert tipo2 != null : "fx:id=\"tipo2\" was not injected: check your FXML file 'grupo.fxml'.";
        assert tipo3 != null : "fx:id=\"tipo3\" was not injected: check your FXML file 'grupo.fxml'.";
        assert tipo4 != null : "fx:id=\"tipo4\" was not injected: check your FXML file 'grupo.fxml'.";
        assert tipo5 != null : "fx:id=\"tipo5\" was not injected: check your FXML file 'grupo.fxml'.";
        assert tipo6 != null : "fx:id=\"tipo6\" was not injected: check your FXML file 'grupo.fxml'.";
        assert titulo1 != null : "fx:id=\"titulo1\" was not injected: check your FXML file 'grupo.fxml'.";
        assert titulo2 != null : "fx:id=\"titulo2\" was not injected: check your FXML file 'grupo.fxml'.";
        assert titulo3 != null : "fx:id=\"titulo3\" was not injected: check your FXML file 'grupo.fxml'.";
        assert titulo4 != null : "fx:id=\"titulo4\" was not injected: check your FXML file 'grupo.fxml'.";
        assert titulo5 != null : "fx:id=\"titulo5\" was not injected: check your FXML file 'grupo.fxml'.";
        assert titulo6 != null : "fx:id=\"titulo6\" was not injected: check your FXML file 'grupo.fxml'.";

        populateComboBox();
        
        Platform.runLater(new Runnable() {
            @Override
            @SuppressWarnings("unchecked")
            public void run() {
                setWindow(salvar.getScene().getWindow());
                
                if (getParentController().models != null) {
                    // estado de edição
                    populateModel(getParentController().models);
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
    void cancelarAction(ActionEvent event) {
        getParentController().show();
        super.close();
    }

    @FXML
    void salvarAction(ActionEvent event) {
        Grupo grupo1 = assemblyRequest(tipo1, titulo1, 0);
        Grupo grupo2 = assemblyRequest(tipo2, titulo2, 1);
        Grupo grupo3 = assemblyRequest(tipo3, titulo3, 2);
        Grupo grupo4 = assemblyRequest(tipo4, titulo4, 3);
        Grupo grupo5 = assemblyRequest(tipo5, titulo5, 4);
        Grupo grupo6 = assemblyRequest(tipo6, titulo6, 5);
        
        ArrayList<Grupo> grupos = new ArrayList<>();
        grupos.add(grupo1);
        grupos.add(grupo2);
        grupos.add(grupo3);
        grupos.add(grupo4);
        grupos.add(grupo5);
        grupos.add(grupo6);
        
        
        try {
//            this.grupoBusiness.save(grupos);

            getParentController().models.add(grupos);
            getParentController().show();
            super.close();

            Dialog.showInfo("Grupo", "Grupo "
                    + (getParentController().model == null ? "cadastrado" : "alterado")
                    + " com sucesso");
        } catch (Exception e) {
            Dialog.showError("Grupo", "Ocorreu algum problema na persistência do grupo.");
        }
    }
    
    /**
     * Método para atribuir os dados exibidos na combobox
     * 
     */
    private void populateComboBox() {
//        this.tipos = FXCollections.observableArrayList(tipoBusiness.show());
//        tipo1.setItems(this.tipos);
//        tipo2.setItems(this.tipos);
//        tipo3.setItems(this.tipos);
//        tipo4.setItems(this.tipos);
//        tipo5.setItems(this.tipos);
//        tipo6.setItems(this.tipos);

//        REMOVER EM PRODUCAO
        fakeData();
        
        displayTipoDescricaoOnComboBox(tipo1);
        displayTipoDescricaoOnComboBox(tipo2);
        displayTipoDescricaoOnComboBox(tipo3);
        displayTipoDescricaoOnComboBox(tipo4);
        displayTipoDescricaoOnComboBox(tipo5);
        displayTipoDescricaoOnComboBox(tipo6);
    }
    
    /**
     * Método para exibição da descrição do tipo na ComboBox
     *
     */
    private void displayTipoDescricaoOnComboBox(ComboBox<Tipo> tipo) {
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
        
        tipo.getSelectionModel().selectFirst();
    }
    
    @SuppressWarnings("unchecked")
    private void populateModel(List<Grupo> models) {
        
//        Iterator<Grupo> iterator = models.iterator();
//        
//        while(iterator.hasNext()) {
//            Grupo grupo = iterator.next();
//            titulo1.setText(grupo.getTitulo());
//            tipo1.setValue(grupo.getTipoModel());
//        }
        
        Grupo grupo = models.get(0);
        titulo1.setText(grupo.getTitulo());
        tipo1.setValue(grupo.getTipoModel());
        
        grupo = models.get(1);
        titulo2.setText(grupo.getTitulo());
        tipo2.setValue(grupo.getTipoModel());
        
        grupo = models.get(2);
        titulo3.setText(grupo.getTitulo());
        tipo3.setValue(grupo.getTipoModel());
        
        grupo = models.get(3);
        titulo4.setText(grupo.getTitulo());
        tipo4.setValue(grupo.getTipoModel());
        
        grupo = models.get(4);
        titulo5.setText(grupo.getTitulo());
        tipo5.setValue(grupo.getTipoModel());
        
        grupo = models.get(5);
        titulo6.setText(grupo.getTitulo());
        tipo6.setValue(grupo.getTipoModel());
    }
    
    /**
     * Método com dados fictícios para homologação
     *
     */
    private void fakeData() {
        Tipo texto = new Tipo();
        texto.setId(1);
        texto.setDescricao("Texto");

        Tipo inteiro = new Tipo();
        inteiro.setId(2);
        inteiro.setDescricao("Inteiro");
        
        Tipo data = new Tipo();
        data.setId(3);
        data.setDescricao("Data");

        ArrayList<Tipo> tipos = new ArrayList<>();
        tipos.add(texto);
        tipos.add(inteiro);
        tipos.add(data);

        this.tipos = FXCollections.observableArrayList(tipos);
        this.tipo1.setItems(this.tipos);
        this.tipo2.setItems(this.tipos);
        this.tipo3.setItems(this.tipos);
        this.tipo4.setItems(this.tipos);
        this.tipo5.setItems(this.tipos);
        this.tipo6.setItems(this.tipos);
    }

    private Grupo assemblyRequest(ComboBox<Tipo> tipo, TextField titulo, int index) {
        if (titulo.getText().length() == 0) {
            return null;
        }
        
        Grupo grupo;
        
        if (getParentController().models != null) {
            grupo = (Grupo) getParentController().models.get(index);
        } else {
            grupo = new Grupo();
            grupo.setData(new Date());
        }
        
        grupo.setTitulo(titulo.getText());
        grupo.setTipo(tipo.getValue());
        
        return grupo;
    }
}
