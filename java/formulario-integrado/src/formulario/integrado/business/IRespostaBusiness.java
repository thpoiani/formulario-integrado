package formulario.integrado.business;

import formulario.integrado.model.Resposta;
import java.sql.SQLException;
import java.util.List;

public interface IRespostaBusiness extends IBusiness<Resposta> {
    public List<Resposta> show() throws SQLException;
}
