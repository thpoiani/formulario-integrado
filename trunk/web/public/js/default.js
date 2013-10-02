/**
 * Evento de carregamento de página
 */
$(function() {
    validate();
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