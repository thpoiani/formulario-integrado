<!doctype html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<title>Formularios Integrado - Instituto Federal de São Paulo campus São Carlos</title>

	<link href="css/bootstrap.css" rel="stylesheet">
	<link href="css/flat-ui.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">

	<link rel="shortcut icon" type="image/x-icon" href="/images/favicon.ico">

	<!--[if IE]>
		<script type="text/javascript">
			var htmlshim='abbr,article,aside,audio,canvas,details,figcaption,figure,footer,header,mark,meter,nav,output,progress,section,summary,time,video'.split(',');
			var htmlshimtotal=htmlshim.length;
			for(var i=0;i<htmlshimtotal;i++) document.createElement(htmlshim[i]);
		</script>
	<![endif]-->

</head>
<body>
	<div class="page">
		<header>
			<div class="container">
				<div class="row">
					<div class="col-sm-3 text-left">
						<p>Bom dia Thiago Henrique Poiani</p>
					</div>

					<div class="col-sm-6 text-center">
						<p>Formulário PAE - Programa de Assistência Estudantil</p>
					</div>

					<div class="col-sm-3 text-right">
						<p>Sair</p>
					</div>
				</div>
			</div>
		</header>

		<section class="container vertical">
			<article class="row">
				<div class="col-xs-6 middle">
					<input type="text" class="form-control" name="nome" id="nome" placeholder="Nome">
				</div>
			</article>

			<article class="row">
				<div class="col-xs-6 middle">
					<input type="text" class="form-control" name="prontuario" id="prontuario" placeholder="Prontuário">
				</div>
			</article>

			<article class="row">
				<div class="col-xs-6 middle">
					<input type="text" class="form-control" name="curso" id="curso" placeholder="Curso">
				</div>
			</article>

			<article class="row">
				<div class="col-xs-6 middle">
					<input type="text" class="form-control" name="semestre" id="semestre" placeholder="Semestre">
				</div>
			</article>

			<article class="row">
				<div class="col-xs-6 middle">
					<input type="text" class="form-control" name="data_nascimento" id="data_nascimento" placeholder="Data de Nascimento">
				</div>
			</article>

			<article class="row">
				<div class="col-xs-6 middle">
					<input type="text" class="form-control" name="data_nascimento" id="data_nascimento" placeholder="Data de Nascimento">
				</div>
			</article>

			<article class="row">
				<div class="col-xs-6 middle">
					<input type="text" class="form-control" name="data_nascimento" id="data_nascimento" placeholder="Data de Nascimento">
				</div>
			</article>

			<article class="row">
				<div class="col-xs-6 middle">
					<input type="text" class="form-control" name="data_nascimento" id="data_nascimento" placeholder="Data de Nascimento">
				</div>
			</article>

			<article class="row has-error">
				<div class="col-xs-6 middle">
					<input type="text" class="form-control" name="idade" id="idade" placeholder="Idade">
				</div>
			</article>

			<article class="row has-success">
				<div class="col-xs-6 middle">
					<input type="text" class="form-control" name="naturalidade" id="naturalidade" placeholder="Naturalidade">
				</div>
			</article>

			<article class="row">
				<div class="col-xs-6 middle">
					<label class="radio">
						<input type="radio" name="group1" value="1" data-toggle="radio">Radio is off
					</label>

					<label class="radio">
						<input type="radio" name="group1" value="2" data-toggle="radio" checked>Radio is on
					</label>

					<label class="checkbox" for="checkbox1">
						<input type="checkbox" value="" id="checkbox1" data-toggle="checkbox">
						Checkbox
					</label>
				</div>
			</article>

			<div class="row">
				<div class="col-xs-6 middle text-right">
					<button class="btn btn-default">Limpar</button>
					<button class="btn btn-success">Enviar</button>
				</div>
			</div>
		</section>

		<footer>
			<div class="footer">
				<p>Instituto Federal de São Paulo campus São Carlos</p>
				<p>Rodovia Washington Luís, km 235 prédio AT-6 - Salas 136, 138 e 139 - Bairro Monjolinho</p>
				<p>CEP 13.565-905 - São Carlos - SP</p>
			</div>
		</footer>
	</div>

	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="/js/jquery.placeholder"></script>
	<script src="/js/bootstrap.min"></script>
	<script src="/js/default.js"></script>
	<script src="/js/flatui-checkbox"></script>
	<script src="/js/flatui-radio"></script>
	<script src="/js/jquery.tagsinput"></script>



</body>
</html>