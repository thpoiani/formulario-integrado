package formulario.integrado.business;

import formulario.integrado.business.database.Database;
import formulario.integrado.model.IModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class Business<T extends IModel> implements IBusiness<T> {

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

    @Override
    public T find(int id) {
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
    public void add(List<T> model) {
        Iterator<T> iterator = model.iterator();
        while (iterator.hasNext()) {
            add(iterator.next());
        }
    }

    @Override
    public void update(List<T> model) {
        Iterator<T> iterator = model.iterator();
        while (iterator.hasNext()) {
            update(iterator.next());
        }
    }

    @Override
    public void save(T model) {
        if (model.getId() > 0) {
            update(model);
        } else {
            add(model);
        }
    }

    @Override
    public void save(List<T> model) {
        Iterator<T> iterator = model.iterator();
        while (iterator.hasNext()) {
            save(iterator.next());
        }
    }

    @Override
    public void remove(List<T> model) {
        Iterator<T> iterator = model.iterator();
        while (iterator.hasNext()) {
            remove(iterator.next());
        }
    }
}
