<?php

class formulario {
	private $id;
	private $titulo;
	private $cabecalho;
	private $rodape;
	private $status;
	private $aberto;
	private $data;

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

	public function getCabecalho() {
	    return $this->cabecalho;
	}

	public function setCabecalho($cabecalho) {
	    return $this->cabecalho = $cabecalho;
	}

	public function getRodape() {
	    return $this->rodape;
	}

	public function setRodape($rodape) {
	    return $this->rodape = $rodape;
	}

	public function getStatus() {
	    return $this->status;
	}

	public function setStatus($status) {
	    return $this->status = $status;
	}

	public function getAberto() {
	    return $this->aberto;
	}

	public function setAberto($aberto) {
	    return $this->aberto = $aberto;
	}

	public function getData() {
	    return $this->data;
	}

	public function setData($data) {
	    return $this->data = $data;
	}
}
