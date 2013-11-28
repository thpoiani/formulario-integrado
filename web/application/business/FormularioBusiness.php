<?php
require_once('Business.php');
require_once(APPLICATION . '/config/IfspDatabase.php');
require_once(APPLICATION . '/models/Formulario.php');

class FormularioBusiness extends Business {

    public function __construct() {
        parent::$database = IfspDatabase::getInstance();
        parent::$database->connect();
    }

    /**
     * Método para adicionar formulário ao banco
     * @param Model $model Formulario
     */
    public function add(Model $model) {

    }

    /**
     * Método para retornar formulário pelo id
     * @param  int $id
     * @return Formulario formulario
     */
    public function find($id) {
        $formulario = new Formulario();

        $query = "SELECT f.id, f.titulo, f.aberto, f.status, f.data "
                ." FROM formulario f WHERE id = " . $id;

        parent::$database->query($query);

        if ($resultado = parent::$database->result()) {
            $this->assembly($formulario, $resultado);
        }

        return $formulario;
    }

    public function update(Model $model) {

    }

    public function __destruct() {
        parent::$database->close();
    }

    /**
     * Método para popular um Formulario
     * @param  Formulario $formulario
     * @param  row $resultado
     * @return Formulario
     */
    private function assembly(Formulario $formulario, $resultado) {
        $formulario->setId($resultado['id']);
        $formulario->setTitulo($resultado['titulo']);
        $formulario->setAberto($resultado['aberto']);
        $formulario->setStatus($resultado['status']);
        $formulario->setData($resultado['data']);
    }
}
