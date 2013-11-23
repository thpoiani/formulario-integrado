package formulario.integrado.business;

import formulario.integrado.model.Campo;
import formulario.integrado.model.Grupo;
import java.util.List;

public interface ICampoBusiness extends IBusiness<Campo> {
    public List<Campo> show();
    public List<Grupo> show(Campo capo);
}
