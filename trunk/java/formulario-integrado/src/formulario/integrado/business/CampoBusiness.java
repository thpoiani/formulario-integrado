package formulario.integrado.business;

import formulario.integrado.model.Campo;
import formulario.integrado.model.Grupo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CampoBusiness extends Business<Campo> implements ICampoBusiness {

    private Statement sta;
    private PreparedStatement ps;
    private String sql = "";

    @Override
    public List<Campo> show() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public List<Grupo> show(Campo capo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Campo campo) throws SQLException{
        super.openConnection();
        
        this.sql = "INSERT INTO campo () values ()";
        this.ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        this.ps.setString(1, campo.getTitulo());
        
        
        this.ps.executeUpdate();
        
        super.closeConnection();
        /*try {
            sql = "insert into campo(id, titulo, maxlength, regex, status, ordem, data, categoriaId, tipoId) values ("
                    + campo.getId() + ", '" + campo.getTitulo() + "', " + campo.getMaxlength() + ", '" + campo.getRegex()
                    + "', " + campo.isStatus() + ", " + campo.getOrdem() + ", " + campo.getData() + ", " + campo.getCategoriaId()
                    + ", " + campo.getTipoId() + ");";
            this.ps = connection.prepareStatement(sql);
            ps.execute();
            System.setErr(null);
        } catch (Exception e) {
            e.getMessage();
        }*/
    }

    @Override
    public void update(Campo campo) {
        try {
            sql = "update campo set id = " + campo.getId() + ", titulo = '" + campo.getTitulo() + "', maxlength = " + campo.getMaxlength()
                    + ", regex = '" + campo.getRegex() + "', status = " + campo.isStatus() + ", ordem = '" + campo.getOrdem() + "', data = "
                    + campo.getData() + ", categoriaId = " + campo.getCategoriaId() + ", tipoId = " + campo.getTipoId()
                    + " where id = " + campo.getId() + ";";
            this.sta = connection.createStatement();
            ps.executeUpdate(sql);
            ps.close();
            System.setErr(null);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void remove(Campo campo) {
        try {
            sql = "update campo set status = " + campo.isStatus() + " where id = " + campo.getId() + ";";
            this.sta = connection.createStatement();
            ps.executeUpdate(sql);
            ps.close();
            System.setErr(null);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
}
