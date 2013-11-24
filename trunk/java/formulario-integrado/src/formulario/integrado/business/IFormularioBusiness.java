package formulario.integrado.business;

import formulario.integrado.model.Categoria;
import formulario.integrado.model.Formulario;
import java.sql.SQLException;
import java.util.List;

public interface IFormularioBusiness extends IBusiness<Formulario> {
    public List<Formulario> show() throws SQLException;
    public void moveDown(Categoria categoria);
    public void moveUp(Categoria categoria);
}
