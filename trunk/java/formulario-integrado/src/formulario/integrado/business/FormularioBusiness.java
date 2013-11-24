package formulario.integrado.business;

import formulario.integrado.model.Categoria;
import formulario.integrado.model.Formulario;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class FormularioBusiness extends Business<Formulario> implements IFormularioBusiness {

    private Statement sta;
    private PreparedStatement ps;
    private String sql = "";

    @Override
    public List<Formulario> show() {
        throw new UnsupportedOperationException("Not supported yet.");
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
    public void update(Formulario formulario) {
        try {
            sql = "update formulario set id = " + formulario.getId() + ", titulo = '" + formulario.getTitulo() + "', aberto = '"
                    + formulario.getAberto() + "', status = " + formulario.isStatus() + ", data = " + formulario.getData()
                    + " where id = " + formulario.getId() + ";";
            this.sta = connection.createStatement();
            ps.executeUpdate(sql);
            ps.close();
            System.setErr(null);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void remove(Formulario formulario) {
        try {
            sql = "update formulario set status = " + formulario.isStatus() + " where id = " + formulario.getId() + ";";
            this.sta = connection.createStatement();
            ps.executeUpdate(sql);
            ps.close();
            System.setErr(null);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
