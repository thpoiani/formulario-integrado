SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `interativo` ;
CREATE SCHEMA IF NOT EXISTS `interativo` DEFAULT CHARACTER SET utf8 ;
USE `interativo` ;

-- -----------------------------------------------------
-- Table `interativo`.`formulario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `interativo`.`formulario` ;

CREATE  TABLE IF NOT EXISTS `interativo`.`formulario` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `titulo` VARCHAR(45) NOT NULL ,
  `cabecalho` TEXT NULL ,
  `rodape` TEXT NULL ,
  `status` ENUM('a','i') NULL DEFAULT 'i' ,
  `data` DATETIME NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;

CREATE UNIQUE INDEX `titulo_UNIQUE` ON `interativo`.`formulario` (`titulo` ASC) ;


-- -----------------------------------------------------
-- Table `interativo`.`categoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `interativo`.`categoria` ;

CREATE  TABLE IF NOT EXISTS `interativo`.`categoria` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `titulo` VARCHAR(45) NOT NULL ,
  `descricao` TEXT NULL ,
  `status` ENUM('a','i') NULL DEFAULT 'i' ,
  `data` DATETIME NOT NULL ,
  `id_formulario` INT UNSIGNED NOT NULL ,
  PRIMARY KEY (`id`) ,
  CONSTRAINT `fk_formulario_categoria`
    FOREIGN KEY (`id_formulario` )
    REFERENCES `interativo`.`formulario` (`id` )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;

CREATE INDEX `fk_formulario_categoria_idx` ON `interativo`.`categoria` (`id_formulario` ASC) ;


-- -----------------------------------------------------
-- Table `interativo`.`campo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `interativo`.`campo` ;

CREATE  TABLE IF NOT EXISTS `interativo`.`campo` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `titulo` VARCHAR(45) NOT NULL ,
  `maxlength` INT NOT NULL DEFAULT 50 ,
  `status` ENUM('a','i') NULL DEFAULT 'i' ,
  `data` DATETIME NOT NULL ,
  `id_categoria` INT UNSIGNED NOT NULL ,
  PRIMARY KEY (`id`) ,
  CONSTRAINT `fk_categoria_campo`
    FOREIGN KEY (`id_categoria` )
    REFERENCES `interativo`.`categoria` (`id` )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;

CREATE INDEX `fk_categoria_campo_idx` ON `interativo`.`campo` (`id_categoria` ASC) ;


-- -----------------------------------------------------
-- Table `interativo`.`respostas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `interativo`.`respostas` ;

CREATE  TABLE IF NOT EXISTS `interativo`.`respostas` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `prontuario` VARCHAR(7) NOT NULL ,
  `resposta` TEXT NOT NULL ,
  `data` DATETIME NOT NULL ,
  `id_campo` INT UNSIGNED NOT NULL ,
  PRIMARY KEY (`id`) ,
  CONSTRAINT `fk_resposta_campo`
    FOREIGN KEY (`id_campo` )
    REFERENCES `interativo`.`campo` (`id` )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;

CREATE INDEX `fk_resposta_campo_idx` ON `interativo`.`respostas` (`id_campo` ASC) ;

USE `interativo` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
