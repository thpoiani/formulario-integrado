package formulario.integrado.business;

import formulario.integrado.model.Aluno;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlunoBusiness extends Business<Aluno> implements IAlunoBusiness {

    @Override
    public List<Aluno> show() throws SQLException{
        super.openConnection();
        
        ArrayList<Aluno> aluno = new ArrayList<>();
        this.rs = null;
        
        this.sql = "SELECT a.id, a.nome, a.prontuario FROM aluno a;";
        
        this.ps = connection.prepareStatement(this.sql);
        this.rs = this.ps.executeQuery();
        
        while (rs.next()) {
            aluno.add(assembly(rs));
        }
        
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
    }

    @Override
    public void update(Aluno aluno) throws SQLException{
        super.openConnection();
        
        this.sql = "UPDATE aluno SET prontuario = ?, nome = ? WHERE id = ?;";
        this.ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        this.ps.setString(1, aluno.getProntuario());
        this.ps.setString(2, aluno.getNome());
        this.ps.setInt(3, aluno.getId());
        
        this.ps.executeUpdate();
        
        super.closeConnection();
    }

    @Override
    public void remove(Aluno aluno) throws SQLException{
        super.openConnection();
        
        this.sql = "DELETE FROM aluno WHERE id = ?;";
        this.ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        this.ps.setInt(1, aluno.getId());
        
        this.ps.executeUpdate();
        
        super.closeConnection();
    }
    
    @Override
    public Aluno find(int id) throws SQLException {
        super.openConnection();
        
        Aluno aluno = null;
        
        this.sql = "SELECT a.id, a.nome, a.prontuario FROM aluno a WHERE a.id = ?;";
        this.ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        this.ps.setInt(1, id);
        
        this.ps.executeUpdate();
        
        if (rs.next()) {
            aluno = assembly(rs);
        }
        
        super.closeConnection();
        
        return aluno;
    }
    
    private Aluno assembly(ResultSet rs) throws SQLException {
        Aluno aluno = new Aluno();
        aluno.setId(rs.getInt(1));
        aluno.setProntuario(rs.getString(2));
        aluno.setNome(rs.getString(3));
        
        return aluno;
    }
}
