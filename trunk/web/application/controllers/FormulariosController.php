<?php
require_once('Controller.php');
require_once(APPLICATION . '/business/FormularioBusiness.php');

class FormulariosController extends Controller{

    private $business;
    private $formsList;

    public function __construct() {
        if (!parent::isSession()) header("Location: /");

        $this->business = new FormulariosBusiness();
    }

    public function populateForms(){
    	$this->formsList = $this->business->getFormsList();
    	
    }

	public function index() {
		$this->setLayout(LAYOUT . '/layout.php');
	}

	private function coresSortidas() {
		$color = array("turquoise", "asbestos", "alizarin", "peterriver");
        return shuffle($color);            
	}
}

