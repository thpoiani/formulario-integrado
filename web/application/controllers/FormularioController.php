<?php
require_once('Controller.php');
require_once(APPLICATION . '/business/FormularioBusiness.php');
require_once(APPLICATION . '/config/PHPMailer/class.phpmailer.php');

class FormularioController extends Controller {

    private $business;
    private $mail;

    public function __construct() {
        if (!parent::isSession()) header("Location: /");
        if (!$this->hasParameter()) header("Location: /formularios");

        $this->business = new FormularioBusiness();
    }

    public function index() {
        $this->setLayout(LAYOUT . '/layout.php');

        // Formulario retorna à view
        $this->formulario = $this->business->obterFormularioCompleto($_GET['id']);
    }

        /**
    * Metodo que seta configurações para o envio de
    * E-mail por SMTP autenticado
    */
    public function getMailConfig(){
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
    public function sendEmailToUser($UserEmail, $UserName){
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
    public function sendEmailToAdmin($UserEmail, $UserName){
        $mail->AddAdress($UserEmail, 'Samira Pizza');
        $mail->Subject = 'Confirmação de envio de formulario';
        $mail->MsgHTML('Envio de' .$Username.'com o email'.$UserEmail);

        if($mail->Send()){
            //alert ou popup
        }else{
            //alert ou popup
        }
    }

    public function salvar() {

    }

    /**
     * Método para verificar se existe parametro id
     * @return boolean
     */
    private function hasParameter() {
        return $_GET && $_GET['id'] > 0;
    }
}
