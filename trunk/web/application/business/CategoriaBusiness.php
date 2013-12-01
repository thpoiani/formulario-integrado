<?php

require_once('Business.php');
require_once('CampoBusiness.php');
require_once(APPLICATION . '/config/IfspDatabase.php');
require_once(APPLICATION . '/models/Categoria.php');
require_once(APPLICATION . '/models/Campo.php');

class CategoriaBusiness extends Business {

    public function obterCategoriaCompleta($id) {
        parent::$database = IfspDatabase::getInstance();
        parent::$database->connect();

        $categoria = new Categoria();

        // campos dessa categoria
        $query = "SELECT c.id, c.titulo, c.maxlength, c.regex, c.status, c.ordem, c.data, c.categoriaId, c.tipoId "
               . "FROM campo c INNER JOIN categoria cat ON c.categoriaId = cat.id AND cat.status = 1 "
               . "WHERE cat.id = " . $id;

        parent::$database->query($query);

        // armazena resultados da query
        $resultados = array();
        while ($resultado = parent::$database->result()) {
            $resultados[] = $resultado;
        }

        // se existirem resultados
        if (count($resultados) > 0) {
            $campoBusiness = new CampoBusiness();
            $campos = array();

            // recupera categoria
            $categoria = $this->find($id);

            // recupera campos dessa categoria
            foreach ($resultados as $resultado) {
                $campo = new Campo();
                $campo = $campoBusiness->find($resultado['id']);

                // adiciona a categoria a uma lista
                array_push($campos, $campo);
            }

            $categoria->setCampos($campos);
        }


        return $categoria;
    }

    /**
     * Método para retornar categoria pelo id
     * @param  int $id
     * @return Categoria categoria
     */
    public function find($id) {
        parent::$database = IfspDatabase::getInstance();
        parent::$database->connect();

        $categoria = new Categoria();

        $query = "SELECT c.id, c.titulo, c.descricao, c.status, c.data "
               . "FROM categoria c WHERE c.status = 1 AND c.id = " . $id;

        parent::$database->query($query);

        if ($resultado = parent::$database->result()) {
            $this->assembly($categoria, $resultado);
        }

        return $categoria;
    }

    /**
     * Método para adicionar categoria ao banco
     * @param Model $model Categoria
     */
    public function add(Model $model) {
        throw new Exception("Método não implementado - Interface");
    }

    /**
     * Método para atualizar categoria no banco
     * @param Model $model Categoria
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
     * Método para popular um Categoria
     * @param  Categoria $categoria
     * @param  row $resultado
     */
    private function assembly(Categoria $categoria, $resultado) {
        $categoria->setId($resultado['id']);
        $categoria->setTitulo($resultado['titulo']);
        $categoria->setDescricao($resultado['descricao']);
        $categoria->setStatus($resultado['status']);
        $categoria->setData($resultado['data']);
    }

}
