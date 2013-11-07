package formulario.integrado.business;

import formulario.integrado.model.Login;

public interface ILoginBusiness {
    public boolean isAuthenticated(Login model);
}
