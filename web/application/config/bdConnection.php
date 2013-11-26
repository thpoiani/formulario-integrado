<?php
class conectar_banco {
 
    //alterar os dados para a conexão
    private $host       = 'localhost';
    private $usuario    = 'admin';
    private $senha      = 'admin';
    private $banco      = 'formularioIntegrado';
 
    private $conexao    = null;
    private $query      = null;
 
    /**
    * Metodo para conexaõ com o banco
    */
    public function connect() {
        $this->conexao = mysql_connect($this->host, $this->usuario, $this->senha);
        $status = mysql_select_db($this->banco, $this->conexao);
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
       if($this->conexao != null){
        mysql_close($this->conexao);
       }
    }
}
?>