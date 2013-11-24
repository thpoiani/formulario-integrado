package formulario.integrado.business;

import formulario.integrado.model.Categoria;
import formulario.integrado.model.Formulario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FormularioBusiness extends Business<Formulario> implements IFormularioBusiness {

    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    
    @Override
    public Formulario find(int id) throws SQLException {
        super.openConnection();
        
        Formulario formulario = null;
        this.rs = null;
        
        this.sql = "SELECT f.id, f.titulo, f.status, f.aberto, f.data "
                 + "FROM formulario f WHERE f.id = ?;";
        
        this.ps = connection.prepareStatement(this.sql);
        this.ps.setInt(1, id);
        this.rs = this.ps.executeQuery();
        
        while (rs.next()) {
            ArrayList<Categoria> categorias = new ArrayList<>();

            String query = "SELECT c.id, c.titulo, c.descricao, c.status, c.data "
                        + "FROM formulario f "
                        + "INNER JOIN formulario_categoria fc ON f.id = fc.formularioId AND f.id = ? "
                        + "INNER JOIN categoria c ON c.id = fc.categoriaId AND c.status = 1";
            
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                categorias.add(assemblyCategoria(resultSet));
            }
            
            formulario = assemblyFormulario(rs, categorias);
        }
        
        super.closeConnection();
        
        return formulario;
    }

    @Override
    public List<Formulario> show() throws SQLException {
        super.openConnection();
        
        ArrayList<Formulario> formularios = new ArrayList<>();
        this.rs = null;
        
        this.sql = "SELECT f.id, f.titulo, f.status, f.aberto, f.data "
                 + "FROM formulario f WHERE f.status = 1;";
        
        this.ps = connection.prepareStatement(this.sql);
        this.rs = this.ps.executeQuery();
        
        while (rs.next()) {
            ArrayList<Categoria> categorias = new ArrayList<>();

            String query = "SELECT c.id, c.titulo, c.descricao, c.status, c.data "
                        + "FROM formulario f "
                        + "INNER JOIN formulario_categoria fc ON f.id = fc.formularioId AND f.id = ? "
                        + "INNER JOIN categoria c ON c.id = fc.categoriaId AND c.status = 1";
            
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, rs.getInt(1));
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                categorias.add(assemblyCategoria(resultSet));
            }
            
            formularios.add(assemblyFormulario(rs, categorias));
        }
        
        // verificar se possui categoria
        
        super.closeConnection();
        
        return formularios;
    }
    
    @Override
    public void moveDown(Categoria categoria) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void moveUp(Categoria categoria) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(Formulario formulario) throws SQLException {
        super.openConnection();

        this.sql = "INSERT INTO formulario (titulo, aberto, status, data) VALUES (?,?,?,?);";
        this.ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        this.ps.setString(1, formulario.getTitulo());
        this.ps.setBoolean(2, formulario.isAberto());
        this.ps.setBoolean(3, formulario.isStatus());
        this.ps.setString(4, super.getCurrentDate(formulario.getData()));
        
        this.ps.executeUpdate();
        
        this.rs = ps.getGeneratedKeys();
        this.rs.next();
        int id = this.rs.getInt(1);
                
        for (Iterator<Categoria> categorias = formulario.getCategorias().iterator(); categorias.hasNext();) {
            String query  = "INSERT INTO formulario_categoria (formularioId, categoriaId) VALUES (?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, categorias.next().getId());
            
            preparedStatement.executeUpdate();
        }
        
        super.closeConnection();
    }

    @Override
    public void update(Formulario formulario) throws SQLException{
        super.openConnection();
        
        this.sql = "UPDATE formulario SET titulo = ?, aberto = ?, status = ? WHERE id = ?;";
        this.ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        this.ps.setString(1, formulario.getTitulo());
        this.ps.setBoolean(2, formulario.isAberto());
        this.ps.setBoolean(3, formulario.isStatus());
        this.ps.setInt(4, formulario.getId());
        
        this.ps.executeUpdate();
        
        super.closeConnection();
    }

    @Override
    public void remove(Formulario formulario) throws SQLException {
        super.openConnection();
        
        this.sql = "UPDATE formulario SET status = ? WHERE id = ?;";
        this.ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        this.ps.setBoolean(1, false);
        this.ps.setInt(2, formulario.getId());
        
        this.ps.executeUpdate();
        
        super.closeConnection();
    }
    
    /**
     * Método para popular um Formulário
     * 
     * @param ResultSet rs
     * @return Formulario
     * @throws SQLException 
     */
    private Formulario assemblyFormulario(ResultSet rs, ArrayList<Categoria> categorias) throws SQLException {
        Formulario formulario = new Formulario();
        formulario.setId(rs.getInt(1));
        formulario.setTitulo(rs.getString(2));
        formulario.setStatus(rs.getBoolean(3));
        formulario.setAberto(rs.getBoolean(4));
        formulario.setData(super.setCurrentDate(rs.getString(5)));
        
        if (categorias != null) {
            formulario.setCategorias(categorias);
        }
        
        return formulario;
    }
    
    /**
     * Método para popular Categoria
     * 
     * @param ResultSet rs
     * @return Categoria
     * @throws SQLException 
     */
    private Categoria assemblyCategoria(ResultSet resultSet) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setId(resultSet.getInt(1));
        categoria.setTitulo(resultSet.getString(2));
        categoria.setDescricao(resultSet.getString(3));
        categoria.setStatus(resultSet.getBoolean(4));        
        categoria.setData(super.setCurrentDate(resultSet.getString(5)));
        
        return categoria;
    }

    /**
     * Método para remover relacionamento de categoria com formulário
     */
    @Override
    public void remove(Formulario formulario, Categoria categoria) throws SQLException {
        super.openConnection();
        
        this.sql = "DELETE FROM formulario_categoria WHERE categoriaId = ? AND formularioId = ?";
        this.ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        this.ps.setInt(1, categoria.getId());
        this.ps.setInt(2, formulario.getId());
        
        this.ps.executeUpdate();
        
        super.closeConnection();
    }
    
    @Override
    public void add(Formulario formulario, Categoria categoria) throws SQLException {
        super.openConnection();
        
        this.sql = "INSERT INTO formulario_categoria (formularioId, categoriaId) VALUES (?,?);";
        this.ps = connection.prepareStatement(this.sql, Statement.RETURN_GENERATED_KEYS);

        this.ps.setInt(1, formulario.getId());
        this.ps.setInt(2, categoria.getId());

        this.ps.executeUpdate();
        
        super.closeConnection();
    }
}
