<!doctype html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<title>Formularios Integrado - Instituto Federal de São Paulo campus São Carlos</title>
	
	<link href="css/bootstrap.css" rel="stylesheet">
	<link href="css/flat-ui.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
	
	<link rel="shortcut icon" type="image/x-icon" href="/images/favicon.ico">
	
</head>
<body>
	<div class="page">
	
	<header>
			<div class="container">
				<div class="row">

					<div class="col-sm-12 text-center">
						<p>Formulário PAE - Programa de Assistência Estudantil</p>
					</div>

				</div>
			</div>
		</header>
	
	<form id="Formulario" action="/index/salvar">
	<fieldset class="container vertical">
		<article class="row">
			<div class="col-xs-6 middle">
				<legend>Validação</legend>				
					<label for="username">Usuario</label>
					<input type="text" class="form-control" id="username" name="username" maxlength="8">
					<label for="prontuario">Prontuario</label>
					<input type="text" class="form-control" id="prontuario" name="prontuario" maxlength="6">
					<label for="passwd">Senha</label>
					<input type="text" class="form-control" id="passwd" name="passwd" maxlength="16">
					<div class="col-xs-6 middle text-center">
						<input type="submit" class="btn btn-default" value="Ok">
						<input type="reset" class="btn btn-success"value="Limpar">
					</div>				
			</div>
		</article>
	</fieldset>
	</form>
	
	<footer>
		<div class="footer">
			<p>Instituto Federal de São Paulo campus São Carlos</p>
			<p>Rodovia Washington Luís, km 235 prédio AT-6 - Salas 136, 138 e 139 - Bairro Monjolinho</p>				<p>CEP 13.565-905 - São Carlos - SP</p>
		</div>
	</footer>

	</div>

</body>
</html>