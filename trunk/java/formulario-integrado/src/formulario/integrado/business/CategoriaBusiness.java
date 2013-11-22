package formulario.integrado.business;

import formulario.integrado.model.Campo;
import formulario.integrado.model.Categoria;
import formulario.integrado.model.IModel;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class CategoriaBusiness extends Business implements ICategoriaBusiness {
    private Statement sta;
    private PreparedStatement ps;
    private String sql = "";

    @Override
    public List<Categoria> show() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void moveDown(Campo campo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void moveUp(Campo campo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
       
    public void add(Categoria categoria) {
        try {
            sql = "insert into categoria(id, titulo, descricao, status, data) values (" 
                    + categoria.getId() + ", '" + categoria.getTitulo() + "','" + categoria.getDescricao() + "', " + categoria.isStatus() + 
                    ", " + categoria.getData() + ");";
            this.ps = connection.prepareStatement(sql);
            ps.execute();
            System.setErr(null);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void update(Categoria categoria) {
        try {
            sql = "update categoria set id = " + categoria.getId() + ", titulo = '" + categoria.getTitulo() + "', descricao = '" 
                    + categoria.getDescricao() + "', status = " + categoria.isStatus() + ", data = " + categoria.getData() + 
                    " where id = " + categoria.getId() + ";";;
            this.sta = connection.createStatement();
            ps.executeUpdate(sql);
            ps.close();
            System.setErr(null);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void remove(Categoria categoria) {
        try {
            sql = "update categoria set status = " + categoria.isStatus() + " where id = " + categoria.getId() + ";";;
            this.sta = connection.createStatement();
            ps.executeUpdate(sql);
            ps.close();
            System.setErr(null);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void add(IModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(IModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(IModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
