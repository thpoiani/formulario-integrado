package formulario.integrado.business;

import formulario.integrado.model.Formulario;
import java.util.List;

public interface IFormularioBusiness extends IBusiness {
    public List<Formulario> show();
}
