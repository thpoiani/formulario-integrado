package formulario.integrado.controller;

import formulario.integrado.business.GrupoBusiness;
import formulario.integrado.business.IGrupoBusiness;
import formulario.integrado.business.ITipoBusiness;
import formulario.integrado.business.TipoBusiness;
import formulario.integrado.model.Grupo;
import formulario.integrado.model.Tipo;
import formulario.integrado.vendor.Dialog;
import java.sql.SQLException;
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
    private TextField titulo;

    public GrupoController() {
        this.tipoBusiness = new TipoBusiness();
        this.grupoBusiness = new GrupoBusiness();
    }

    @Override
    void initialize() {
        assert cancelar != null : "fx:id=\"cancelar\" was not injected: check your FXML file 'grupo.fxml'.";
        assert salvar != null : "fx:id=\"salvar\" was not injected: check your FXML file 'grupo.fxml'.";
        assert titulo != null : "fx:id=\"titulo1\" was not injected: check your FXML file 'grupo.fxml'.";
        
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
        Grupo grupo = assemblyRequest();
        
        try {
//            this.grupoBusiness.save(grupo);

//            getParentController().models.add(grupos);
            getParentController().show();
            super.close();

            Dialog.showInfo("Grupo", "Grupo "
                    + (getParentController().model == null ? "cadastrado" : "alterado")
                    + " com sucesso");
        } catch (Exception e) {
            Dialog.showError("Grupo", "Ocorreu algum problema na persistência do grupo.");
        }
    }
    
    
    @SuppressWarnings("unchecked")
    private void populateModel(List<Grupo> models) {
//        Grupo grupo = models.get(0);
//        titulo.setText(grupo.getTitulo());
//        tipo1.setValue(grupo.getTipoModel());
    }

    private Grupo assemblyRequest() {
        Grupo grupo;
        
        if (getParentController().models != null) {
            grupo = (Grupo) getParentController().model;
        } else {
            grupo = new Grupo();
            grupo.setData(new Date());
        }
        
        grupo.setTitulo(titulo.getText());
        grupo.setStatus(true);
        
        return grupo;
    }
}
