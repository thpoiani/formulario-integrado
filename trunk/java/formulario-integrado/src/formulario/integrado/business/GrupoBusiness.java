package formulario.integrado.business;

import formulario.integrado.model.Grupo;
import formulario.integrado.model.Campo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GrupoBusiness extends Business<Grupo> implements IGrupoBusiness {

    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;

    public List<Grupo> show(Campo campo) throws SQLException{
        super.openConnection();
        
        ArrayList<Grupo> grupo = new ArrayList<>();
        this.rs = null;
        
        this.sql = "SELECT * FROM grupo WHERE campoId = " + campo.getId() + ";";
        
        this.ps = connection.prepareStatement(this.sql);        
        this.rs = this.ps.executeQuery();
        
        while (rs.next()) {
            grupo.add(assembly(rs));
        }
        
        // verificar se possui grupo
        
        super.closeConnection();
        
        return grupo;
    }

    @Override
    public void add(Grupo grupo) throws SQLException{
        super.openConnection();
        
        this.sql = "INSERT INTO grupo (titulo, data, campoId, tipoId) VALUES (?, ?, ?, ?);";
        this.ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        this.ps.setString(1, grupo.getTitulo());
        this.ps.setString(2, super.getCurrentDate(grupo.getData()));
        this.ps.setInt(3, grupo.getCampoId());
        this.ps.setInt(4, grupo.getTipoId());
        
        this.ps.executeUpdate();
        
        super.closeConnection();
        /*
        try {
            sql = "insert into grupo(id, titulo, data, campoId, tipoId) values ("
                    + grupo.getId() + ", '" + grupo.getTitulo() + "', " + grupo.getData()
                    + ", " + grupo.getCampoId() + ", " + grupo.getTipoId() + ");";
            this.ps = connection.prepareStatement(sql);
            ps.execute();
            System.setErr(null);
        } catch (Exception e) {
            e.getMessage();
        }*/
    }

    @Override
    public void update(Grupo grupo) throws SQLException{
        super.openConnection();
        
        this.sql = "UPDATE grupo SET titulo = ?, campoId = ?, tipoId = ? WHERE id = ?;";
        this.ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        this.ps.setString(1, grupo.getTitulo());
        this.ps.setInt(2, grupo.getCampoId());
        this.ps.setInt(3, grupo.getTipoId());
        this.ps.setInt(4, grupo.getId());
        
        this.ps.executeUpdate();
        
        super.closeConnection();
        
        /*
        try {
            sql = "update grupo set id = " + grupo.getId() + ", titulo = '" + grupo.getTitulo() + "', data = "
                    + grupo.getData() + ", campoId = " + grupo.getCampoId() + ", tipoId = " + grupo.getTipoId()
                    + " where id = " + grupo.getId() + ";";;
            this.sta = connection.createStatement();
            ps.executeUpdate(sql);
            ps.close();
            System.setErr(null);
        } catch (Exception e) {
            e.getMessage();
        }*/
    }

    @Override
    public void remove(Grupo grupo) throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Método para popular Grupo
     * 
     * @param ResultSet rs
     * @return Grupo
     * @throws SQLException 
     */
    private Grupo assembly(ResultSet rs) throws SQLException {
        Grupo grupo = new Grupo();
        grupo.setId(rs.getInt(1));
        grupo.setTitulo(rs.getString(2));
        grupo.setData(super.setCurrentDate(rs.getString(3)));
        grupo.setCampoId(rs.getInt(4));
        grupo.setTipoId(rs.getInt(5));
        
        return grupo;
    }

    @Override
    public List<Grupo> show() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Grupo find(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
