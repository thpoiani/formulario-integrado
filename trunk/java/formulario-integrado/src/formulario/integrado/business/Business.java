
package formulario.integrado.business;

import formulario.integrado.business.database.Database;
import formulario.integrado.model.*;
import formulario.integrado.model.IModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class Business implements IBusiness {
        
    protected java.sql.Connection connection;
    protected ResultSet result = null;
    protected String sql;
    protected String table;
    
    @Override
    public void openConnection() {
        connection = Database.getInstance("integrado");
    }
    
    @Override
    public void closeConnection() {
        Database.close("integrado");
    }

    //@Override
    public IModel find(int id){
        String sql = null;
        Statement ps = null;
        try {
            ps = connection.createStatement();
            result = ps.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Business.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //throw new UnsupportedOperationException("Not supported yet.");
        return null;
        
    }


    @Override
    public void add(List<IModel> model) {        
        Iterator iterator = model.iterator();
        while(iterator.hasNext())
            add((List<IModel>) iterator.next());
    }

    @Override
    public void update(List<IModel> model) {
        Iterator iterator = model.iterator();
        while(iterator.hasNext())
            update((IModel) iterator.next());
    }

    @Override
    public void save(IModel model) {
        if (model.getId() > 0){
            update(model);
        }
        else
            add(model);
        
    }

    @Override
    public void save(List<IModel> model) {
        Iterator iterator = model.iterator();
        while(iterator.hasNext())
            save((IModel) iterator.next());
    }

    @Override
    public void remove(List<IModel> model) {
        Iterator iterator = model.iterator();
        while(iterator.hasNext())
            remove((IModel) iterator.next());
    }
}
