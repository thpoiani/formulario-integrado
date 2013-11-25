package formulario.integrado.business;

import formulario.integrado.model.Campo;
import formulario.integrado.model.Categoria;
import java.sql.SQLException;
import java.util.List;

public interface ICampoBusiness extends IBusiness<Campo> {
    public List<Campo> show() throws SQLException;
    public List<Campo> show(Categoria categoria) throws SQLException;
}
