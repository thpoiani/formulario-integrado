package formulario.integrado.business;

import formulario.integrado.model.Campo;
import java.util.List;

interface ICampoBusiness {
    public List<Campo> show();
    public List<Campo> show(Campo filter);
}
