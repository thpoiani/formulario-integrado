<?php
require_once('IBusiness.php');

abstract class Business implements IBusiness {

    protected static $database;

    public function save(Model $model) {
        if ($model->getId() > 0) {
            $this->update($model);
        } else {
            $this->add($model);
        }
    }

}
