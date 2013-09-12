<?php

class Respostas {
	private $id;
	private $prontuario;
	private $resposta;
	private $data;
	private $id_campo;
	private $id_grupo;

	public function getId() {
	    return $this->id;
	}

	public function setId($id) {
	    return $this->id = $id;
	}

	public function getProntuario() {
	    return $this->prontuario;
	}

	public function setProntuario($prontuario) {
	    return $this->prontuario = $prontuario;
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

	public function getIdCampo() {
	    return $this->id_campo;
	}

	public function setIdCampo($id_campo) {
	    return $this->id_campo = $id_campo;
	}

	public function getIdGrupo() {
	    return $this->id_grupo;
	}

	public function setIdGrupo($id_grupo) {
	    return $this->id_grupo = $id_grupo;
	}
}
