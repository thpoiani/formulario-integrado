package formulario.integrado.business;

import formulario.integrado.model.Grupo;
import java.util.List;

interface IGrupoBusiness extends IBusiness {
    public List<Grupo> show();
}
