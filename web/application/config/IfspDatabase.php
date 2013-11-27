<?php
class IfspDatabase {

    private static $host = null;
    private static $port = null;
    private static $database = null;
    private static $username = null;
    private static $passwd = null;

    private static $connection    = null;
    private static $query      = null;

    // Guarda uma instância da classe
    private static $instance;

    private function __construct() {

    }

    // O método singleton
    public static function getInstance()    {
        if (!isset(self::$instance)) {
            self::$instance = new IfspDatabase();
        }

        return self::$instance;
    }

    public function getPrematriculaCredentials(){
        $host = "poiani.cxdsxdlfvih4.us-west-2.rds.amazonaws.com";
        $port = "3306";
        $database = "prematricula";
        $username = "prematricula";
        $passwd = "prematricula";
    }

    public function getInteraticoCredentials(){
        $host = "poiani.cxdsxdlfvih4.us-west-2.rds.amazonaws.com";
        $port = "3306";
        $database = "interativo";
        $username = "interativo";
        $passwd = "interativo";
    }

    /**
    * Metodo para conexaõ com o banco
    */
    public function connect() {
        $this->conexao = mysql_connect($this->host, $this->user, $this->passwd);
        $status = mysql_select_db($this->database, $this->connection);
        return $status;
    }

    /**
    * Metodo para conexão executar query
    * passada como parametro
    */
    public function query($query) {
        $this->query = mysql_query($query);
        return $this->query;
    }

    /**
    * Metodo para recuperar
    * resultado da query
    */
    public function result() {
        return mysql_fetch_assoc($this->query);
    }

    /**
    * Metodo para encerrar a conexão com o banco
    */
    public function close(){
       if($this->connection != null){
        mysql_close($this->connection);
       }
    }
}