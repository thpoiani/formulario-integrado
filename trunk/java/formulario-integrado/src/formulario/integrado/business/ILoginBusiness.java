package formulario.integrado.business;

import formulario.integrado.model.Login;
import java.sql.SQLException;

public interface ILoginBusiness {
    public void openConnection();
    public void closeConnection();
    public boolean isAuthenticated(Login model) throws SQLException;
}
