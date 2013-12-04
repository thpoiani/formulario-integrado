<!doctype html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Formulário Integrado - Instituto Federal de São Paulo campus São Carlos</title>
<meta name="keywords" content="IFSP, campus São Carlos, Instituto Federal">
<meta name="description" content="IFSP campus São Carlos Instituto Federal de Educação Ciência e Tenologia de São Paulo SCL ifsp">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="/css/bootstrap.css" rel="stylesheet">
<link href="/css/flat-ui.css" rel="stylesheet">
<link href="/css/style.css" rel="stylesheet">

<link href="/images/favicon.ico" rel="shortcut icon" type="image/x-icon">
<link href="/humans.txt" rel="author" type="text/plain">

<!--[if lt IE 9]>
    <script type="text/javascript">
        var htmlshim='abbr,article,aside,audio,canvas,details,figcaption,figure,footer,header,mark,meter,nav,output,progress,section,summary,time,video'.split(',');
        var htmlshimtotal=htmlshim.length;
        for(var i=0;i<htmlshimtotal;i++) document.createElement(htmlshim[i]);
    </script>
<![endif]-->

</head>
<body>
<div class="page">
    <header class="navbar-fixed-top">
        <div class="col-xs-3">
            <?php if (isset($this->login) && $this->login) { ?>

            <p class="navbar-text align-left"><?php echo $this->helperShowDate(); ?> <a href="#" class="navbar-link" title="<?php echo $_SESSION['nome']; ?>"><?php echo $_SESSION['nome']; ?></a></p>
            <?php } ?>
        </div>

        <div class="col-xs-6">
            <p class="navbar-text align-center">Formulário Integrado - Instituto Federal de São Paulo campus São Carlos</p>
        </div>

        <div class="col-xs-3">
            <?php if (isset($this->login) && $this->login) { ?>

            <p class="navbar-text align-right"><a href="/index/logout" class="navbar-link" title="Sair">Sair</a>
            <?php } ?>
        </div>
    </header>

    <?php $this->getContent(); ?>

    <footer>
        <div class="footer">
            <p>Instituto Federal de São Paulo campus São Carlos</p>
            <p>Rodovia Washington Luís, km 235 prédio AT-6 - Salas 136, 138 e 139 - Bairro Monjolinho</p>
            <p>CEP 13.565-905 - São Carlos - SP</p>
        </div>
    </footer>
</div>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="/js/jquery-1.10.2.min.js"><\/script>')</script>

<script src="/js/flatui-checkbox.js"></script>
<script src="/js/flatui-radio.js"></script>
<script src="/js/default.js"></script>

</body>
</html>
