package formulario.integrado.controller;

import formulario.integrado.business.ILoginBusiness;
import formulario.integrado.business.LoginBusiness;
import formulario.integrado.vendor.Dialog;
import formulario.integrado.model.Login;
import java.util.Iterator;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController extends AbstractController {
    
    private ILoginBusiness loginBusiness;

    @FXML
    private Button login;
    
    @FXML
    private TextField prontuario;
    
    @FXML
    private PasswordField senha;

    @FXML
    void loginAction(ActionEvent event) {
        Login login = assemblyRequest();

        if (login.isValid()) {
//            if (this.loginBusiness.isAuthenticated(login)) {
            super.start("principal.fxml", "Principal");
            super.close();
//            } else {
//                Dialog.showError("Erro de autenticação", "Prontuário ou senha incorretos.");
//            }
        }

        this.showErrors(login);
    }
    
    @Override
    void initialize() {
        assert login != null : "fx:id=\"login\" was not injected: check your FXML file 'login.fxml'.";
        assert prontuario != null : "fx:id=\"prontuario\" was not injected: check your FXML file 'login.fxml'.";
        assert senha != null : "fx:id=\"senha\" was not injected: check your FXML file 'login.fxml'.";
        
        this.loginBusiness = new LoginBusiness();

        Platform.runLater(new Runnable() {
            @Override public void run() {
                setWindow(login.getScene().getWindow());
            }
        });
    }

    /**
     * Método para recuperar dados inseridos pelo usuário
     *
     * @return Login
     */
    private Login assemblyRequest() {
        Login login = new Login();

        login.setProntuario(this.prontuario.getText());
        login.setSenha(this.senha.getText());

        return login;
    }

    /**
     * Método para colorir borda de campos inválidos
     *
     * @param Login login
     */
    private void showErrors(Login login) {
        prontuario.setStyle(super.getClearStyle());
        senha.setStyle(super.getClearStyle());

        Iterator iterator = login.createErrorIterator();
        while (iterator.hasNext()) {
            switch ((String) iterator.next()) {
                case "prontuario":
                    prontuario.setStyle(super.getErrorStyle());
                    break;

                case "senha":
                    senha.setStyle(super.getErrorStyle());
                    break;
            }
        }

    }
}
