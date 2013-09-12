<?php

class Campo {
	private $id;
	private $titulo;
	private $maxlength;
	private $regex;
	private $tipo;
	private $status;
	private $data;
	private $id_categoria = array();

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

	public function getMaxlength() {
	    return $this->maxlength;
	}

	public function setMaxlength($maxlength) {
	    return $this->maxlength = $maxlength;
	}

	public function getRegex() {
	    return $this->regex;
	}

	public function setRegex($regex) {
	    return $this->regex = $regex;
	}

	public function getTipo() {
	    return $this->tipo;
	}

	public function setTipo($tipo) {
	    return $this->tipo = $tipo;
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

	public function getIdCategoria() {
	    return $this->id_categoria;
	}

	public function setIdCategoria($id_categoria) {
	    return $this->id_categoria = $id_categoria;
	}
}
