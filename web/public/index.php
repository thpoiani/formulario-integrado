<?php

/**
 * Definição de caminho para pasta application e layout
 */
define('APPLICATION', realpath(dirname(__FILE__) . '/../application'));
define('LAYOUT', realpath(APPLICATION . '/layout'));
define('UPLOAD', realpath(dirname(__FILE__) . '/../public/upload'));

/**
 * Recebimento dos parâmetros
 */
$parametros = getParams();

/**
 * Nome da classe
 * exemplo: IndexController
 */
$class = ucfirst($parametros[0]) . 'Controller';

/**
 * Caminho para o controller
 * exemplo: /controllers/IndexController.php
 */
$controller = APPLICATION . '/controllers/' . $class . '.php';

/**
 * Caminho para a view
 * exemplo: /views/index/index.php
 */
$view = APPLICATION . '/views/' . strtolower($parametros[0]) . '/' . strtolower($parametros[1]) . '.php';

/**
 * Acesso ao controller
 */
if (file_exists($controller)) {
	// incluir o arquivo caso exista
	require_once($controller);

	if (class_exists($class)) {
		// instanciar caso exista

		$controlador = new $class();
		$controlador->_view = null;

		if (method_exists($controlador, $parametros[1])) {
			// acessar action caso exista
			$reflection = new ReflectionMethod($controlador, $parametros[1]);

			if ($reflection->isPublic()) {
				// se o método for público, será considerado uma action e será executada
				$controlador->$parametros[1]();
				$controlador->_view = $view;
			} else {
				showError('Action deve ser pública.');
			}
		} else {
			showError('Action não encontrada.');
		}
	} else {
		showError('Classe não encontrada.');
	}
} else {
	showError('Controller não encontrado.');
}

/**
 * Função para tratamento de parâmetros passados pela URL
 * @return array()
 */
function getParams() {
	// cria um índice no array aonde existir '/'
	$parametros = explode('/', substr($_SERVER['REQUEST_URI'], 1));

	// controller
	if (empty($parametros[0])) {
		$parametros[0] = 'index';
	} else {
		// converte para lowercase
		$parametros[0] = strtolower($parametros[0]);
	}

	// action
	if (empty($parametros[1])) {
		$parametros[1] = 'index';
	} else {
		// converte para lowercase
		$parametros[1] = strtolower($parametros[1]);
	}
	return $parametros;
}

/**
 * Método responsável por exibir mensagem de erro
 * @param  string $mensagem
 * @return void
 */
function showError($mensagem) {
	require_once(APPLICATION . '/controllers/ErrorController.php');

	$error = new ErrorController();
	$error->index();
	$error->_mensagem = $mensagem;
	$error->_view = APPLICATION . '/views/error/index.php';
}