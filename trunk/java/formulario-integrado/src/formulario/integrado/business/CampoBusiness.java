package formulario.integrado.business;

import formulario.integrado.model.Campo;
import formulario.integrado.model.Grupo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CampoBusiness extends Business<Campo> implements ICampoBusiness {

    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;

    @Override
    public List<Campo> show() throws SQLException{
        super.openConnection();
        
        ArrayList<Campo> campo = new ArrayList<>();
        this.rs = null;
        
        this.sql = "SELECT * FROM campo WHERE status = 1;";
        
        this.ps = connection.prepareStatement(this.sql);
        this.rs = this.ps.executeQuery();
        
        while (rs.next()) {
            campo.add(assembly(rs));
        }
        
        // verificar se possui categoria
        
        super.closeConnection();
        
        return campo;
    }
    
    @Override
    public List<Grupo> show(Campo campo)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Campo campo) throws SQLException{
        super.openConnection();
        
        this.sql = "INSERT INTO campo (titulo, maxlength, regex, status, ordem, data, categoriaId, tipoId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        this.ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        this.ps.setString(1, campo.getTitulo());
        this.ps.setInt(2, campo.getMaxlength());
        this.ps.setString(3, campo.getRegex());
        this.ps.setBoolean(4, campo.isStatus());
        this.ps.setInt(5, campo.getOrdem());
        this.ps.setString(6, super.getCurrentDate(campo.getData()));
        this.ps.setInt(7, campo.getCategoriaId());
        this.ps.setInt(8, campo.getTipoId());
        
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
    public void update(Campo campo) throws SQLException{
        super.openConnection();
        
        this.sql = "UPDATE campo SET titulo = ?, maxlength = ?, regex = ?, status = ?, ordem = ?, data = ?, "
                + "categoriaId = ?, tipoId = ? WHERE id = ?;";
        this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    
        this.ps.setString(1, campo.getTitulo());
        this.ps.setInt(2, campo.getMaxlength());
        this.ps.setString(3, campo.getRegex());
        this.ps.setBoolean(4, campo.isStatus());
        this.ps.setInt(5, campo.getOrdem());
        this.ps.setString(6, super.getCurrentDate(campo.getData()));
        this.ps.setInt(7, campo.getCategoriaId());
        this.ps.setInt(8, campo.getTipoId());
        this.ps.setInt(9, campo.getId());
        
        this.ps.executeUpdate();
        
        super.closeConnection();
        /*
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
        }*/
    }

    @Override
    public void remove(Campo campo) throws SQLException{
        super.openConnection();
        
        this.sql = "UPDATE campo SET status = ? WHERE id = ?;";
        this.ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        this.ps.setBoolean(1, campo.isStatus());
        this.ps.setInt(2, campo.getId());
        
        this.ps.executeUpdate();
        
        super.closeConnection();
        /*
        try {
            sql = "update campo set status = " + campo.isStatus() + " where id = " + campo.getId() + ";";
            this.sta = connection.createStatement();
            ps.executeUpdate(sql);
            ps.close();
            System.setErr(null);
        } catch (Exception e) {
            e.getMessage();
        }*/
    }
    
    /**
     * Método para popular um Formulário
     * 
     * @param ResultSet rs
     * @return Campo
     * @throws SQLException 
     */
    private Campo assembly(ResultSet rs) throws SQLException {
        Campo campo = new Campo();
        campo.setId(rs.getInt(1));
        campo.setTitulo(rs.getString(2));
        campo.setMaxlength(rs.getInt(3));
        campo.setRegex(rs.getString(4));
        campo.setStatus(rs.getBoolean(5));
        campo.setOrdem(rs.getInt(6));
        campo.setData(super.setCurrentDate(rs.getString(7)));
        campo.setCategoriaId(rs.getInt(8));
        campo.setTipoId(rs.getInt(9));
        
        return campo;
    }
    
}
