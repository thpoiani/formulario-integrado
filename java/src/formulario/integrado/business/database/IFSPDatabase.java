/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario.integrado.business.database;

import java.sql.SQLException;

/**
 *
 * @author ThiagoHenrique
 */
class IFSPDatabase {
    
    private final static String ADAPTER = "mysql";
    private final static String HOST = "poiani.cxdsxdlfvih4.us-west-2.rds.amazonaws.com";
    private final static String PORT = "3306";
    private final static String DATABASE = "prematricula";
    private final static String USERNAME = "prematricula";
    private final static String PASSWORD = "prematricula";

    private static java.sql.Connection connection;

    private IFSPDatabase() {}

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
                            // TODO RETIRAR EM AMBIENTE DE PRODUÇÃO
                            e.printStackTrace();
                    }
            }
    }

}
