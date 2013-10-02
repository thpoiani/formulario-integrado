PROJETO
==========
Formulário integrado ao Programa de Assistência Estudantil
IFSP São Carlos

O projeto tem como objetivo o dinamismo e a facilidade para gerenciamento de
formulários, principalmente o do Programa de Assistência Estudantil – PAE,
pelos técnicos administrativos do IFSP, assim como a relação de usuários que
os responderam, com seus dados.


CLIENTE
==========
Samira Nathalia Piza


ENVOLVIDOS
=============
Gislaine Ferreira Gonçalves
Thiago Henrique Poiani
Thiago Silva Barros


CONFIGURANDO VHOST
=====================

<VirtualHost *:80>
   DocumentRoot "C:/wamp/www/formulario-integrado/public"
   ServerName formulario.local

   <Directory "C:/wamp/www/formulario-integrado/public">
       Options Indexes MultiViews FollowSymLinks
       AllowOverride All
       Order allow,deny
       Allow from all
   </Directory>

</VirtualHost>
