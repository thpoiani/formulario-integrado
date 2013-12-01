<?php

require_once('Business.php');
require_once(APPLICATION . '/config/IfspDatabase.php');
require_once(APPLICATION . '/models/Campo.php');

class CampoBusiness extends Business {

    /**
     * Método para retornar campo pelo id
     * @param  int $id
     * @return Campo campo
     */
    public function find($id) {
        parent::$database = IfspDatabase::getInstance();
        parent::$database->connect();

        $campo = new Campo();

        $query = "SELECT c.id, c.titulo, c.maxlength, c.regex, c.status, c.ordem, c.data, c.categoriaId, c.tipoId "
               . "FROM campo c WHERE c.id = " . $id;

        parent::$database->query($query);

        if ($resultado = parent::$database->result()) {
            $this->assembly($campo, $resultado);
        }

        return $campo;
    }

    /**
     * Método para adicionar campo ao banco
     * @param Model $model Campo
     */
    public function add(Model $model) {
        throw new Exception("Método não implementado - Interface");
    }

    /**
     * Método para atualizar campo no banco
     * @param Model $model Campo
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
     * Método para popular um Campo
     * @param  Campo $campo
     * @param  row $resultado
     */
    private function assembly(Campo $campo, $resultado) {
        $campo->setId($resultado['id']);
        $campo->setTitulo($resultado['titulo']);
        $campo->setMaxlength($resultado['maxlength']);
        $campo->setRegex($resultado['regex']);
        $campo->setStatus($resultado['status']);
        $campo->setOrdem($resultado['ordem']);
        $campo->setData($resultado['data']);
        $campo->setCategoriaId($resultado['categoriaId']);
        $campo->setTipoId($resultado['tipoId']);
    }

}
