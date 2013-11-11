package formulario.integrado.business;

import formulario.integrado.model.Categoria;
import java.util.List;

interface ICategoriaBusiness {
    public List<Categoria> show();
    public List<Categoria> show(Categoria filter);
}
