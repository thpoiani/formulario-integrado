
package formulario.integrado.business;

import formulario.integrado.business.database.Database;
import formulario.integrado.model.IModel;
import java.util.List;

abstract class Business implements IBusiness {
        
    protected java.sql.Connection connection;
    
    @Override
    public void openConnection() {
        connection = Database.getInstance("integrado");
    }

    @Override
    public void closeConnection() {
        Database.close("integrado");
    }

    @Override
    public IModel find(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(IModel model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(List<IModel> model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(IModel model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(List<IModel> model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void save(IModel model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void save(List<IModel> model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(IModel model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(List<IModel> model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
