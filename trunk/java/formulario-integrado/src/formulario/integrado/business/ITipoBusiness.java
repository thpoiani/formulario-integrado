package formulario.integrado.business;

import formulario.integrado.model.Tipo;
import java.sql.SQLException;
import java.util.List;

public interface ITipoBusiness extends IBusiness<Tipo> {
    public List<Tipo> show() throws SQLException;
}
