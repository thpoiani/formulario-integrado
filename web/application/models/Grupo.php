<?php

class Grupo {
	private $id;
	private $titulo;
	private $tipo;
	private $data;
	private $id_campo = array();

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

	public function getTipo() {
	    return $this->tipo;
	}

	public function setTipo($tipo) {
	    return $this->tipo = $tipo;
	}

	public function getData() {
	    return $this->Data;
	}

	public function setData($Data) {
	    return $this->Data = $Data;
	}

	public function getIdCampo() {
	    return $this->id_campo;
	}

	public function setIdCampo($id_campo) {
	    return $this->id_campo = $id_campo;
	}
}
