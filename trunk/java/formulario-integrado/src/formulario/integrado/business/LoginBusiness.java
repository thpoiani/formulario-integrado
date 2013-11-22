
package formulario.integrado.business;

import formulario.integrado.business.database.Database;
import formulario.integrado.model.IModel;
import formulario.integrado.model.Login;

public class LoginBusiness extends Business implements ILoginBusiness {
    
    @Override
    public void openConnection() {
        super.connection = Database.getInstance("ifsp");
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
