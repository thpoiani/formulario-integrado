<?php
require_once(APPLICATION . '/models/Model.php');

class Formulario extends Model {

    private $id;
    private $titulo;
    private $aberto;
    private $status;
    private $data;
    private $categorias = array();

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

    public function isAberto() {
        return $this->aberto;
    }

    public function setAberto($aberto) {
        $this->aberto = $aberto;
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

    public function getCategorias() {
        return $this->categorias;
    }

    public function setCategorias($categorias) {
        $this->categorias = $categorias;
    }
}