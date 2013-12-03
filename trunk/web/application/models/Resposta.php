<?php
require_once(APPLICATION . '/models/Model.php');

class Resposta extends Model {

    private $alunoId;
    private $formularioId;
    private $campoId;
    private $resposta;
    private $data;

    public function getAlunoId() {
        return $this->alunoId;
    }

    public function setAlunoId($alunoId) {
        return $this->alunoId = $alunoId;
    }

    public function getFormularioId() {
        return $this->formularioId;
    }

    public function setFormularioId($formularioId) {
        return $this->formularioId = $formularioId;
    }

    public function getCampoId() {
        return $this->campoId;
    }

    public function setCampoId($campoId) {
        return $this->campoId = $campoId;
    }

    public function getResposta() {
        return $this->resposta;
    }

    public function setResposta($resposta) {
        return $this->resposta = $resposta;
    }

    public function getData() {
        return $this->data;
    }

    public function setData($data) {
        return $this->data = $data;
    }

}