$(document).ready(function() {
	$("input, textarea").placeholder();

	$('[data-toggle="radio"]').each(function () {
		$(this).radio();
	});

	$('[data-toggle="checkbox"]').each(function () {
		$(this).checkbox();
	});
});

function enviar() {
	$.post('/home/ajax', $('#formulario2').serialize(), function(response) {
		$('h4').show().text(response);
	});
}