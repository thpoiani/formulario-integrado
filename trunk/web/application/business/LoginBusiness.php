<?php
	require_once("IfspDatabase.php");
	//inicia conexão com banco

	class LoginBussiness{
		private $user;
		private $passwd;
		private $query;

		connect();

		$user = $_POST[txtUser]; 
		$passwd= $_POST[txtSenha];

		$query = mysql_query("SELECT * FROM /*Colocar tabela aqui*/ WHERE /*Coluna de nome*/ = ''$user'' AND /*Coluna de senha*/ = ''$passwd''");

		public function validateLogin(){
	 
		if(!result()) echo "Dados invalidos inválidos";
		else {
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
	}
?>