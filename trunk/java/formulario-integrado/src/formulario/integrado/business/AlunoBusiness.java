package formulario.integrado.business;

import formulario.integrado.model.Aluno;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AlunoBusiness extends Business<Aluno> implements IAlunoBusiness {

    private Statement sta;
    private PreparedStatement ps;
    private String sql = "";

    @Override
    public List<Aluno> show() {
        return null;
    }

    @Override
    public void add(Aluno aluno) throws SQLException{
        super.openConnection();
        
        this.sql = "";
        this.ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        this.ps.setString(1, aluno.getProntuario());
        this.ps.setString(2, aluno.getNome());
        
        this.ps.executeUpdate();
        
        super.closeConnection();
        /*
        try {
            sql = "insert into aluno(id, prontuario, nome) values (" + aluno.getId()
                    + ", " + aluno.getProntuario()
                    + ", '" + aluno.getNome() + "');";
            this.ps = connection.prepareStatement(sql);
            ps.execute();
            System.setErr(null);
        } catch (Exception e) {
            e.getMessage();
        }*/
    }

    @Override
    public void update(Aluno aluno) {
        try {
            sql = "update aluno set id = " + aluno.getId() + ", prontuario = " + aluno.getProntuario()
                    + ", nome = '" + aluno.getNome() + "' where id = " + aluno.getId() + ";";
            this.sta = connection.createStatement();
            ps.executeUpdate(sql);
            ps.close();
            System.setErr(null);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void remove(Aluno aluno) {
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
