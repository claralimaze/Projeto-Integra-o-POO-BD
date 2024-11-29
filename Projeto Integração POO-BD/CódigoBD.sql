DROP SCHEMA `projeto` ;
CREATE SCHEMA IF NOT EXISTS `projeto` ;
USE `projeto` ;

CREATE TABLE IF NOT EXISTS `projeto`.`técnico` (
  `CPF` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `idade` INT NULL,
  `títulos`INT NULL,
  PRIMARY KEY (`CPF`));

CREATE TABLE IF NOT EXISTS `projeto`.`time` (
  `nome` VARCHAR(45) NOT NULL,
  `mascote` VARCHAR(45) NULL,
  `técnico_CPF` INT NOT NULL,
  PRIMARY KEY (`nome`),
  INDEX `fk_time_técnico1_idx` (`técnico_CPF` ASC),
  CONSTRAINT `fk_time_técnico1`
    FOREIGN KEY (`técnico_CPF`)
    REFERENCES `projeto`.`técnico` (`CPF`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
CREATE TABLE IF NOT EXISTS `projeto`.`jogadores` (
  `CPF` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `altura` INT NULL,
  `peso` INT NULL,
  `n_da_camisa` INT NULL,
  `time_nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`CPF`),
  INDEX `fk_jogadores_time1_idx` (`time_nome` ASC),
  CONSTRAINT `fk_jogadores_time1`
    FOREIGN KEY (`time_nome`)
    REFERENCES `projeto`.`time` (`nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `projeto`.`campeonato` (
  `nome` VARCHAR(45) NOT NULL,
  `prémios` VARCHAR(45) NULL,
  `região` VARCHAR(45) NULL,
  PRIMARY KEY (`nome`));

CREATE TABLE IF NOT EXISTS `projeto`.`time_has_campeonato` (
  `time_nome` VARCHAR(45) NOT NULL,
  `campeonato_nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`time_nome`, `campeonato_nome`),
  INDEX `fk_time_has_campeonato_campeonato1_idx` (`campeonato_nome` ASC),
  INDEX `fk_time_has_campeonato_time1_idx` (`time_nome` ASC),
  CONSTRAINT `fk_time_has_campeonato_time1`
    FOREIGN KEY (`time_nome`)
    REFERENCES `projeto`.`time` (`nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_time_has_campeonato_campeonato1`
    FOREIGN KEY (`campeonato_nome`)
    REFERENCES `projeto`.`campeonato` (`nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

select * from `projeto`.`técnico`;
select * from `projeto`.`time`;
select * from `projeto`.`jogadores`;
select * from `projeto`.`campeonato`;
select * from `projeto`.`time_has_campeonato`;