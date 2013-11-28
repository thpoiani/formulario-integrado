<?php
require_once(APPLICATION . '/models/Model.php');

class Login extends Model {
	private $username;
	private $passwd;

	public function getUsername() {
        return $this->username;
    }

    public function setUsername($username) {
        $this->username = $username;
    }

    public function getPasswd() {
        return $passwd->passwd;
    }

    public function setPasswd($passwd) {
        $this->passwd = $passwd;
    }
}