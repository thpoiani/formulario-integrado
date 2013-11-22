package formulario.integrado.business;

import formulario.integrado.model.Grupo;
import formulario.integrado.model.IModel;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class GrupoBusiness extends Business implements IGrupoBusiness {
    private Statement sta;
    private PreparedStatement ps;
    private String sql = "";
    
    @Override
    public List<Grupo> show() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void add(Grupo grupo) {
        try {
            sql = "insert into grupo(id, titulo, data, campoId, tipoId) values (" 
                    + grupo.getId()+ ", '" + grupo.getTitulo() + "', " + grupo.getData() + 
                    ", " + grupo.getCampoId() + ", " + grupo.getTipoId() + ");";
            this.ps = connection.prepareStatement(sql);
            ps.execute();
            System.setErr(null);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void update(Grupo grupo) {
        try {
            sql = "update grupo set id = " + grupo.getId() + ", titulo = '" + grupo.getTitulo() + "', data = " 
                    + grupo.getData() + ", campoId = " + grupo.getCampoId() + ", tipoId = " + grupo.getTipoId() + 
                    " where id = " + grupo.getId() + ";";;
            this.sta = connection.createStatement();
            ps.executeUpdate(sql);
            ps.close();
            System.setErr(null);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void remove(Grupo grupo) {
        try {
            sql = "";
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
