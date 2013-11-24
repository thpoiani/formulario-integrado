package formulario.integrado.business;

import formulario.integrado.model.Grupo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class GrupoBusiness extends Business<Grupo> implements IGrupoBusiness {

    private Statement sta;
    private PreparedStatement ps;
    private String sql = "";

    @Override
    public List<Grupo> show() {
        throw new UnsupportedOperationException("Not supported yet.");
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
}
