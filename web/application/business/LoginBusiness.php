<?php
	require_once("IfspDatabase.php");
	require_once(APPLICATION . '/models/Login.php');
	//inicia conexão com banco

	class LoginBussiness extends IfspDatabase{
		private $User;
		private $UserPasswd;
 
		public function validateLogin(Login $login){

			$this->database = IfspDatabase::getInstance();
	        $this->database->getPrematriculaCredentials();
	        $this->database->connect();

	        $user = $login->getUsername();
	        $UserPasswd = $login->getPasswd();

	        $this->database->query("SELECT * FROM /*Colocar tabela aqui*/ WHERE /*Coluna de nome*/ = ''$user'' AND /*Coluna de senha*/ = ''$UserPasswd''");
		 
			if($this->database->result()) {
				//PEGA OS DADOS 
				$id = mysql_result($query, 0, /*coluna usuario*/); 
				$usuario = mysql_result($query, 0, /*coluna senha*/);

				//Iniciar a sessão 
				session_start();
				//gravar valiaveis na sessão
				$_SESSION[id] = $id;
				$_SESSION[usuario] = $usuario;
				//redirecionar para view formularios
				Header("Location: view/formularios/index.php");	
			}
			$database->close();
	}
?>