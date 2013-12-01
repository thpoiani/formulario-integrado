<?php

require_once('Business.php');
require_once(APPLICATION . '/config/IfspDatabase.php');
require_once(APPLICATION . '/models/Tipo.php');

class TipoBusiness extends Business {

    /**
     * Método para retornar tipo pelo id
     * @param  int $id
     * @return Tipo tipo
     */
    public function find($id) {
        parent::$database = IfspDatabase::getInstance();
        parent::$database->connect();

        $tipo = new Tipo();

        $query = "SELECT t.id, t.descricao FROM tipo t WHERE t.id = " . $id;

        parent::$database->query($query);

        if ($resultado = parent::$database->result()) {
            $this->assembly($tipo, $resultado);
        }

        return $tipo;
    }

    /**
     * Método para adicionar tipo ao banco
     * @param Model $model Tipo
     */
    public function add(Model $model) {
        throw new Exception("Método não implementado - Interface");
    }

    /**
     * Método para atualizar tipo no banco
     * @param Model $model Tipo
     */
    public function update(Model $model) {
        throw new Exception("Método não implementado - Interface");
    }

    // public function __destruct() {
    //     if (isset(parent::$database) && parent::$database->getConnection()) {
    //         parent::$database->close();
    //     }
    // }

    /**
     * Método para popular um Tipo
     * @param  Tipo $tipo
     * @param  row $resultado
     */
    private function assembly(Tipo $tipo, $resultado) {
        $tipo->setId($resultado['id']);
        $tipo->setDescricao($resultado['descricao']);
    }

}
