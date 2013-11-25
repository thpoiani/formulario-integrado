package formulario.integrado.business;

import formulario.integrado.model.Campo;
import formulario.integrado.model.Categoria;
import formulario.integrado.model.Grupo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CampoBusiness extends Business<Campo> implements ICampoBusiness {

    @Override
    public Campo find(int id) throws SQLException {
        super.openConnection();
        
        Campo campo = null;
        this.rs = null;
        
        this.sql = "SELECT c.id, c.titulo, c.maxlength, c.regex, c.status, c.ordem, c.data, c.categoriaId, c.tipoId "
                + "FROM campo c WHERE c.id = ?;";
        
        this.ps = connection.prepareStatement(this.sql);
        this.ps.setInt(1, id);
        this.rs = this.ps.executeQuery();

        if (rs.next()) {
            campo = assemblyCampo(rs);
        }
        
        super.closeConnection();
        
        return campo;
    }

    @Override
    public List<Campo> show() throws SQLException{
        super.openConnection();
        
        ArrayList<Campo> campo = new ArrayList<>();
        this.rs = null;
        
        this.sql = "SELECT * FROM campo WHERE status = 1;";
        
        this.ps = connection.prepareStatement(this.sql);
        this.rs = this.ps.executeQuery();
        
        while (rs.next()) {
            campo.add(assemblyCampo(rs));
        }
        
        super.closeConnection();
        
        return campo;
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
        this.ps.setInt(7, campo.getCategoria().getId());
        this.ps.setInt(8, campo.getTipoModel().getId());
        
        this.ps.executeUpdate();
        
        super.closeConnection();
    }

    @Override
    public void update(Campo campo) throws SQLException{
        super.openConnection();
        
        this.sql = "UPDATE campo SET titulo = ?, maxlength = ?, regex = ?, status = ?, ordem = ?, data = ?, "
                + "categoriaId = ?, tipoId = ? WHERE id = ?;";
        this.ps = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    
        this.ps.setString(1, campo.getTitulo());
        this.ps.setInt(2, campo.getMaxlength());
        this.ps.setString(3, campo.getRegex());
        this.ps.setBoolean(4, campo.isStatus());
        this.ps.setInt(5, campo.getOrdem());
        this.ps.setString(6, super.getCurrentDate(campo.getData()));
        this.ps.setInt(7, campo.getCategoriaId());
        this.ps.setInt(8, campo.getTipoModel().getId());
        this.ps.setInt(9, campo.getId());
        
        this.ps.executeUpdate();
        
        super.closeConnection();
    }

    @Override
    public void remove(Campo campo) throws SQLException{
        super.openConnection();
        
        this.sql = "UPDATE campo SET status = ? WHERE id = ?;";
        this.ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        this.ps.setBoolean(1, false);
        this.ps.setInt(2, campo.getId());
        
        this.ps.executeUpdate();
        
        super.closeConnection();
    }
    
    @Override
    public List<Campo> show(Categoria categoria) throws SQLException {
        super.openConnection();
        
        ArrayList<Campo> campo = new ArrayList<>();
        this.rs = null;
        
        this.sql = "SELECT c.id, c.titulo, c.maxlength, c.regex, c.status, "
                 + "c.ordem, c.data, c.categoriaId, c.tipoId FROM campo c WHERE c.status = 1 AND c.categoriaId = ?;";
        
        this.ps = connection.prepareStatement(this.sql);
        this.ps.setInt(1, categoria.getId());
        this.rs = this.ps.executeQuery();
        
        while (rs.next()) {
            ArrayList<Grupo> grupos = new ArrayList<>();
            
            String query = "SELECT g.id, g.titulo, g.data, g.ordem, g.status, g.campoId "
                        + "FROM grupo g WHERE g.status = 1 AND g.campoId = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, rs.getInt(1));
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                grupos.add(assemblyGrupo(resultSet));
            }
            
            campo.add(assemblyCampo(rs, grupos));
        }
        
        super.closeConnection();
        
        return campo;
    }

    /**
     * Método para popular um Formulário
     * 
     * @param ResultSet rs
     * @return Campo
     * @throws SQLException 
     */
    private Campo assemblyCampo(ResultSet rs) throws SQLException {
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
    
    /**
     * Método para popular um Formulário
     * 
     * @param ResultSet rs
     * @return Campo
     * @throws SQLException 
     */
    private Campo assemblyCampo(ResultSet rs, ArrayList<Grupo> grupos) throws SQLException {
        Campo campo = assemblyCampo(rs);
        
        if (grupos != null) {
            campo.setGrupos(grupos);
        }
        
        return campo;
    }
    
    /**
     * Método para popular Grupo
     * 
     * @param ResultSet rs
     * @return Grupo
     * @throws SQLException 
     */
    private Grupo assemblyGrupo(ResultSet rs) throws SQLException {
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
