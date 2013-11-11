package formulario.integrado.business;

import formulario.integrado.model.Aluno;
import java.util.List;

interface IAlunoBusiness {
    public List<Aluno> show();
    public List<Aluno> show(Aluno filter);
}
