/**
 * Evento de carregamento de página
 */
$(function() {
    validate();
    $('.date').datepicker();
    errorMessage();
});

/**
 * Função para validação de campos em branco
 * @return void
 */
function validate() {
    $('input').blur(function(){
        if ($(this).val()) {
            $(this).parent().parent().removeClass('has-error').addClass('has-success');
        } else {
            $(this).parent().parent().removeClass('has-success').addClass('has-error');
        }
    });
}

/**
 * Função para remoção de mensagem de erro
 * @return void
 */
function errorMessage() {
    $error = $('.error');
    if ($error.length) $error.parent().fadeOut(5000);
}