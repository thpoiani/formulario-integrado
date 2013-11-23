package formulario.integrado.business;

import formulario.integrado.model.Campo;
import formulario.integrado.model.Categoria;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class CategoriaBusiness extends Business<Categoria> implements ICategoriaBusiness {

    private Statement sta;
    private PreparedStatement ps;
    private String sql = "";

    @Override
    public List<Categoria> show() {
        throw new UnsupportedOperationException("Not supported yet.");
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
    public void add(Categoria categoria) {
        try {
            sql = "insert into categoria(id, titulo, descricao, status, data) values ("
                    + categoria.getId() + ", '" + categoria.getTitulo() + "','" + categoria.getDescricao() + "', " + categoria.isStatus()
                    + ", " + categoria.getData() + ");";
            this.ps = connection.prepareStatement(sql);
            ps.execute();
            System.setErr(null);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void update(Categoria categoria) {
        try {
            sql = "update categoria set id = " + categoria.getId() + ", titulo = '" + categoria.getTitulo() + "', descricao = '"
                    + categoria.getDescricao() + "', status = " + categoria.isStatus() + ", data = " + categoria.getData()
                    + " where id = " + categoria.getId() + ";";;
            this.sta = connection.createStatement();
            ps.executeUpdate(sql);
            ps.close();
            System.setErr(null);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void remove(Categoria categoria) {
        try {
            sql = "update categoria set status = " + categoria.isStatus() + " where id = " + categoria.getId() + ";";;
            this.sta = connection.createStatement();
            ps.executeUpdate(sql);
            ps.close();
            System.setErr(null);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
