package formulario.integrado;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class FormularioIntegrado extends Application {

    @Override
    public void start(Stage stage) throws Exception {
//         Parent root = FXMLLoader.load(getClass().getResource("/formulario/integrado/view/login.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/formulario/integrado/view/principal.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Formulário Integrado");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/assets/icon.png")));

        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}