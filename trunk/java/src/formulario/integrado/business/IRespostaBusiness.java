package formulario.integrado.business;

import formulario.integrado.model.Resposta;
import java.util.List;

interface IRespostaBusiness {
    public List<Resposta> show();
    public List<Resposta> show(Resposta filter);
}
