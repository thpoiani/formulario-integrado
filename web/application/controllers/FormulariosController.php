<?php
require_once('Controller.php');

class FormulariosController extends Controller{

	public function index() {
		$this->setLayout(LAYOUT . '/layout.php');
		$this->login = true;
	}
}

