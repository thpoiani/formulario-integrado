<?php
require_once('Controller.php');
require_once(APPLICATION . '/business/FormularioBusiness.php');

class FormulariosController extends Controller{

    private $business;

    public function __construct() {
        if (!parent::isSession()) header("Location: /");

        $this->business = new FormularioBusiness();
    }

	public function index() {
		$this->setLayout(LAYOUT . '/layout.php');
	}
}

