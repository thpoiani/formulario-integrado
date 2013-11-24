package formulario.integrado.business;

import formulario.integrado.model.Campo;
import formulario.integrado.model.Categoria;
import java.sql.SQLException;
import java.util.List;

public interface ICategoriaBusiness extends IBusiness<Categoria> {
    public List<Categoria> show() throws SQLException;
    public void moveDown(Campo campo);
    public void moveUp(Campo campo);
}
