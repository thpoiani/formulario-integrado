-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: poiani.cxdsxdlfvih4.us-west-2.rds.amazonaws.com    Database: interativo
-- ------------------------------------------------------
-- Server version	5.5.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `interativo`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `interativo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `interativo`;

--
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluno` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `prontuario` varchar(10) NOT NULL,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `prontuario_UNIQUE` (`prontuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `campo`
--

DROP TABLE IF EXISTS `campo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `campo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50) NOT NULL,
  `maxlength` int(5) DEFAULT NULL,
  `regex` mediumtext,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  `ordem` int(11) NOT NULL,
  `data` datetime NOT NULL,
  `categoriaId` int(10) unsigned NOT NULL,
  `tipoId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_categoria_campo_idx` (`categoriaId`),
  KEY `fk_tipo_campo_idx` (`tipoId`),
  CONSTRAINT `fk_campo_tipo` FOREIGN KEY (`tipoId`) REFERENCES `tipo` (`id`),
  CONSTRAINT `fk_campo_categoria` FOREIGN KEY (`categoriaId`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campo`
--

LOCK TABLES `campo` WRITE;
/*!40000 ALTER TABLE `campo` DISABLE KEYS */;
/*!40000 ALTER TABLE `campo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) NOT NULL,
  `descricao` mediumtext,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  `data` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formulario`
--

DROP TABLE IF EXISTS `formulario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formulario` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) NOT NULL,
  `aberto` tinyint(1) NOT NULL DEFAULT '1',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0, 1',
  `data` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `titulo_UNIQUE` (`titulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formulario`
--

LOCK TABLES `formulario` WRITE;
/*!40000 ALTER TABLE `formulario` DISABLE KEYS */;
/*!40000 ALTER TABLE `formulario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formulario_categoria`
--

DROP TABLE IF EXISTS `formulario_categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formulario_categoria` (
  `formularioId` int(10) unsigned NOT NULL,
  `categoriaId` int(10) unsigned NOT NULL,
  `ordem` int(11) NOT NULL,
  PRIMARY KEY (`formularioId`,`categoriaId`),
  KEY `fk_formulario_categoria_idx` (`formularioId`),
  KEY `fk_categoria_formulario_idx` (`categoriaId`),
  CONSTRAINT `fk_categoria_formulario` FOREIGN KEY (`categoriaId`) REFERENCES `categoria` (`id`),
  CONSTRAINT `fk_formulario_categoria` FOREIGN KEY (`formularioId`) REFERENCES `formulario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formulario_categoria`
--

LOCK TABLES `formulario_categoria` WRITE;
/*!40000 ALTER TABLE `formulario_categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `formulario_categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo`
--

DROP TABLE IF EXISTS `grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50) NOT NULL,
  `data` datetime NOT NULL,
  `campoId` int(10) unsigned NOT NULL,
  `tipoId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_categoria_grupo_idx` (`campoId`),
  KEY `fk_grupo_tipo_idx` (`tipoId`),
  CONSTRAINT `fk_grupo_categoria` FOREIGN KEY (`campoId`) REFERENCES `campo` (`id`),
  CONSTRAINT `fk_grupo_tipo` FOREIGN KEY (`tipoId`) REFERENCES `tipo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo`
--

LOCK TABLES `grupo` WRITE;
/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
/*!40000 ALTER TABLE `grupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resposta`
--

DROP TABLE IF EXISTS `resposta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resposta` (
  `alunoId` int(10) unsigned NOT NULL,
  `campoId` int(10) unsigned NOT NULL,
  `resposta` text NOT NULL,
  `data` datetime NOT NULL,
  PRIMARY KEY (`alunoId`,`campoId`),
  KEY `fk_resposta_aluno_idx` (`alunoId`),
  KEY `fk_campo_resposta_idx` (`campoId`),
  CONSTRAINT `fk_campo_resposta` FOREIGN KEY (`campoId`) REFERENCES `campo` (`id`),
  CONSTRAINT `fk_resposta_aluno` FOREIGN KEY (`alunoId`) REFERENCES `aluno` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resposta`
--

LOCK TABLES `resposta` WRITE;
/*!40000 ALTER TABLE `resposta` DISABLE KEYS */;
/*!40000 ALTER TABLE `resposta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo`
--

DROP TABLE IF EXISTS `tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descricao` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `descricao_UNIQUE` (`descricao`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo`
--

LOCK TABLES `tipo` WRITE;
/*!40000 ALTER TABLE `tipo` DISABLE KEYS */;
INSERT INTO `tipo` VALUES (5,'Check'),(4,'Data'),(3,'Decimal'),(2,'Inteiro'),(6,'Radio'),(1,'Texto');
/*!40000 ALTER TABLE `tipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `prematricula`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `prematricula` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `prematricula`;

--
-- Table structure for table `pm_pessoas`
--

DROP TABLE IF EXISTS `pm_pessoas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pm_pessoas` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `prontuario` varchar(50) NOT NULL,
  `nome` varchar(200) DEFAULT NULL,
  `nomec` varchar(200) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `categ` varchar(50) NOT NULL,
  `email` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=936 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pm_pessoas`
--

LOCK TABLES `pm_pessoas` WRITE;
/*!40000 ALTER TABLE `pm_pessoas` DISABLE KEYS */;
INSERT INTO `pm_pessoas` VALUES (935,'1234567','Aluno','Aluno','1234567','Aluno','aluno@ifsp.com');
/*!40000 ALTER TABLE `pm_pessoas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-10-22  1:18:13
