package formulario.integrado.business;

import formulario.integrado.model.IModel;
import java.util.List;

public interface IBusiness {
    
    public void openConnection();
    public void closeConnection();
    
    public IModel find(int id);
    
    public void add(IModel model);
    public void add(List<IModel> model);
    
    public void update(IModel model);
    public void update(List<IModel> model);
    
    public void save(IModel model);
    public void save(List<IModel> model);
    
    public void remove(IModel model);
    public void remove(List<IModel> model);
}
