/**
 * Sample Skeleton for "login.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package formulario.integrado.controller;

import formulario.integrado.business.database.Database;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginController extends Controller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="login"
    private Button login; // Value injected by FXMLLoader

    @FXML // fx:id="prontuario"
    private TextField prontuario; // Value injected by FXMLLoader

    @FXML // fx:id="senha"
    private PasswordField senha; // Value injected by FXMLLoader
    
    private java.sql.Connection connection;

    // Handler for Button[fx:id="login"] onAction
    @FXML
    void loginAction(ActionEvent event) {
        super.start("principal.fxml", "Principal");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert login != null : "fx:id=\"login\" was not injected: check your FXML file 'login.fxml'.";
        assert prontuario != null : "fx:id=\"prontuario\" was not injected: check your FXML file 'login.fxml'.";
        assert senha != null : "fx:id=\"senha\" was not injected: check your FXML file 'login.fxml'.";

        // Initialize your logic here: all @FXML variables will have been injected

    }

}
