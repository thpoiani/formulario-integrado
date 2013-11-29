<?php
class IfspDatabase {

    private static $host = null;
    private static $port = null;
    private static $database = null;
    private static $username = null;
    private static $passwd = null;

    private static $connection = null;
    private static $query = null;

    // Guarda uma instância da classe
    private static $instance;

    private function __construct() {
        $this->getInterativoCredentials();
    }

    // O método singleton
    public static function getInstance() {
        if (null === static::$instance) {
            static::$instance = new static;
        }

        return static::$instance;;
    }

    public function getPrematriculaCredentials(){
        self::$host = "poiani.cxdsxdlfvih4.us-west-2.rds.amazonaws.com";
        self::$port = "3306";
        self::$database = "prematricula";
        self::$username = "prematricula";
        self::$passwd = "prematricula";
    }

    public function getInterativoCredentials(){
        self::$host = "poiani.cxdsxdlfvih4.us-west-2.rds.amazonaws.com";
        self::$port = "3306";
        self::$database = "interativo";
        self::$username = "interativo";
        self::$passwd = "interativo";
    }

    /**
    * Metodo para conexão com o banco
    */
    public function connect() {
        try {
            self::$connection = mysql_connect(self::$host, self::$username, self::$passwd);
            return mysql_select_db(self::$database, self::$connection);
        } catch (Exception $e) {
            throw new Exception("Falha ao estabelecer conexão com o banco de dados");
        }
    }

    /**
     * Método para retonrar a conexão
     * @return Connection
     */
    public function getConnection() {
        if (isset(self::$connection)) {
            return self::$connection;
        }
    }

    /**
    * Metodo para conexão executar query
    * passada como parametro
    */
    public function query($query) {
        try {
            self::$query = mysql_query($query);
            return self::$query;
        } catch (Exception $e) {
            throw new Exception("Falha ao executar query com o banco de dados");
        }
    }

    /**
    * Metodo para recuperar
    * resultado da query
    */
    public function result() {
        try {
            return mysql_fetch_array(self::$query);
        } catch (Exception $e) {
            throw new Exception("Falha ao recuperar resultados do banco de dados");
        }
    }

    /**
    * Metodo para encerrar a conexão com o banco
    */
    public function close(){
        try {
            if(self::$connection != null){
                mysql_close(self::$connection);
            }
        } catch (Exception $e) {
            throw new Exception("Falha ao fechar conexão com o banco de dados");
        }
    }
}