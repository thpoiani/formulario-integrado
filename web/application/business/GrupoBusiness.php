<?php

require_once('Business.php');
require_once(APPLICATION . '/config/IfspDatabase.php');
require_once(APPLICATION . '/models/Grupo.php');

class GrupoBusiness extends Business {

    /**
     * Método para retornar grupo pelo id
     * @param  int $id
     * @return Grupo grupo
     */
    public function find($id) {
        parent::$database = IfspDatabase::getInstance();
        parent::$database->connect();

        $grupo = new Grupo();

        $query = "SELECT g.id, g.titulo, g.data, g.ordem, g.status, g.campoId "
               . "FROM grupo g WHERE g.id = " . $id;

        parent::$database->query($query);

        if ($resultado = parent::$database->result()) {
            $this->assembly($grupo, $resultado);
        }

        return $grupo;
    }

    /**
     * Método para adicionar grupo ao banco
     * @param Model $model Grupo
     */
    public function add(Model $model) {
        throw new Exception("Método não implementado - Interface");
    }

    /**
     * Método para atualizar grupo no banco
     * @param Model $model Grupo
     */
    public function update(Model $model) {
        throw new Exception("Método não implementado - Interface");
    }

    public function __destruct() {
        if (isset(parent::$database) && parent::$database->getConnection()) {
            parent::$database->close();
        }
    }

    /**
     * Método para popular um Grupo
     * @param  Grupo $grupo
     * @param  row $resultado
     */
    private function assembly(Grupo $grupo, $resultado) {
        $query = "SELECT g.id, g.titulo, g.data, g.ordem, g.status, g.campoId "

        $grupo->setId($resultado['id']);
        $grupo->setTitulo($resultado['titulo']);
        $grupo->setData($resultado['data']);
        $grupo->setOrdem($resultado['ordem']);
        $grupo->setStatus($resultado['status']);
        $grupo->setCampoId($resultado['campoId']);
    }

}
