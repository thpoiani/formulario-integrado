package formulario.integrado.business;

import formulario.integrado.model.Tipo;
import java.util.List;

interface ITipoBusiness extends IBusiness<Tipo> {
    public List<Tipo> show();
}
