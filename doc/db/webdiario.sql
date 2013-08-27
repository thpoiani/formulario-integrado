-- phpMyAdmin SQL Dump
-- version 3.3.3
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: Set 13, 2012 as 02:51 PM
-- Versão do Servidor: 5.0.83
-- Versão do PHP: 5.2.10-2ubuntu6.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

create database prematricula;
use prematricula;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `prematricula`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `gd_aulas_ministradas`
--

CREATE TABLE IF NOT EXISTS `gd_aulas_ministradas` (
  `id_aula` int(11) NOT NULL auto_increment,
  `data` date default NULL,
  `conteudo` varchar(200) default NULL,
  `qtd_aula` int(11) default NULL,
  `atividades` varchar(200) default NULL,
  `avaliacao` varchar(200) default NULL,
  `obs` varchar(200) default NULL,
  `id_oferecimento` int(11) default NULL,
  PRIMARY KEY  (`id_aula`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=566 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `gd_avaliacoes`
--

CREATE TABLE IF NOT EXISTS `gd_avaliacoes` (
  `of_id` int(11) NOT NULL,
  `id_criterio` int(11) NOT NULL,
  `prontuario` varchar(50) NOT NULL,
  `nota` float NOT NULL default '0',
  `sub` tinyint(1) default '0',
  `data_sub` date default '0000-00-00',
  PRIMARY KEY  (`of_id`,`id_criterio`,`prontuario`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `gd_criterios`
--

CREATE TABLE IF NOT EXISTS `gd_criterios` (
  `id` int(11) NOT NULL auto_increment,
  `descricao` varchar(2) default NULL,
  `peso` float default NULL,
  `id_oferecimento` int(11) NOT NULL,
  PRIMARY KEY  (`id`,`id_oferecimento`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=53 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `gd_criterio_oferecimento`
--

CREATE TABLE IF NOT EXISTS `gd_criterio_oferecimento` (
  `id_criterio` int(11) NOT NULL,
  `id_oferecimento` int(11) NOT NULL,
  `peso_nf` float default NULL,
  PRIMARY KEY  (`id_criterio`,`id_oferecimento`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `gd_pess_of_aulas`
--

CREATE TABLE IF NOT EXISTS `gd_pess_of_aulas` (
  `id_aula` int(11) NOT NULL,
  `prontuario` varchar(50) NOT NULL,
  `faltas` int(11) default NULL,
  `falta_abonada` tinyint(1) default '0',
  `protocolo_abono` varchar(45) default NULL,
  `motivo_abono` varchar(45) default NULL,
  PRIMARY KEY  (`id_aula`,`prontuario`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `gd_professores`
--

CREATE TABLE IF NOT EXISTS `gd_professores` (
  `prontuario` varchar(20) NOT NULL,
  `titulacao` varchar(45) default NULL,
  PRIMARY KEY  (`prontuario`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `gd_prof_oferecimentos`
--

CREATE TABLE IF NOT EXISTS `gd_prof_oferecimentos` (
  `of_id` int(11) NOT NULL,
  `prontuario` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pm_alunos`
--

CREATE TABLE IF NOT EXISTS `pm_alunos` (
  `id` int(11) NOT NULL auto_increment,
  `prontuario` varchar(50) NOT NULL,
  `turma` varchar(20) NOT NULL,
  `cu_cod` varchar(20) NOT NULL,
  `situacao` varchar(100) NOT NULL,
  `data_situacao` varchar(20) NOT NULL,
  `obs` text NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=866 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pm_auditoria`
--

CREATE TABLE IF NOT EXISTS `pm_auditoria` (
  `id` int(11) NOT NULL auto_increment,
  `datetime` datetime NOT NULL,
  `ip` varchar(50) NOT NULL,
  `categ` varchar(50) NOT NULL,
  `prontuario` varchar(50) NOT NULL,
  `payload` varchar(500) NOT NULL,
  `ambiente` varchar(500) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=32249 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pm_config`
--

CREATE TABLE IF NOT EXISTS `pm_config` (
  `id` int(11) NOT NULL auto_increment,
  `categ` varchar(50) NOT NULL,
  `sub` varchar(50) NOT NULL,
  `dados` text NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pm_cursos`
--

CREATE TABLE IF NOT EXISTS `pm_cursos` (
  `id` int(11) NOT NULL auto_increment,
  `cod` varchar(20) NOT NULL,
  `curso` varchar(200) NOT NULL,
  `num_modulos` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pm_disciplinas`
--

CREATE TABLE IF NOT EXISTS `pm_disciplinas` (
  `id` int(10) NOT NULL auto_increment,
  `cod` varchar(20) NOT NULL,
  `nome` varchar(100) default NULL,
  `cu_cod` varchar(20) NOT NULL,
  `modulo` varchar(10) NOT NULL,
  `t_p` varchar(10) NOT NULL,
  `aulas_por_semana` varchar(2) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=93 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pm_oferecimentos`
--

CREATE TABLE IF NOT EXISTS `pm_oferecimentos` (
  `id` int(11) NOT NULL auto_increment,
  `di_cod` varchar(20) NOT NULL,
  `semestre` varchar(20) NOT NULL,
  `turma` varchar(20) NOT NULL,
  `estado` varchar(20) NOT NULL,
  `data_ini` date NOT NULL,
  `data_fim` date NOT NULL,
  `nro_aulas` int(11) NOT NULL,
  `horario` varchar(100) NOT NULL,
  `vagas` varchar(20) NOT NULL,
  `local` text NOT NULL,
  `professor_prontuario` varchar(100) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=386 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pm_pessoas`
--

CREATE TABLE IF NOT EXISTS `pm_pessoas` (
  `id` int(10) NOT NULL auto_increment,
  `prontuario` varchar(50) NOT NULL,
  `nome` varchar(200) default NULL,
  `nomec` varchar(200) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `categ` varchar(50) NOT NULL,
  `email` varchar(200) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=935 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pm_pessoas-oferecimentos`
--

CREATE TABLE IF NOT EXISTS `pm_pessoas-oferecimentos` (
  `id` int(11) NOT NULL auto_increment,
  `of_id` int(11) NOT NULL,
  `prontuario` varchar(50) NOT NULL,
  `nota` float NOT NULL,
  `faltas` int(11) NOT NULL,
  `si_id` int(11) NOT NULL,
  `premat` int(11) NOT NULL default '0',
  `obs` text NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=15552 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pm_semestres`
--

CREATE TABLE IF NOT EXISTS `pm_semestres` (
  `id` int(11) NOT NULL auto_increment,
  `semestre` varchar(20) NOT NULL,
  `descricao` varchar(200) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pm_situacoes`
--

CREATE TABLE IF NOT EXISTS `pm_situacoes` (
  `id` int(11) NOT NULL auto_increment,
  `situacao` varchar(200) NOT NULL COMMENT 'Situações possíveis disciplinas cursadas pelos alunos',
  `alunos` tinyint(1) default NULL,
  `p_o` tinyint(1) default NULL,
  `di` tinyint(1) default NULL,
  `of` tinyint(1) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=22 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pm_tokens`
--

CREATE TABLE IF NOT EXISTS `pm_tokens` (
  `id` int(11) NOT NULL auto_increment,
  `cadastro` datetime NOT NULL,
  `expira` datetime NOT NULL,
  `token` varchar(50) NOT NULL,
  `categ` varchar(50) NOT NULL,
  `acao` varchar(500) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1141 ;
