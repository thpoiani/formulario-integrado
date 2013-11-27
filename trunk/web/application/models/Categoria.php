<?php
require_once(APPLICATION . '/models/Model.php');

class Categoria extends Model {

    private $id;
    private $titulo;
    private $descricao;
    private $status;
    private $data;
    private $ordem;
    private $formularios = array();
    private $campos = array();

    public function getId() {
        return $this->id;
    }

    public function setId($id) {
        $this->id = $id;
    }

    public function getTitulo() {
        return $this->titulo;
    }

    public function setTitulo($titulo) {
        $this->titulo = $titulo;
    }

    public function getDescricao() {
        return $this->descricao;
    }

    public function setDescricao($descricao) {
        $this->descricao = $descricao;
    }

    public function isStatus() {
        return $this->status;
    }

    public function setStatus($status) {
        $this->status = $status;
    }

    public function getData() {
        return $this->data;
    }

    public function setData($data) {
        $this->data = $data;
    }

    public function getOrdem() {
        return $this->ordem;
    }

    public function setOrdem($ordem) {
        $this->ordem = $ordem;
    }

    public function getFormularios() {
        return $this->formularios;
    }

    public function setFormularios($formularios) {
        $this->formularios = $formularios;
    }

    public function getCampos() {
        return $this->campos;
    }

    public function setCampos($campos) {
        $this->campos = $campos;
    }
}