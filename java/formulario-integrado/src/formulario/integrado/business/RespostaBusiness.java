package formulario.integrado.business;

import formulario.integrado.model.IModel;
import formulario.integrado.model.Resposta;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class RespostaBusiness extends Business implements IRespostaBusiness {
    private Statement sta;
    private PreparedStatement ps;
    private String sql = "";
    
    @Override
    public List<Resposta> show() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void add(Resposta resposta) {
        try {
            sql = "insert into resposta(alunoId, campoId, resposta, data) values (" + resposta.getAlunoId() + ", " + resposta.getCampoId() + 
                    ", '" + resposta.getResposta() + "', " + resposta.getData() + ");";
            this.ps = connection.prepareStatement(sql);
            ps.execute();
            System.setErr(null);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void update(Resposta resposta) {
        try {
            sql = "update resposta set alunoId = " + resposta.getAlunoId()+ ", campoId = " + resposta.getCampoId() + ", resposta = '" 
                    + resposta.getResposta() + "', data = " + resposta.getData() + " where id = " + resposta.getAlunoId() + ";";;
            this.sta = connection.createStatement();
            ps.executeUpdate(sql);
            ps.close();
            System.setErr(null);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void remove(Resposta resposta) {
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

    @Override
    public void add(IModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void update(IModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(IModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
