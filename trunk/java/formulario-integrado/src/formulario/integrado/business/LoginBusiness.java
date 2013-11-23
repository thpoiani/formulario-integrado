
package formulario.integrado.business;

import formulario.integrado.business.database.Database;
import formulario.integrado.model.Login;

public class LoginBusiness implements ILoginBusiness {
    
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
    public boolean isAuthenticated(Login model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private void checkAuthentication(Login model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
