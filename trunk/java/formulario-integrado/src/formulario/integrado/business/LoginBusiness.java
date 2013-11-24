
package formulario.integrado.business;

import formulario.integrado.business.database.Database;
import formulario.integrado.model.Login;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginBusiness implements ILoginBusiness {
    
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    private boolean isAuth;
    
    protected java.sql.Connection connection;
    
    @Override
    public void openConnection() {
        this.connection = Database.getInstance("ifsp");
    }

    @Override
    public void closeConnection() {
        Database.close("ifsp");
    }

    @Override
    public boolean isAuthenticated(Login model) throws SQLException {
        this.openConnection();
        
        this.rs = null;
        
        this.sql = "SELECT p.prontuario "
                 + "FROM pm_pessoas p WHERE p.prontuario = ? AND p.senha = ?";
        
        this.ps = connection.prepareStatement(this.sql);
        this.ps.setString(1, model.getProntuario());
        this.ps.setString(2, model.getSenha());
        
        this.rs = this.ps.executeQuery();
        this.isAuth = rs.next();
        
        this.closeConnection();

        return checkAuthentication();
    }
    
    private boolean checkAuthentication() {
        return this.isAuth;
    }
    
}
