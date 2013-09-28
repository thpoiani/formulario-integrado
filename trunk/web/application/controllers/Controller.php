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
	 * @return [type] [description]
	 */
	public function getContent() {
		require_once($this->_view);
	}

}