package formulario.integrado.business;

import formulario.integrado.model.Campo;
import formulario.integrado.model.Categoria;
import formulario.integrado.model.Grupo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CategoriaBusiness extends Business<Categoria> implements ICategoriaBusiness {
    
    @Override
    public Categoria find(int id) throws SQLException {
        super.openConnection();
        
        Categoria categoria = null;
        this.rs = null;
        
        this.sql = "SELECT cat.id, cat.titulo, cat.descricao, cat.status, cat.data "
                 + "FROM categoria cat WHERE cat.status = 1 AND cat.id = ?;";
        
        this.ps = connection.prepareStatement(this.sql);
        this.ps.setInt(1, id);
        this.rs = this.ps.executeQuery();
        
        while (rs.next()) {
            ArrayList<Campo> campos = new ArrayList<>();

            String query = "SELECT cam.id, cam.titulo, cam.maxlength, cam.regex, cam.status, "
                        + "cam.ordem, cam.data, cam.categoriaid, cam.tipoId "
                        + "FROM categoria cat "
                        + "INNER JOIN campo cam ON cam.categoriaId = cat.id AND cam.status = 1 "
                        + "WHERE cat.id = ?";
            
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                campos.add(assemblyCampo(resultSet));
            }
            
            categoria = assemblyCategoria(rs, campos);
        }
        
        super.closeConnection();
        
        return categoria;
    }

    @Override
    public List<Categoria> show() throws SQLException {
        super.openConnection();
        
        ArrayList<Categoria> categoria = new ArrayList<>();
        this.rs = null;
        
        this.sql = "SELECT cat.id, cat.titulo, cat.descricao, cat.status, cat.data "
                 + "FROM categoria cat WHERE cat.status = 1;";
        
        this.ps = connection.prepareStatement(this.sql);
        this.rs = this.ps.executeQuery();
        
        while (rs.next()) {
            ArrayList<Campo> campos = new ArrayList<>();

            String queryCampo = "SELECT cam.id, cam.titulo, cam.maxlength, cam.regex, cam.status, "
                        + "cam.ordem, cam.data, cam.categoriaid, cam.tipoId "
                        + "FROM categoria cat "
                        + "INNER JOIN campo cam ON cam.categoriaId = cat.id AND cam.status = 1 "
                        + "WHERE cat.id = ?";
            
            PreparedStatement preparedStatementCampo = connection.prepareStatement(queryCampo);
            preparedStatementCampo.setInt(1, rs.getInt(1));
            ResultSet resultSetCampo = preparedStatementCampo.executeQuery();
            
            while (resultSetCampo.next()) {
                ArrayList<Grupo> grupos = new ArrayList<>();

                String queryGrupo = "SELECT g.id, g.titulo, g.data, g.ordem, g.status, g.campoId  "
                            + "FROM grupo g INNER JOIN campo c ON c.id = g.campoId AND c.id = ? "
                            + "WHERE c.status = 1 AND g.status = 1;";

                PreparedStatement preparedStatementGrupo = connection.prepareStatement(queryGrupo);
                preparedStatementGrupo.setInt(1, resultSetCampo.getInt(1));
                ResultSet resultSetGrupo = preparedStatementGrupo.executeQuery();
                
                while (resultSetGrupo.next()) {
                    grupos.add(assemblyGrupo(resultSetGrupo));
                }
                
                campos.add(this.assemblyCampo(resultSetCampo, grupos));
            }
            
            categoria.add(assemblyCategoria(rs, campos));
        }
        
        super.closeConnection();
        
        return categoria;
    }

    @Override
    public void moveDown(Campo campo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void moveUp(Campo campo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(Categoria categoria) throws SQLException{
       super.openConnection();
       
       this.sql = "INSERT INTO categoria (titulo, descricao, status, data) VALUES (?, ?, ?, ?);";
       this.ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
       
       this.ps.setString(1, categoria.getTitulo());
       this.ps.setString(2, categoria.getDescricao());
       this.ps.setBoolean(3, categoria.isStatus());
       this.ps.setString(4, super.getCurrentDate(categoria.getData()));
       
       this.ps.executeUpdate();
       
       this.rs = ps.getGeneratedKeys();
       this.rs.next();
       int idCategoria = this.rs.getInt(1);
       
       for (Iterator<Campo> campos = categoria.getCampos().iterator(); campos.hasNext();) {
           Campo campo = campos.next();
           ResultSet resultSetCampo = null;
           
           String queryCampo  = "INSERT INTO campo (titulo, maxlength, regex, status, "
                   + "ordem, data, categoriaId, tipoId) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
           PreparedStatement preparedStatementCampo = connection.prepareStatement(queryCampo, Statement.RETURN_GENERATED_KEYS);

           preparedStatementCampo.setString(1, campo.getTitulo());
           preparedStatementCampo.setInt(2, campo.getMaxlength());
           preparedStatementCampo.setString(3, campo.getRegex());
           preparedStatementCampo.setBoolean(4, campo.isStatus());
           preparedStatementCampo.setInt(5, campo.getOrdem());
           preparedStatementCampo.setString(6, super.getCurrentDate(campo.getData()));
           preparedStatementCampo.setInt(7, idCategoria);
           preparedStatementCampo.setInt(8, campo.getTipoModel().getId());

           preparedStatementCampo.executeUpdate();
           
           resultSetCampo = preparedStatementCampo.getGeneratedKeys();
           resultSetCampo.next();
           int idCampo = resultSetCampo.getInt(1);
           
           for (Iterator<Grupo> grupos = campo.getGrupos().iterator(); grupos.hasNext();) {
               Grupo grupo = grupos.next();
               
               String queryGrupo = "INSERT INTO grupo (titulo, data, ordem, status, campoId) VALUES (?, ?, ?, ?, ?);";
               PreparedStatement preparedStatementGrupo = connection.prepareStatement(queryGrupo, Statement.RETURN_GENERATED_KEYS);
        
               preparedStatementGrupo.setString(1, grupo.getTitulo());
               preparedStatementGrupo.setString(2, super.getCurrentDate(grupo.getData()));
               preparedStatementGrupo.setInt(3, grupo.getOrdem());
               preparedStatementGrupo.setBoolean(4, grupo.isStatus());
               preparedStatementGrupo.setInt(5, idCampo);
                
               preparedStatementGrupo.executeUpdate();
             }
        }
       
       super.closeConnection();
    }

    @Override
    public void update(Categoria categoria) throws SQLException{
        super.openConnection();
       
        this.sql = "UPDATE categoria SET titulo = ?, descricao = ?, status = ? WHERE id = ?;";
        this.ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        this.ps.setString(1, categoria.getTitulo());
        this.ps.setString(2, categoria.getDescricao());
        this.ps.setBoolean(3, categoria.isStatus());
        this.ps.setInt(4, categoria.getId());

        this.ps.executeUpdate();

        super.closeConnection();
    }

    @Override
    public void remove(Categoria categoria) throws SQLException{
        super.openConnection();

        this.sql = "UPDATE categoria SET status = ? WHERE id = ?;";
        this.ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        this.ps.setBoolean(1, false);
        this.ps.setInt(2, categoria.getId());

        this.ps.executeUpdate();

        super.closeConnection();
    }
    
    /**
     * Método para popular Categoria
     * 
     * @param ResultSet rs
     * @return Categoria
     * @throws SQLException 
     */
    private Categoria assemblyCategoria(ResultSet rs, ArrayList<Campo> campos) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setId(rs.getInt(1));
        categoria.setTitulo(rs.getString(2));
        categoria.setDescricao(rs.getString(3));
        categoria.setStatus(rs.getBoolean(4));        
        categoria.setData(super.setCurrentDate(rs.getString(5)));
        
        if (campos != null) {
            categoria.setCampos(campos);
        }
        
        return categoria;
    }
    
    
    /**
     * Método para popular um Campo
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
     * Método para popular um Campo
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
