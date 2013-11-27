<?php
require_once('Controller.php');
require_once(APPLICATION . '/config/IfspDatabase.php');
require_once(APPLICATION . '/models/Login.php');

class IndexController extends Controller {

	public function index() {
		$this->setLayout(LAYOUT . '/layout.php');
		$this->login = false;

        if ($_POST) {
    		$database = IfspDatabase::getInstance();
            $database->getPrematriculaCredentials();
            $database->connect();

            $login = $this->assemblyRequest();
        }
	}

    /**
     * Método para retorno popular objeto Login com dados inseridos pelo usuário
     *
     * @return Login
     */
    private function assemblyRequest() {
        $login = new Login();

        $login->setUsername($_POST['prontuario']);
        $login->setPasswd($_POST['passwd']);

        return $login;
    }
}