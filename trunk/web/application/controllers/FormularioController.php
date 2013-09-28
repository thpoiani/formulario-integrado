<?php
require_once('Controller.php');

class FormularioController extends Controller {

	public function index() {
		$this->setLayout(LAYOUT . '/layout.php');
	}
}
