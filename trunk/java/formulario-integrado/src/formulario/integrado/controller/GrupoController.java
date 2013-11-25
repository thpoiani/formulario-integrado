package formulario.integrado.controller;

import formulario.integrado.business.GrupoBusiness;
import formulario.integrado.business.IGrupoBusiness;
import formulario.integrado.model.Campo;
import formulario.integrado.model.Grupo;
import formulario.integrado.vendor.Dialog;
import java.util.Date;
import java.util.Iterator;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class GrupoController extends AbstractController {
    
    private AbstractController controller;
    
    private IGrupoBusiness grupoBusiness;
    
    @FXML
    private Button cancelar;

    @FXML
    private Button salvar;

    @FXML
    private TextField titulo;

    public GrupoController() {
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
                
                if (getParentController().model != null) {
                    // estado de edição
                    if (getParentController().model instanceof Grupo) {
                        populateModel((Grupo) getParentController().model);
                    }
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
    @SuppressWarnings("unchecked")
    void salvarAction(ActionEvent event) {
        Grupo grupo = assemblyRequest();
        
        if (grupo.isValid()) {
            if (getParentController().model != null && getParentController().model instanceof Grupo) {
                if (((Grupo) getParentController().model).getCampoId() > 0) {
                    try {
                        this.grupoBusiness.save(grupo);
                    } catch (Exception e) {
                        Dialog.showError("Grupo", "Ocorreu algum problema na persistência do grupo.");
                    }
                }
            } else {
                if (getParentController().model == null) {
                    getParentController().models.add(grupo);
                } else if (getParentController().model instanceof Campo) {
                    try {
                        this.grupoBusiness.save(grupo);
                    } catch (Exception e) {
                        Dialog.showError("Grupo", "Ocorreu algum problema na persistência do grupo.");
                    }
                }
            }
            
            getParentController().show();
            super.close();

            Dialog.showInfo("Grupo", "Grupo "
                        + (getParentController().model == null ? "cadastrado" : "alterado")
                        + " com sucesso");
        }
        
        this.showErrors(grupo);
        
    }
    
    /**
     * Método para popular campos quando o Grupo for para edição
     *
     * @param Grupo grupo
     */
    private void populateModel(Grupo grupo) {
        titulo.setText(grupo.getTitulo());
    }

    /**
     * Método para recuperar dados inseridos pelo usuário
     *
     * @return Grupo
     */
    private Grupo assemblyRequest() {
        Grupo grupo;
        
        if (getParentController().model != null) {
            grupo = (Grupo) getParentController().model;
        } else {
            grupo = new Grupo();
            grupo.setData(new Date());
        }
        
        grupo.setTitulo(titulo.getText());
        grupo.setStatus(true);
        
        if (getParentController().model instanceof Campo) {
            grupo.setCampoId(getParentController().model.getId());
        }
        
        return grupo;
    }
    
    /**
     * Método para colorir borda de campos inválidos
     *
     * @param Grupo grupo
     */
    private void showErrors(Grupo grupo) {
        titulo.setStyle(super.getClearStyle());

        Iterator<String> iterator = grupo.createErrorIterator();
        while (iterator.hasNext()) {
            switch (iterator.next()) {
                case "titulo":
                    titulo.setStyle(super.getErrorStyle());
                    break;
            }
        }
    }
}
