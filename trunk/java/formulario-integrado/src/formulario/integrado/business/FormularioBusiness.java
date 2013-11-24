package formulario.integrado.business;

import formulario.integrado.model.Categoria;
import formulario.integrado.model.Formulario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FormularioBusiness extends Business<Formulario> implements IFormularioBusiness {

    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    @Override
    public List<Formulario> show() throws SQLException {
        super.openConnection();
        
        ArrayList<Formulario> formularios = new ArrayList<>();
        this.rs = null;
        
        this.sql = "SELECT f.id, f.titulo, f.status, f.aberto, f.data "
                 + "FROM formulario f WHERE f.status = 1";
        
        this.ps = connection.prepareStatement(this.sql);
        this.rs = this.ps.executeQuery();
        
        while (rs.next()) {
            formularios.add(assembly(rs));
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
    private Formulario assembly(ResultSet rs) throws SQLException {
        Formulario formulario = new Formulario();
        formulario.setId(rs.getInt(1));
        formulario.setTitulo(rs.getString(2));
        formulario.setStatus(rs.getBoolean(3));
        formulario.setAberto(rs.getBoolean(4));
        formulario.setData(super.setCurrentDate(rs.getString(5)));
        
        return formulario;
    }
}
