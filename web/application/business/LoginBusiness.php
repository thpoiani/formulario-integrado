<?php
require_once('Business.php');
require_once(APPLICATION . '/config/IfspDatabase.php');
require_once(APPLICATION . '/models/Login.php');
require_once(APPLICATION . '/models/Aluno.php');

class LoginBusiness extends Business {

    public function validate(Login $login) {
        parent::$database = IfspDatabase::getInstance();
        parent::$database->getPrematriculaCredentials();
        parent::$database->connect();

        $aluno = new Aluno();

        parent::$database->query("SELECT * FROM pm_pessoas WHERE prontuario = '" . $login->getUsername() . "' AND senha = '" . $login->getPasswd()  . "'");

		if ($resultado = parent::$database->result()) {
            return $this->assembly($aluno, $resultado);
        } else {
            throw new Exception("Falha de autenticação");
        }
	}

    public function add(Model $aluno) {
        parent::$database = IfspDatabase::getInstance();
        parent::$database->getInterativoCredentials();
        parent::$database->connect();

        $query = "INSERT INTO aluno (prontuario, nome) VALUES ('" . $aluno->getProntuario() . "','" . $aluno->getNome() . "')";

        return parent::$database->query($query);
    }

    /**
     * Método para alterar estado da sessão
     * @param  Aluno $aluno
     * @return void
     */
    public function session(Aluno $aluno = null) {
        // se não existe sessão correta
        if (!isset($_SESSION['prontuario'])) {
            // inicia sessão
            session_start();

            // armazena variáveis em sessão
            $_SESSION['id'] = $aluno->getId();
            $_SESSION['prontuario'] = $aluno->getProntuario();
            $_SESSION['nome'] = $aluno->getNome();
        } else {
            // retira as variáveis da sessão
            $_SESSION = array();

            // destrói sessão
            session_destroy();
        }

    }

    public function find($id) {
        throw new Exception("Método não implementado - Interface");
    }

    public function update(Model $update) {
        throw new Exception("Método não implementado - Interface");
    }

    public function __destruct() {
        if (isset(parent::$database) && parent::$database->getConnection()) {
            parent::$database->close();
        }
    }

    /**
     * Método para popular um Aluno
     * @param  Aluno $aluno
     * @param  row $resultado
     */
    private function assembly(Aluno $aluno, $resultado) {
        $aluno->setId($resultado['id']);
        $aluno->setProntuario($resultado['prontuario']);
        $aluno->setNome($resultado['nome']);
        return $aluno;
    }
}