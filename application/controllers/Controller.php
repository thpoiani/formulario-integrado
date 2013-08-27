<?php

class Controller {

	public $_view;

	/**
	 * Método destruidor, executado para incluir view
	 */
	public function __destruct() {
		$header = apache_response_headers();

		if (isset($this->_view) && !empty($this->_view) && file_exists($this->_view)) {
			require_once($this->_view);
		}
	}
}