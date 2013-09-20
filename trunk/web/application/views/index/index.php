<!doctype html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<title>Formularios Integrado - Instituto Federal de São Paulo campus São Carlos</title>
	<link rel="shortcut icon" type="image/x-icon" href="/images/favicon.ico">
	<link href="css/flat-ui.css" rel="stylesheet">
</head>
<body>
	<form id="Formulario" action="/index/salvar">
	<fieldset>
		<legend>Validação</legend>
			<label for="username">Usuario</label>
			<input type="text" id="username" name="username" maxlength="8">
			<label for="prontuario">Prontuario</label>
			<input type="text" id="prontuario" name="prontuario" maxlength="6">
			<label for="passwd">Senha</label>
			<input type="text" id="passwd" name="passwd" maxlength="16">
			<input type="submit" value="Ok">
			<input type="reset" value="Limpar">
	</fieldset>
	</form>
</body>
</html>