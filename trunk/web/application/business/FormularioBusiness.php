<?php
require_once('Business.php');
require_once('CategoriaBusiness.php');
require_once(APPLICATION . '/config/IfspDatabase.php');
require_once(APPLICATION . '/models/Formulario.php');
require_once(APPLICATION . '/models/Categoria.php');

class FormularioBusiness extends Business {

    /**
     * Método para retornar formulário completo, contendo categorias e campos, pelo id
     * @param  int $id
     * @return Formulario formulario
     */

    public function obterFormularioCompleto($id) {
        parent::$database = IfspDatabase::getInstance();
        parent::$database->connect();

        $formulario = new Formulario();

        $query = "SELECT fc.formularioId, fc.categoriaId, fc.ordem "
               . "FROM formulario_categoria fc INNER JOIN formulario f ON fc.formularioId = f.id AND f.status = 1 AND f.aberto = 1 "
               . "INNER JOIN categoria c ON fc.categoriaId = c.id AND c.status = 1 "
               . "WHERE fc.formularioId = " . $id;

        parent::$database->query($query);

        // armazena resultados da query
        $resultados = array();
        while ($resultado = parent::$database->result()) {
            $resultados[] = $resultado;
        }

        // se existirem resultados
        if (count($resultados) > 0) {
            $categoriaBusiness = new CategoriaBusiness();
            $categorias = array();

            // recupera formulario
            $formulario = $this->find($id);

            // recupera categorias desse formulario
            foreach ($resultados as $resultado){
                $categoria = new Categoria();
                $categoria = $categoriaBusiness->obterCategoriaCompleta($resultado['categoriaId']);

                // adiciona a categoria a uma lista
                array_push($categorias, $categoria);
            }

            $formulario->setCategorias($categorias);
        }

        return $formulario;
    }

    /**
     * Método para retornar formulário pelo id
     * @param  int $id
     * @return Formulario formulario
     */
    public function find($id) {
        parent::$database = IfspDatabase::getInstance();
        parent::$database->connect();

        $formulario = new Formulario();

        $query = "SELECT f.id, f.titulo, f.aberto, f.status, f.data "
               . "FROM formulario f WHERE f.aberto = 1 AND f.status = 1 AND f.id = " . $id;

        parent::$database->query($query);

        if ($resultado = parent::$database->result()) {
            $this->assembly($formulario, $resultado);
        }

        return $formulario;
    }

    /**
     * Método para retornar formulários ativos
     * @return Formulario formulario
     */
    public function show() {
        parent::$database = IfspDatabase::getInstance();
        parent::$database->connect();

        $formularios = array();

        $query = "SELECT f.id, f.titulo, f.aberto, f.status, f.data "
               . "FROM formulario f WHERE f.aberto = 1 AND f.status = 1";

        parent::$database->query($query);

        while ($resultado = parent::$database->result()) {
            $formulario = new Formulario();
            $this->assembly($formulario, $resultado);

            array_push($formularios, $formulario);
        }

        return $formularios;
    }


    /**
     * Método para adicionar formulário ao banco
     * @param Model $model Formulario
     */
    public function add(Model $model) {
        throw new Exception("Método não implementado - Interface");
    }

    /**
     * Método para atualizar formulário no banco
     * @param Model $model Formulario
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
     * Método para popular um Formulario
     * @param  Formulario $formulario
     * @param  row $resultado
     */
    private function assembly(Formulario $formulario, $resultado) {
        $formulario->setId($resultado['id']);
        $formulario->setTitulo($resultado['titulo']);
        $formulario->setAberto($resultado['aberto']);
        $formulario->setStatus($resultado['status']);
        $formulario->setData($resultado['data']);
    }
}
