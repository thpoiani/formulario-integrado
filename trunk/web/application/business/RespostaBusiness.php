<?php

require_once('Business.php');
require_once(APPLICATION . '/config/IfspDatabase.php');
require_once(APPLICATION . '/models/Resposta.php');

class RespostaBusiness extends Business {

    /**
     * Método para adicionar resposta ao banco
     * @param array $models
     */
    public function salvar($models) {
        if (is_array($models)) {
            foreach ($models as $model) {
                $this->add($model);
            }
        } else {
            throw new Exception("Erro ao persistir respostas.");
        }
    }

    /**
     * Método para adicionar resposta ao banco
     * @param Model $model Resposta
     */
    public function add(Model $model) {
        parent::$database = IfspDatabase::getInstance();
        parent::$database->connect();

        $query = "INSERT INTO resposta (alunoId, formularioId, campoId, resposta, data) VALUES ("
               . $model->getAlunoId() . ", " . $model->getFormularioId() . ", ". $model->getCampoId(). ", '"
               . $model->getResposta() . "', '" . $model->getData() . "');";

        parent::$database->query($query);
    }

    /**
     * Método para retornar resposta pelo id
     * @param  int $id
     * @return Resposta resposta
     */
    public function find($id) {
        throw new Exception("Método não implementado - Interface");
    }

    /**
     * Método para atualizar resposta no banco
     * @param Model $model Resposta
     */
    public function update(Model $model) {
        throw new Exception("Método não implementado - Interface");
    }

    // public function __destruct() {
    //     if (isset(parent::$database) && parent::$database->getConnection()) {
    //         parent::$database->close();
    //     }
    // }

}
