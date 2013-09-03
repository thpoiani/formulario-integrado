<?php
require_once('Controller.php');

class HomeController extends Controller {

	public function index() {
		require_once(APPLICATION . '/models/Usuario.php');

		$usuario = new Usuario();
		$usuario->setNome("Thiago");

		// retorno variável à view
		// $this->var = "Exemplo de Formulário POST";
		$this->var = $usuario->getNome();
	}

	public function salvar() {
		// requisição POST
		if ($_POST) {
			// name do input
			$nome = $_POST["nome"];
			echo $nome;
		}
	}

	public function ajax() {
		header('Content type: application/json');

		// requisição POST
		if ($_POST) {
			// name do input
			echo json_encode($_POST["nome"]);
		}
	}
}
