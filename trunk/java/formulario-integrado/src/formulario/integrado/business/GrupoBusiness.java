package formulario.integrado.business;

import formulario.integrado.model.Grupo;
import formulario.integrado.model.Campo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GrupoBusiness extends Business<Grupo> implements IGrupoBusiness {

    @Override
    public List<Grupo> show(Campo campo) throws SQLException{
        super.openConnection();
        
        ArrayList<Grupo> grupo = new ArrayList<>();
        this.rs = null;
        
        this.sql = "SELECT g.id, g.titulo, g.data, g.ordem, g.status, g.campoId "
                 + "FROM grupo g WHERE g.status = 1 AND g.campoId = ?;";
        
        this.ps = connection.prepareStatement(this.sql);        
        this.ps.setInt(1, campo.getId());
        this.rs = this.ps.executeQuery();
        
        while (rs.next()) {
            grupo.add(assembly(rs));
        }
        
        super.closeConnection();
        
        return grupo;
    }

    @Override
    public void add(Grupo grupo) throws SQLException{
        super.openConnection();
        
        this.sql = "INSERT INTO grupo (titulo, data, ordem, status, campoId) VALUES (?, ?, ?, ?, ?);";
        this.ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        this.ps.setString(1, grupo.getTitulo());
        this.ps.setString(2, super.getCurrentDate(grupo.getData()));
        this.ps.setInt(3, grupo.getOrdem());
        this.ps.setBoolean(4, grupo.isStatus());
        this.ps.setInt(5, grupo.getCampoId());
        
        this.ps.executeUpdate();
        
        super.closeConnection();
    }

    @Override
    public void update(Grupo grupo) throws SQLException{
        super.openConnection();
        
        this.sql = "UPDATE grupo SET titulo = ?, ordem = ?, status = ?, campoId = ? WHERE id = ?;";
        this.ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        this.ps.setString(1, grupo.getTitulo());
        this.ps.setInt(2, grupo.getOrdem());
        this.ps.setBoolean(3, grupo.isStatus());
        this.ps.setInt(4, grupo.getCampoId());
        this.ps.setInt(5, grupo.getId());
        
        this.ps.executeUpdate();
        
        super.closeConnection();
    }

    @Override
    public void remove(Grupo grupo) throws SQLException{
        super.openConnection();
        
        this.sql = "UPDATE grupo SET status = ? WHERE id = ?;";
        this.ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        this.ps.setBoolean(1, false);
        this.ps.setInt(2, grupo.getId());
        
        this.ps.executeUpdate();
        
        super.closeConnection();
    }
    
    @Override
    public List<Grupo> show() throws SQLException {
        super.openConnection();
        
        ArrayList<Grupo> grupo = new ArrayList<>();
        this.rs = null;
        
        this.sql = "SELECT g.id, g.titulo, g.data, g.ordem, g.status, g.campoId "
                 + "FROM grupo g WHERE g.status = 1;";
        
        this.ps = connection.prepareStatement(this.sql);        
        this.rs = this.ps.executeQuery();
        
        while (rs.next()) {
            grupo.add(assembly(rs));
        }
        
        super.closeConnection();
        
        return grupo;
    }

    @Override
    public Grupo find(int id) throws SQLException {
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
        grupo.setOrdem(rs.getInt(4));
        grupo.setStatus(rs.getBoolean(5));
        grupo.setCampoId(rs.getInt(6));
        
        return grupo;
    }

}
