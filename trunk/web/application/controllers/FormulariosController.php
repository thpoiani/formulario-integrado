<?php
require_once('Controller.php');
require_once(APPLICATION . '/business/FormularioBusiness.php');

class FormulariosController extends Controller{

    private $business;
    public $color;

    public function __construct() {
        if (!parent::isSession()) header("Location: /");
        $this->business = new FormularioBusiness();
    }

	public function index() {
        $this->setLayout(LAYOUT . '/layout.php');

        $this->formularios = $this->business->show();
        $this->color = $this->coresSortidas();
	}

	private function coresSortidas() {
		$color = array("turquoise", "asbestos", "alizarin", "peterriver", "carrot", "amethyst");
        shuffle($color);

        return $color;
	}
}

