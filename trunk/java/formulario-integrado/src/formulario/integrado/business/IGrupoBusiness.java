package formulario.integrado.business;

import formulario.integrado.model.Grupo;
import java.sql.SQLException;
import java.util.List;

public interface IGrupoBusiness extends IBusiness<Grupo> {
    public List<Grupo> show() throws SQLException;
}
