<?php
require_once('Business.php');
require_once(APPLICATION . '/config/IfspDatabase.php');

class FormularioBusiness extends Business {

    public function __construct() {
        parent::$database = IfspDatabase::getInstance();
        parent::$database->connect();
    }

    public function add(Model $model) {

    }

    public function find($id) {
        $query = "SELECT * FROM formulario";
        parent::$database->query($query);

        while ($row = parent::$database->result()) {
            print_r($row);
        }

    }

    public function update(Model $model) {

    }

    public function __destruct() {
        parent::$database->close();
    }

}
