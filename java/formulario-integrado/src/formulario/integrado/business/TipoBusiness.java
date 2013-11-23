package formulario.integrado.business;

import formulario.integrado.model.Tipo;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class TipoBusiness extends Business<Tipo> implements ITipoBusiness {

    private Statement sta;
    private PreparedStatement ps;
    private String sql = "";

    @Override
    public List<Tipo> show() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(Tipo tipo) {
        try {
            sql = "insert into tipo(id, descricao) values (" + tipo.getId() + ", '" + tipo.getDescricao() + "');";
            this.ps = connection.prepareStatement(sql);
            ps.execute();
            System.setErr(null);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void update(Tipo tipo) {
        try {
            sql = "update tipo set id = " + tipo.getId() + ", descricao = '" + tipo.getDescricao()
                    + "' where id = " + tipo.getId() + ";";;
            this.sta = connection.createStatement();
            ps.executeUpdate(sql);
            ps.close();
            System.setErr(null);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void remove(Tipo tipo) {
        try {
            sql = "";
            this.sta = connection.createStatement();
            ps.executeUpdate(sql);
            ps.close();
            System.setErr(null);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
