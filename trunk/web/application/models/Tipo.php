<?php
require_once(APPLICATION . '/models/Model.php');

class Tipo extends Model {

    private $id;
    private $descricao;

    public function getId() {
        return $this->id;
    }

    public function setId($id) {
        return $this->id = $id;
    }

    public function getDescricao() {
        return $this->descricao;
    }

    public function setDescricao($descricao) {
        return $this->descricao = $descricao;
    }

}