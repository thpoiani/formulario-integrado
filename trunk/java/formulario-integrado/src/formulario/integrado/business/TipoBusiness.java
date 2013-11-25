package formulario.integrado.business;

import formulario.integrado.model.Tipo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TipoBusiness extends Business<Tipo> implements ITipoBusiness {

    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    
    @Override
    public Tipo find(int id) throws SQLException{
        super.openConnection();
        
        Tipo tipo = null;
        this.rs = null;
        
        this.sql = "SELECT t.id, t.descricao FROM tipo t WHERE t.id = ?;";
        
        this.ps = connection.prepareStatement(this.sql);
        this.ps.setInt(1, id);
        this.rs = this.ps.executeQuery();
        
        if (rs.next()) {
            tipo = assembly(rs);
        }
        
        super.closeConnection();
        
        return tipo;
    }
    
    @Override
    public Tipo getCheck() throws SQLException{
        return getType("Check");
    }
    
    @Override
    public Tipo getRadio() throws SQLException{
        return getType("Radio");
    }
    
    /**
     * Método para retornar Tipo pela descrição
     * 
     * @param descricao
     * @return Tipo
     * @throws SQLException 
     */
    private Tipo getType(String descricao) throws SQLException {
        super.openConnection();
        
        Tipo tipo = null;
        this.rs = null;
        
        this.sql = "SELECT t.id, t.descricao FROM tipo t WHERE t.descricao = ?;";
        
        this.ps = connection.prepareStatement(this.sql);
        this.ps.setString(1, descricao);
        this.rs = this.ps.executeQuery();
        
        if (rs.next()) {
            tipo = assembly(rs);
        }
        
        super.closeConnection();
        
        return tipo;
    }

    @Override
    public List<Tipo> show() throws SQLException{
        super.openConnection();
        
        ArrayList<Tipo> tipo = new ArrayList<>();
        this.rs = null;
        
        this.sql = "SELECT t.id, t.descricao FROM tipo t WHERE t.descricao <> ? AND t.descricao <> ?;";
        
        this.ps = connection.prepareStatement(this.sql);
        this.ps.setString(1, "Radio");
        this.ps.setString(2, "Check");
        this.rs = this.ps.executeQuery();
        
        while (rs.next()) {
            tipo.add(assembly(rs));
        }       
        
        // verificar se possui tipo
        
        super.closeConnection();
        
        return tipo;
    }

    @Override
    public void add(Tipo tipo) throws SQLException{
        super.openConnection();

        this.sql = "INSERT INTO tipo (descricao) VALUES (?);";
        this.ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        this.ps.setString(1, tipo.getDescricao());
        
        this.ps.executeUpdate();
        
        super.closeConnection();
    }

    @Override
    public void update(Tipo tipo)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(Tipo tipo) throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Método para popular Tipo
     * 
     * @param ResultSet rs
     * @return Tipo
     * @throws SQLException 
     */
    private Tipo assembly(ResultSet rs) throws SQLException {
        Tipo tipo = new Tipo();
        tipo.setId(rs.getInt(1));
        tipo.setDescricao(rs.getString(2));
        
        return tipo;
    }
}
