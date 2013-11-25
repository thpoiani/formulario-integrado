package formulario.integrado.business.database;

import java.sql.SQLException;

class InterativoDatabase {

    private final static String ADAPTER = "mysql";
    private final static String HOST = "poiani.cxdsxdlfvih4.us-west-2.rds.amazonaws.com";
    private final static String PORT = "3306";
    private final static String DATABASE = "interativo";
    private final static String USERNAME = "interativo";
    private final static String PASSWORD = "interativo";
    
    private static java.sql.Connection connection;

    private InterativoDatabase() { }

    protected static synchronized java.sql.Connection getInstance() throws java.sql.SQLException {
        if (connection == null) {
            String connectionString = "jdbc:" + ADAPTER + "://" + HOST + ":" + PORT + "/" + DATABASE;
            connection = java.sql.DriverManager.getConnection(connectionString, USERNAME, PASSWORD);
        }
        return connection;
    }

    protected static void close() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                throw new RuntimeException("Falha na conexão com o banco de dados.");
            }
        }
    }
    
}
