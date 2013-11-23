package formulario.integrado.business;

import formulario.integrado.model.Login;

public interface ILoginBusiness {
    public void openConnection();
    public void closeConnection();
    public boolean isAuthenticated(Login model);
}
