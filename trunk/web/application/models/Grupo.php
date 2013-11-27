<?php
require_once(APPLICATION . '/models/Model.php');

class Grupo extends Model {

    private $id;
    private $titulo;
    private $data;
    private $ordem;
    private $status;

    private $campoId;
    private $campo;

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

    public function isStatus() {
        return $this->status;
    }

    public function setStatus($status) {
        $this->status = $status;
    }

    public function getCampo() {
        return $this->campo;
    }

    public function setCampo($campo) {
        $this->campo = $campo;
    }

    public function getCampoId() {
        return $this->campoId;
    }

    public function setCampoId($campoId) {
        $this->campoId = $campoId;
    }
}