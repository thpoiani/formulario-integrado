<?php

class Categoria {
	private $id;
	private $titulo;
	private $descricao;
	private $status;
	private $data;
	private $id_formulario = array();

	public function getId() {
	    return $this->id;
	}

	public function setId($id) {
	    return $this->id = $id;
	}

	public function getTitulo() {
	    return $this->titulo;
	}

	public function setTitulo($titulo) {
	    return $this->titulo = $titulo;
	}

	public function getDescricao() {
	    return $this->descricao;
	}

	public function setDescricao($descricao) {
	    return $this->descricao = $descricao;
	}

	public function getStatus() {
	    return $this->status;
	}

	public function setStatus($status) {
	    return $this->status = $status;
	}

	public function getData() {
	    return $this->data;
	}

	public function setData($data) {
	    return $this->data = $data;
	}

	public function getIdFormulario() {
	    return $this->id_formulario;
	}

	public function setIdFormulario($id_formulario) {
	    return $this->id_formulario = $id_formulario;
	}
}
