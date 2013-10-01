/**
 * Evento de carregamento de página
 */
$(document).ready(function() {
    validate();
});

/**
 * Função para validação de campos em branco
 * @return void
 */
function validate() {
    $('input').change(function(){
        if ($(this).val()) {
            $(this).parent().parent().removeClass('has-error').addClass('has-success');
        } else {
            $(this).parent().parent().removeClass('has-success').addClass('has-error');
        }
    });
}

// function enviar() {
//     $.post('/home/ajax', $('#formulario2').serialize(), function(response) {
//         $('h4').show().text(response);
//     });
// }