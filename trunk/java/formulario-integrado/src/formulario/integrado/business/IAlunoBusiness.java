package formulario.integrado.business;

import formulario.integrado.model.Aluno;
import java.util.List;

interface IAlunoBusiness extends IBusiness<Aluno> {
    public List<Aluno> show();
}
