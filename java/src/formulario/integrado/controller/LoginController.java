package formulario.integrado.controller;

import formulario.integrado.business.ILoginBusiness;
import formulario.integrado.business.LoginBusiness;
import formulario.integrado.model.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController extends Controller {

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
            ILoginBusiness loginBusiness = new LoginBusiness();

            if (loginBusiness.isAuthenticated(login)) {
                super.start("principal.fxml", "Principal");
                super.close(this.login.getScene().getWindow());
            }
        }

        this.showErrors(login);
    }

    @FXML
    void initialize() {
        assert login != null : "fx:id=\"login\" was not injected: check your FXML file 'login.fxml'.";
        assert prontuario != null : "fx:id=\"prontuario\" was not injected: check your FXML file 'login.fxml'.";
        assert senha != null : "fx:id=\"senha\" was not injected: check your FXML file 'login.fxml'.";
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
     * @param Login login
     */
    private void showErrors(Login login) {
        prontuario.setStyle("-fx-border-color: null;");
        senha.setStyle("-fx-border-color: null;");

        for (String error : login.getErrors()) {
            switch (error) {
                case "prontuario":
                    prontuario.setStyle("-fx-border-color: red;");
                    break;

                case "senha":
                    senha.setStyle("-fx-border-color: red;");
                    break;
            }
        }
    }
}
