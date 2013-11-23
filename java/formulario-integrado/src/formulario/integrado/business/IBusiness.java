package formulario.integrado.business;

import formulario.integrado.model.IModel;
import java.util.List;

public interface IBusiness<T extends IModel> {
    
    public void openConnection();
    public void closeConnection();
    
    public T find(int id);
    
    public void add(T model);
    public void add(List<T> model);
    
    public void update(T model);
    public void update(List<T> model);
    
    public void save(T model);
    public void save(List<T> model);
    
    public void remove(T model);
    public void remove(List<T> model);
}
