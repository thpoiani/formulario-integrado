<?php
class IfspDatabase {

    private $host = null;
    private $port = null;
    private $database = null;
    private $username = null;
    private $passwd = null;
 
    private $connection    = null;
    private $query      = null;

    // Guarda uma instância da classe
    private static $instance;

    private function __construct(){

    }

    // O método singleton 
    //peguei esse exemplo na internet 
    public static function getInstance() 
    {
        if (!isset(self::$instance)) {
            $c = __CLASS__;
            self::$instance = new $c;
        }

        return self::$instance;
    }

    //rola fazer assim a diferença dos bancos???

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
?>