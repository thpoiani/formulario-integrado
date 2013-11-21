package formulario.integrado.business.database;

import java.sql.Connection;
import java.sql.SQLException;

public class Database {

    private Database() {}

    /**
     * Método responsável por instanciar banco de dados.
     *
     * @param database "ifsp" ou "interativo"
     * @return
     */
    public static synchronized Connection getInstance(String database) {
        try {
            switch (database) {
                case "ifsp":
                    return IFSPDatabase.getInstance();

                case "interativo":
                    return InterativoDatabase.getInstance();

                default:
                    throw new RuntimeException("Não foi possível se conectar com o banco de dados.");
            }
        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException("Falha na conexão com o banco de dados.");
        }
    }

    public static void close(String database) {
        try {
            switch (database) {
                case "ifsp":
                    IFSPDatabase.close();
                    break;

                case "interativo":
                    InterativoDatabase.close();
                    break;

                default:
                    throw new RuntimeException("Não foi possível fechar a conexão com o banco de dados.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Falha na conexão com o banco de dados.");
        }
    }
    
}
