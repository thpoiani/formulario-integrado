package formulario.integrado.business;

import formulario.integrado.model.Campo;
import formulario.integrado.model.Categoria;
import java.util.List;

public class CategoriaBusiness extends Business implements ICategoriaBusiness {

    @Override
    public List<Categoria> show() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void moveDown(Campo campo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void moveUp(Campo campo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
