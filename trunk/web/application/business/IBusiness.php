<?php

interface IBusiness {

    public function add(Model $model);
    public function find($id);
    public function save(Model $model);
    public function update(Model $model);

}
