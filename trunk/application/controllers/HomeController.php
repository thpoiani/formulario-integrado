<?php
require_once('Controller.php');

class HomeController extends Controller {

	public function index() {
		// retorno variável à view
		$this->var = "Exemplo de Formulário POST";
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
