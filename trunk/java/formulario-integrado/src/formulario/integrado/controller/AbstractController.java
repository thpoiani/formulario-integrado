package formulario.integrado.controller;

import formulario.integrado.model.IModel;
import java.util.List;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * Classe com métodos comuns aos controllers
 */
abstract class AbstractController implements IController {

    private Window window;
    
    protected IModel model;
    protected List<? extends IModel> models;

    @FXML
    abstract void initialize();

    @Override
    public void addParentController(AbstractController controller) {
        // Composite
        throw new UnsupportedOperationException();
    }

    @Override
    public AbstractController getParentController() {
        // Composite
        throw new UnsupportedOperationException();
    }

    @Override
    public void setWindow(Window window) {
        this.window = window;
    }

    @Override
    public Window getWindow() {
        return window;
    }

    @Override
    public void start(String view, String title, AbstractController controller) {
        Stage stage = start(view, controller);
        stage.setTitle(title);
    }

    @Override
    public void start(String view, String title) {
        Stage stage = start(view, (AbstractController) null);
        stage.setTitle(title);
    }

    @Override
    public void close(Window window) {
        ((Stage) window).close();
    }

    public void close() {
        if (getWindow() != null) {
            ((Stage) getWindow()).close();
        }
    }

    @Override
    public void hide(Window window) {
        ((Stage) window).hide();
    }

    public void hide() {
        if (getWindow() != null) {
            ((Stage) getWindow()).hide();
        }
    }

    @Override
    public void show(Window window) {
        ((Stage) window).show();
    }

    public void show() {
        if (getWindow() != null) {
            ((Stage) getWindow()).show();
        }
    }

    @Override
    public String getClearStyle() {
        return "-fx-border-color: null;";
    }

    @Override
    public String getErrorStyle() {
        return "-fx-border-color: red;";
    }

    private Stage start(String view, AbstractController controller) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/formulario/integrado/view/" + view));

            Stage stage = new Stage();
            Scene scene = new Scene((Parent) loader.load());

            if (controller != null) {
                loader.<AbstractController>getController().addParentController(controller);
            }

            stage.setScene(scene);
            stage.setResizable(false);

            stage.show();

            return stage;
        } catch (Exception e) {
            throw new ExceptionInInitializerError();
        }
    }
}
