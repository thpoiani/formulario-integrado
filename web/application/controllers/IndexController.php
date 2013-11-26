<?php
require_once('Controller.php');
require_once('config\validate.php');

class IndexController extends Controller {

	public function index() {
		$this->setLayout(LAYOUT . '/layout.php');
		$this->login = false;
		validateForm();
	}
}