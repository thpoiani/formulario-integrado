<?php
require_once('Controller.php');
require_once(APPLICATION . '/business/FormularioBusiness.php');

class FormularioController extends Controller {

    private $business;

    public function __construct() {
        if (!parent::isSession()) header("Location: /");
        if (!$this->hasParameter()) header("Location: /formularios");

        $this->business = new FormularioBusiness();
    }

    public function index() {
        $this->setLayout(LAYOUT . '/layout.php');

        // Formulario retorna à view
        $this->formulario = $this->business->obterFormularioCompleto($_GET['id']);

        // print_r(utf8_encode($this->formulario->getTitulo()));die();
        print_r($this->formulario);die();

    }

    /**
     * Método para verificar se existe parametro id
     * @return boolean
     */
    private function hasParameter() {
        return $_GET && $_GET['id'] > 0;
    }
}
