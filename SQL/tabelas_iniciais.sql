SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `petevet` DEFAULT CHARACTER SET Latin1 COLLATE = latin1_swedish_ci;
USE `petevet` ;

-- -----------------------------------------------------
-- Table `petevet`.`Customer`
-- -----------------------------------------------------
CREATE TABLE if NOT EXISTS `petevet`.`Customer` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL,
	`cpf` VARCHAR(11) NOT NULL,
	`email` VARCHAR(255) NOT NULL,
	`telephone` VARCHAR(255) NOT NULL,
	`date_of_birth` DATE NOT NULL,
	`address` VARCHAR(255) NOT NULL,
	`neighborhood` VARCHAR(255) NOT NULL,
	`city` VARCHAR(255) NOT NULL,
	`cep` VARCHAR(8) NOT NULL,
	PRIMARY KEY (`id`)
)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `petevet`.`Animal`
-- -----------------------------------------------------
CREATE TABLE if NOT EXISTS `petevet`.`Animal` (
	`id` INT NOT NULL,
	`name` VARCHAR(255) NOT NULL,
	`breed` VARCHAR(255) NOT NULL,
	`age` INT NOT NULL,
	`sex` VARCHAR(1) NOT NULL,
	PRIMARY KEY (`id`)
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `petevet`.`Employee`
-- -----------------------------------------------------
CREATE TABLE if NOT EXISTS `petevet`.`Employee` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL,
	`cpf` VARCHAR(11) NOT NULL,
	`email` VARCHAR(255) NOT NULL,
	`telephone` VARCHAR(255) NOT NULL,
	`role` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`id`)
)
ENGINE = InnoDB;

	

