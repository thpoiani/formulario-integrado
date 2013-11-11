package formulario.integrado.business;

import formulario.integrado.model.Formulario;
import java.util.List;

interface IFormularioBusiness {
    public List<Formulario> show();
    public List<Formulario> show(Formulario filter);
}
