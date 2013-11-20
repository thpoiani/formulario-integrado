package formulario.integrado.business;

import formulario.integrado.model.Tipo;
import java.util.List;

interface ITipoBusiness extends IBusiness {
    public List<Tipo> show();
}
