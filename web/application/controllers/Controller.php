<?php

class Controller {

	public $_view;
	public $_layout;
	public $_content;

	/**
	 * Método destruidor, executado para incluir view
	 */
	public function __destruct() {
		if (isset($this->_view) && !empty($this->_view) && file_exists($this->_view) && !$this->_layout) {
			require_once($this->_view);
		} elseif ($this->_layout) {
			require_once($this->_layout);
		}
	}

	/**
	 * Método para inserir layout à view
	 * @param $layout
	 */
	public function setLayout($layout) {
	    return $this->_layout = $layout;
	    return $this;
	}

	/**
	 * Método para retornar à view aos
	 * @return void
	 */
	public function getContent() {
		require_once($this->_view);
	}


    /**
     * Método para verificar se sessão existe
     * @return boolean
     */
    public function isSession() {
        session_start();
        return $this->login = isset($_SESSION['prontuario']);
    }

    /**
     * Método para exibir mensagem de saudação dependendo do horário
     * Nomenclatura helper pois é usado na view
     * @return string
     */
    public function helperShowDate() {
        date_default_timezone_set('America/Sao_Paulo');
        $date = new DateTime();
        $hora = $date->format('H');

        if ($hora < "12") {
            return "Bom dia";
        } else if ($hora >= "12" && $hora < "17") {
            return "Boa tarde";
        } else {
            return "Boa noite";
        }
    }

}
