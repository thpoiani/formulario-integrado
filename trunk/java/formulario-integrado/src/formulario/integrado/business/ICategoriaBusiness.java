package formulario.integrado.business;

import formulario.integrado.model.Campo;
import formulario.integrado.model.Categoria;
import java.util.List;

public interface ICategoriaBusiness extends IBusiness {
    public List<Categoria> show();
    public void moveDown(Campo campo);
    public void moveUp(Campo campo);
}
