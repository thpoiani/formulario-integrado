<?php
require_once(APPLICATION . '/models/Model.php');

class Aluno extends Model {

    private $id;
    private $prontuario;
    private $nome;
    private $respostas;

    public function getId() {
        return $this->id;
    }

    public function setId($id) {
        $this->id = $id;
    }

    public function getProntuario() {
        return $this->prontuario;
    }

    public function setProntuario($prontuario) {
        $this->prontuario = $prontuario;
    }

    public function getNome() {
        return $this->nome;
    }

    public function setNome($nome) {
        $this->nome = $nome;
    }

    public function getRespostas() {
        return $this->respostas;
    }

    public function setRespostas($respostas) {
        $this->respostas = $respostas;
    }

}