package formulario.integrado.business;

import formulario.integrado.model.Aluno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlunoBusiness extends Business<Aluno> implements IAlunoBusiness {

    private ResultSet rs;;
    private PreparedStatement ps;
    private String sql;

    @Override
    public List<Aluno> show() throws SQLException{
        super.openConnection();
        
        ArrayList<Aluno> aluno = new ArrayList<>();
        this.rs = null;
        
        this.sql = "SELECT * FROM aluno;";
        
        this.ps = connection.prepareStatement(this.sql);
        this.rs = this.ps.executeQuery();
        
        while (rs.next()) {
            aluno.add(assembly(rs));
        }
        
        // verificar se possui aluno
        
        super.closeConnection();
        
        return aluno;
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
    
    private Aluno assembly(ResultSet rs) throws SQLException {
        Aluno aluno = new Aluno();
        aluno.setId(rs.getInt(1));
        aluno.setProntuario(rs.getString(2));
        aluno.setNome(rs.getString(3));
        
        return aluno;
    }
}
