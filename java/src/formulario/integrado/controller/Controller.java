package formulario.integrado.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

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
            throw new ExceptionInInitializerError();
        }
    }

    public void start(String view, String title) {
        Stage stage = start(view);
        stage.setTitle(title);
    }

    public void close(Window window) {
        ((Stage) window).close();
    }

    public void hide(Window window) {
        ((Stage) window).hide();
    }

    public void show(Window window) {
        ((Stage) window).show();
    }
}
