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
        
        this.sql = "INSERT INTO aluno (prontuario, nome) values (?, ?);";
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
    public void update(Aluno aluno) throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(Aluno aluno) throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
