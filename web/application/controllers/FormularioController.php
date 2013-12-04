<?php
require_once('Controller.php');
require_once(APPLICATION . '/business/FormularioBusiness.php');
require_once(APPLICATION . '/business/RespostaBusiness.php');
require_once(APPLICATION . '/config/PHPMailer/class.phpmailer.php');
require_once(APPLICATION . '/models/Resposta.php');
require_once(APPLICATION . '/models/Categoria.php');

class FormularioController extends Controller {

    private $business;
    private $mail;

    public function __construct() {
        if (!parent::isSession()) header("Location: /");

        $this->business = new FormularioBusiness();
    }

    public function index() {
        if (!$this->hasParameter()) header("Location: /formularios");

        $this->setLayout(LAYOUT . '/layout.php');

        // Formulario retorna à view
        $this->formulario = $this->business->obterFormularioCompleto($_GET['id']);

        if ($this->formulario->getId() == null) header("Location: /formularios");
    }

    public function salvar() {
        if ($_POST) {
            $respostaBusiness = new RespostaBusiness();
            $formularioId = $_POST['formulario'];
            $formulario = $this->business->find($formularioId);

            // remove elemento refere ao formulário, para ficar apenas com as respostas
            unset($_POST['formulario']);

            $respostas = array();

            foreach ($_FILES as $key => $value) {
                $_POST[$key] = $this->uploadFile($formularioId, $key);
            }

            foreach ($_POST as $key => $value) {
                $resposta = new Resposta();
                $this->assemblyRequest($resposta, $formularioId, $key, $value);
                array_push($respostas, $resposta);
            }
            try {
                $respostaBusiness->salvar($respostas);

                $this->sendEmail(array(
                    'email' => $_SESSION['email'],
                    'formulario' => $formulario->getTitulo(),
                    'usuario' =>  $_SESSION['nome'],
                    'isAluno' => true
                ));

                $this->sendEmail(array(
                    'email' => 'formulario.interativo.ifsp@gmail.com',
                    'formulario' => $formulario->getTitulo(),
                    'usuario' =>  $_SESSION['nome'],
                    'prontuario' =>  $_SESSION['prontuario'],
                    'isAluno' => false
                ));

                header("Location: /formularios");
            } catch (Exception $e) {
                header("Location: /formularios/index/?id=" . $formularioId);
            }
        } else {
            header("Location: /formularios");
        }
    }

    private function assemblyRequest(Resposta $model, $formularioId, $campoId, $resposta) {
        $data = new DateTime();

        $model->setAlunoId($_SESSION['id']);
        $model->setFormularioId($formularioId);
        $model->setCampoId($campoId);
        $model->setResposta(utf8_decode($resposta));
        $model->setData($data->format('Y-m-d H:i:s'));
    }

    /**
    * Metodo que seta configurações para o envio de
    * E-mail por SMTP autenticado
    */
    private function sendEmail($dados) {
        $this->mail = new PHPMailer();
        $this->mail->IsSMTP();
        $this->mail->SMTPAuth = true;
        $this->mail->SMTPSecure = 'tls';

        $this->mail->Port = 587;
        $this->mail->Host = 'smtp.gmail.com';
        $this->mail->Username = 'formulario.interativo.ifsp@gmail.com';
        $this->mail->Password = 'ads640ifsp';
        $this->mail->setFrom('formulario.interativo.ifsp@gmail.com', 'IFSP');


        if ($dados['isAluno']) {
            $body = file_get_contents(APPLICATION . '/config/PHPMailer/emailaluno.php');
            $body = str_replace('$usuario', utf8_encode($dados['usuario']), $body);
            $body = str_replace('$formulario', utf8_encode($dados['formulario']), $body);
            $this->mail->Subject = utf8_decode('Confirmação de envio de Formulário - IFSP São Carlos');
        } else {
            $body = file_get_contents(APPLICATION . '/config/PHPMailer/emailsamira.php');
            $body = str_replace('$aluno', utf8_encode($dados['usuario']), $body);
            $body = str_replace('$prontuario', utf8_encode($dados['prontuario']), $body);
            $body = str_replace('$formulario', utf8_encode($dados['formulario']), $body);
            $this->mail->Subject = utf8_decode('Formulário respondido - IFSP São Carlos');
        }

        $this->mail->isHTML(true);
        $this->mail->addAddress($dados['email']);
        $this->mail->Body = utf8_decode($body);

        return $this->mail->send();
    }

    private function uploadFile($formularioId, $key){
         if ($_FILES[$key]) {
            $file = $_FILES[$key];

            $fileName = explode('.', $file['name']);
            $newFileName = $_SESSION['id'] . '_' . $formularioId . '_' .$key . '.' . strtolower(end($fileName));

            $upload = move_uploaded_file($file['tmp_name'], UPLOAD . DIRECTORY_SEPARATOR . $newFileName);

            return $newFileName;
       }
    }


    /**
     * Método para verificar se existe parametro id
     * @return boolean
     */
    private function hasParameter() {
        return $_GET && $_GET['id'] > 0;
    }
}
