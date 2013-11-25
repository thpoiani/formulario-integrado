package formulario.integrado.business;

import formulario.integrado.model.Resposta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RespostaBusiness extends Business<Resposta> implements IRespostaBusiness {

    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;

    @Override
    public List<Resposta> show() throws SQLException{
        super.openConnection();
        
        ArrayList<Resposta> resposta = new ArrayList<>();
        this.rs = null;
        
        this.sql = "SELECT * FROM resposta;";
        
        this.ps = connection.prepareStatement(this.sql);
        this.rs = this.ps.executeQuery();
        
        while (rs.next()) {
            resposta.add(assembly(rs));
        }
        
        // verificar se possui resposta
        
        super.closeConnection();
        
        return resposta;
    }

    @Override
    public void add(Resposta resposta) throws SQLException{
        super.openConnection();
        
        this.sql = "INSERT INTO resposta (alunoId, campoId, resposta, data) values (?, ?, ?, ?);";
        this.ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        this.ps.setInt(1, resposta.getAlunoId());
        this.ps.setInt(2, resposta.getCampoId());
        this.ps.setString(3, resposta.getResposta());
        this.ps.setString(4, super.getCurrentDate(resposta.getData()));
        
        this.ps.executeUpdate();
        
        super.closeConnection();
    }

    @Override
    public void update(Resposta resposta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(Resposta resposta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Método para popular Resposta
     * 
     * @param ResultSet rs
     * @return Resposta
     * @throws SQLException 
     */
    private Resposta assembly(ResultSet rs) throws SQLException {
        Resposta resposta = new Resposta();
        resposta.setAlunoId(rs.getInt(1));
        resposta.setCampoId(rs.getInt(2));
        resposta.setResposta(rs.getString(3));
        resposta.setData(super.setCurrentDate(rs.getString(4)));
        
        return resposta;
    }

    @Override
    public Resposta find(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
