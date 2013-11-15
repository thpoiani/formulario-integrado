package formulario.integrado.controller;

import javafx.stage.Window;

interface IController {
    
    public void addParentController(AbstractController controller);
    public AbstractController getParentController();

    public void setWindow(Window window);
    public Window getWindow();
    
    public void start(String view, String title, AbstractController controller);
    public void start(String view, String title);
    
    public void close(Window window);
    public void hide(Window window);
    public void show(Window window);
    
    public String getClearStyle();
    public String getErrorStyle();
}
