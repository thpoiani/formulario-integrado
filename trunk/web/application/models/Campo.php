<?php
require_once(APPLICATION . '/models/Model.php');

class Campo extends Model {

    private $id;
    private $titulo;
    private $maxlength;
    private $regex;
    private $status;
    private $ordem;
    private $data;

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

    public function getMaxlength() {
        return $this->maxlength;
    }

    public function setMaxlength($maxlength) {
        $this->maxlength = $maxlength;
    }

    public function isStatus() {
        return $this->status;
    }

    public function setStatus($status) {
        $this->status = $status;
    }

    public function getOrdem() {
        return $this->ordem;
    }

    public function setOrdem($ordem) {
        $this->ordem = $ordem;
    }

    public function getData() {
        return $this->data;
    }

    public function setData($data) {
        $this->data = $data;
    }

}