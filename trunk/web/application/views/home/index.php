<!doctype html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<title>Título</title>
</head>
<body>
	<p><?php echo $this->var; ?></p>

	<form id="formulario1" action="/home/salvar" method="POST">
		<input type="text" id="nome1" name="nome" placeholder="Nome">
		<input type="submit" value="Enviar">
	</form>

	<hr>

	<p>Exemplo de Formulário AJAX</p>
	<form id="formulario2" onsubmit="return false;">
		<input type="text" id="nome2" name="nome" placeholder="Nome">
		<input type="submit" value="Enviar" onclick="enviar()">
	</form>

	<h4 style="display:none"></h4>

	<!-- LOCAL -->
 	<script src="/js/default.js"></script>

 	<!-- CDN -->
 	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</body>
</html>