package formulario.integrado.business;

import formulario.integrado.model.Categoria;
import formulario.integrado.model.Formulario;
import formulario.integrado.model.IModel;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class FormularioBusiness extends Business implements IFormularioBusiness {
    private Statement sta;
    private PreparedStatement ps;
    private String sql = "";
    
    @Override
    public List<Formulario> show() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void moveDown(Categoria categoria) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void moveUp(Categoria categoria) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    
    public void add(Formulario formulario) {
        try {
            sql = "insert into formulario(id, titulo, aberto, status, data) values (" 
                    + formulario.getId()+ ", '" + formulario.getTitulo() + "', " + formulario.getAberto() + 
                    ", " + formulario.isStatus() + ", " + formulario.getData() + ");";
            this.ps = connection.prepareStatement(sql);
            ps.execute();
            System.setErr(null);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void update(Formulario formulario) {
        try {
            sql = "update formulario set id = " + formulario.getId() + ", titulo = '" + formulario.getTitulo() + "', aberto = '" 
                    + formulario.getAberto() + "', status = " + formulario.isStatus() + ", data = " + formulario.getData() + 
                    " where id = " + formulario.getId() + ";";;
            this.sta = connection.createStatement();
            ps.executeUpdate(sql);
            ps.close();
            System.setErr(null);
        } catch (Exception e) {
            e.getMessage();
        }
    }
   
    public void remove(Formulario formulario) {
        try {
            sql = "update formulario set status = " + formulario.isStatus() + " where id = " + formulario.getId() + ";";;
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
