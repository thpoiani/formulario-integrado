package formulario.integrado.business;

import formulario.integrado.business.database.Database;
import formulario.integrado.model.IModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

abstract class Business<T extends IModel> implements IBusiness<T> {

    protected java.sql.Connection connection;
    protected PreparedStatement ps;
    protected ResultSet rs = null;
    protected String sql;
    protected String table;

    @Override
    public void openConnection() {
        connection = Database.getInstance("interativo");
    }

    @Override
    public void closeConnection() {
        Database.close("interativo");
    }

    @Override
    public void add(List<T> model) throws SQLException {
        Iterator<T> iterator = model.iterator();
        while (iterator.hasNext()) {
            add(iterator.next());
        }
    }

    @Override
    public void update(List<T> model) throws SQLException {
        Iterator<T> iterator = model.iterator();
        while (iterator.hasNext()) {
            update(iterator.next());
        }
    }

    @Override
    public void save(T model) throws SQLException {
        if (model.getId() > 0) {
            update(model);
        } else {
            add(model);
        }
    }

    @Override
    public void save(List<T> model) throws SQLException {
        Iterator<T> iterator = model.iterator();
        while (iterator.hasNext()) {
            save(iterator.next());
        }
    }

    @Override
    public void remove(List<T> model) throws SQLException {
        Iterator<T> iterator = model.iterator();
        while (iterator.hasNext()) {
            remove(iterator.next());
        }
    }
    
    /**
     * Método para retornar data no formato de datetime de banco de dados
     * 
     * @return String
     */
    protected String getCurrentDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
    
    /**
     * Método para retornar datetime de banco de dados para Date
     * 
     * @return String
     */
    protected Date setCurrentDate(String date) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return format.parse(date);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
}
