package formulario.integrado.controller;

import formulario.integrado.business.FormularioBusiness;
import formulario.integrado.business.IFormularioBusiness;
import formulario.integrado.model.Categoria;
import formulario.integrado.model.Formulario;
import formulario.integrado.vendor.Dialog;
import java.util.Date;
import java.util.Iterator;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

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

    @FXML
    void cancelarAction(ActionEvent event) {
        getParentController().show();
        super.close();
    }

    @FXML
    void desceAction(ActionEvent event) {
    
    }

    @FXML
    void inserirAction(ActionEvent event) {
        super.start("categoria.fxml", "Categoria", this);
        super.hide();
    }

    @FXML
    void retirarAction(ActionEvent event) {
        
    }

    @FXML
    void salvarAction(ActionEvent event) {
        Formulario formulario = assemblyRequest();

        if (formulario.isValid()) {
            try {
                // this.formularioBusiness.add(formulario);
                getParentController().show();
                super.close();

                Dialog.showInfo("Formulário", "Formulário " + 
                        (getParentController().model == null ? "cadastrado" : "alterado") + 
                        " com sucesso");
            } catch (Exception e) {
                Dialog.showError("Formulário", "Ocorreu algum problema na persistência do formulário.");
            }
        }

        this.showErrors(formulario);
    }

    @FXML
    void sobeAction(ActionEvent event) {
    
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

        this.formularioBusiness = new FormularioBusiness();
        
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                setWindow(titulo.getScene().getWindow());
                
                // estado de edição
                if (getParentController().model != null) {
                    populate((Formulario) getParentController().model);
                }
                
            }
        });
    }
    
    /**
     * Método para popular campos quando o formulário for para edição
     * @param formulario 
     */
    private void populate(Formulario formulario) {
        titulo.setText(formulario.getTitulo());
        
        aberto.setSelected(formulario.isAberto());
        fechado.setSelected(!formulario.isAberto());
        
        // categorias
    }
    
    /**
     * Método para recuperar dados inseridos pelo usuário
     *
     * @return Formulario
     */
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
        
        // categorias
        
        return formulario;
    }
    
    /**
     * Método para colorir borda de campos inválidos
     *
     * @param Formulario formulario
     */
    private void showErrors(Formulario formulario ){
        titulo.setStyle(super.getClearStyle());

        Iterator iterator = formulario.createErrorIterator();
        while (iterator.hasNext()) {
            switch ((String) iterator.next()) {
                case "titulo":
                    titulo.setStyle(super.getErrorStyle());
                    break;
            }
        }
    }

    @Override
    public void addParentController(AbstractController controller) {
        this.controller = controller;
    }

    @Override
    public AbstractController getParentController() {
        return this.controller;
    }
}
