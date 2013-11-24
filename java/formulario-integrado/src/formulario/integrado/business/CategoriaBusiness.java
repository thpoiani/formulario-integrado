package formulario.integrado.business;

import formulario.integrado.model.Campo;
import formulario.integrado.model.Categoria;
import formulario.integrado.model.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriaBusiness extends Business<Categoria> implements ICategoriaBusiness {

    private PreparedStatement ps;
    private String sql;
    private ResultSet rs;

    @Override
    public List<Categoria> show() throws SQLException{
        super.openConnection();
        
        ArrayList<Categoria> categoria = new ArrayList<>();
        this.rs = null;
        
        this.sql = "SELECT cat.id, cat.titulo, cat.descricao, cat.status, cat.data "
                 + "FROM categoria cat WHERE cat.status = 1;";
        
        this.ps = connection.prepareStatement(this.sql);
        this.rs = this.ps.executeQuery();
        
        while (rs.next()) {
            categoria.add(assembly(rs));
        }
        
        // verificar se possui categoria
        
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
       
       super.closeConnection();
       
        
        /*try {
            sql = "insert into categoria(id, titulo, descricao, status, data) values ("
                    + categoria.getId() + ", '" + categoria.getTitulo() + "','" + categoria.getDescricao() + "', " + categoria.isStatus()
                    + ", " + categoria.getData() + ");";
            this.ps = connection.prepareStatement(sql);
            ps.execute();
            System.setErr(null);
        } catch (Exception e) {
            e.getMessage();
        }*/
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
        
        /*try {
            sql = "update categoria set id = " + categoria.getId() + ", titulo = '" + categoria.getTitulo() + "', descricao = '"
                    + categoria.getDescricao() + "', status = " + categoria.isStatus() + ", data = " + categoria.getData()
                    + " where id = " + categoria.getId() + ";";;
            this.sta = connection.createStatement();
            ps.executeUpdate(sql);
            ps.close();
            System.setErr(null);
        } catch (Exception e) {
            e.getMessage();
        }*/
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
        
        /*try {
            sql = "update categoria set status = " + categoria.isStatus() + " where id = " + categoria.getId() + ";";;
            this.sta = connection.createStatement();
            ps.executeUpdate(sql);
            ps.close();
            System.setErr(null);
        } catch (Exception e) {
            e.getMessage();
        }*/
    }
    
    /**
     * Método para popular Categoria
     * 
     * @param ResultSet rs
     * @return Categoria
     * @throws SQLException 
     */
    private Categoria assembly(ResultSet rs) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setId(rs.getInt(1));
        categoria.setTitulo(rs.getString(2));
        categoria.setDescricao(rs.getString(3));
        categoria.setStatus(rs.getBoolean(4));        
        categoria.setData(super.setCurrentDate(rs.getString(5)));
        
        return categoria;
    }
}
