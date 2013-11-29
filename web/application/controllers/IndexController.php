<?php
require_once('Controller.php');
require_once(APPLICATION . '/business/LoginBusiness.php');
require_once(APPLICATION . '/models/Login.php');
require_once(APPLICATION . '/models/Aluno.php');

class IndexController extends Controller {

    private $business;

    public function __construct() {
        $this->business = new LoginBusiness();
    }

	public function index() {
        if (parent::isSession()) header("Location: /formularios");

		$this->setLayout(LAYOUT . '/layout.php');

        if ($_POST) {
            $aluno = new Aluno();
            $login = new Login();

            try {
                $this->assemblyRequest($login);
                $aluno = $this->business->validate($login);

                if ($aluno->getId() > 0) {
                    $this->business->add($aluno);
                }

                $this->business->session($aluno);

                header("Location: /formularios");
            } catch (Exception $e) {
                $this->message = $e->getMessage();
                // retorno de mensagem de erro
            }
        }
	}

    public function logout() {
        if (parent::isSession()) {
            $this->business->session();
            header("Location: /");
        }
    }

    /**
     * Método para retorno popular objeto Login com dados inseridos pelo usuário
     *
     * @param  Login $login
     * @return Login
     */
    private function assemblyRequest(Login $login) {
        $login->setUsername($_POST['prontuario']);
        $login->setPasswd($_POST['passwd']);
    }
}