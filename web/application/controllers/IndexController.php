<?php
require_once('Controller.php');
require_once(APPLICATION . '/config/IfspDatabase.php');

class IndexController extends Controller {

	public function index() {
		$this->setLayout(LAYOUT . '/layout.php');
		$this->login = false;
		//passar $_post txt user e senha para model ???

		//chama assim o metodo ou so validateLogin() por conta do require_once???
		$database = IfspDatabase::getInstance();
	}
}