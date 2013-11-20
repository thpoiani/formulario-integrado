package formulario.integrado.model;

import java.util.ArrayList;

public interface IModel {
    
    public boolean validate();
    public boolean isValid();
    public ArrayList<String> getErrors();
    public void addErrors(String error);
    
    @Override
    public String toString();
    
}
