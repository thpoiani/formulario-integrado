<?php
require_once('Controller.php');
require_once(APPLICATION . '/business/FormularioBusiness.php');
require_once(APPLICATION . '/business/RespostaBusiness.php');
require_once(APPLICATION . '/config/PHPMailer/class.phpmailer.php');
require_once(APPLICATION . '/models/Resposta.php');

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
    }

    public function salvar() {
        if ($_POST) {
            $respostaBusiness = new RespostaBusiness();
            $formularioId = $_POST['formulario'];

            // remove elemento refere ao formulário, para ficar apenas com as respostas
            unset($_POST['formulario']);

            $respostas = array();

            foreach ($_POST as $key => $value) {
                $resposta = new Resposta();
                $this->assemblyRequest($resposta, $formularioId, $key, $value);
                array_push($respostas, $resposta);
            }

            try {
                $respostaBusiness->salvar($respostas);
                header("Location: /formularios");
            } catch (Exception $e) {
                header("Location: /formularios/index/?id=" . $_POST['formulario']);
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
    private function getMailConfig(){
        $mail = new PHPMailer();
        //envio por SMTP
        $mail->IsSMTP();
        //autenticado
        $mail->SMTPAuth = true;
        //Alterando porta por conta de Span
        $mail->port =587;
        $mail->Host = '';
        $mail->Username = '';
        $mail->Password = '';
        $mail->SetFrom('', 'IFSP');
    }
    /**
    * Metodo que enviara
    * E-mail ao usuario logado
    */
    private function sendEmailToUser($UserEmail, $UserName){
        $mail->AddAdress($UserEmail, $UserName);
        $mail->Subject = 'Confirmação de envio de formulario';
        $mail->MsgHTML('Mensagem');

        if($mail->Send()){
            //alert ou popup
        }else{
            //alert ou popup
        }
    }

    /**
    * Metodo que enviara
    * E-mail ao administrador
    * dos formularios
    */
    private function sendEmailToAdmin($UserEmail, $UserName){
        $mail->AddAdress($UserEmail, 'Samira Pizza');
        $mail->Subject = 'Confirmação de envio de formulario';
        $mail->MsgHTML('Envio de' .$Username.'com o email'.$UserEmail);

        if($mail->Send()){
            //alert ou popup
        }else{
            //alert ou popup
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
