package formulario.integrado.business;

import formulario.integrado.model.IModel;
import java.sql.SQLException;
import java.util.List;

public interface IBusiness<T extends IModel> {
    
    public void openConnection();
    public void closeConnection();
    
    public T find(int id) throws SQLException;
    
    public void add(T model) throws SQLException;
    public void add(List<T> model) throws SQLException;
    
    public void update(T model) throws SQLException;
    public void update(List<T> model) throws SQLException;
    
    public void save(T model) throws SQLException;
    public void save(List<T> model) throws SQLException;
    
    public void remove(T model) throws SQLException;
    public void remove(List<T> model) throws SQLException;
}
