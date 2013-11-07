/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario.integrado.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe com métodos comuns aos controllers
 */
class Controller {
    
    public Stage start(String view) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/formulario/integrado/view/" + view));
        
            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setResizable(false);

            stage.show();
        
            return stage;
        } catch (Exception e) {
            // TODO
            e.printStackTrace();
            return null;
        }
    }
    
    public void start(String view, String title) {
        Stage stage = start(view);
        stage.setTitle(title);
    }
    
}
