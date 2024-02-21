-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema final_project
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema final_project
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `final_project` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `final_project` ;

-- -----------------------------------------------------
-- Table `final_project`.`abilities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `final_project`.`abilities` (
  `card_name` TEXT NULL DEFAULT NULL,
  `card_code` INT NOT NULL,
  `region_1` TEXT NULL DEFAULT NULL,
  `region_2` TEXT NULL DEFAULT NULL,
  `effect` TEXT NULL DEFAULT NULL,
  `artist_name` TEXT NULL DEFAULT NULL,
  `keyword_1` TEXT NULL DEFAULT NULL,
  `keyword_2` TEXT NULL DEFAULT NULL,
  `keyword_3` TEXT NULL DEFAULT NULL,
  `spell_speed` TEXT NULL DEFAULT NULL,
  `rarity` TEXT NULL DEFAULT NULL,
  `affiliation` TEXT NULL DEFAULT NULL,
  `type` TEXT NULL DEFAULT NULL,
  `collectible` TEXT NULL DEFAULT NULL,
  `set_number` INT NULL DEFAULT NULL,
  `set_name` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`card_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `final_project`.`champions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `final_project`.`champions` (
  `card_name` TEXT NULL DEFAULT NULL,
  `card_code` INT NOT NULL,
  `region_1` TEXT NULL DEFAULT NULL,
  `region_2` TEXT NULL DEFAULT NULL,
  `attack` INT NULL DEFAULT NULL,
  `cost` INT NULL DEFAULT NULL,
  `health` INT NULL DEFAULT NULL,
  `effect` TEXT NULL DEFAULT NULL,
  `level_up_description` TEXT NULL DEFAULT NULL,
  `artist_name` TEXT NULL DEFAULT NULL,
  `keyword_1` TEXT NULL DEFAULT NULL,
  `keyword_2` TEXT NULL DEFAULT NULL,
  `keyword_3` TEXT NULL DEFAULT NULL,
  `rarity` TEXT NULL DEFAULT NULL,
  `affiliation` TEXT NULL DEFAULT NULL,
  `type` TEXT NULL DEFAULT NULL,
  `collectible` TEXT NULL DEFAULT NULL,
  `set_number` INT NULL DEFAULT NULL,
  `set_name` TEXT NULL DEFAULT NULL,
  `level` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`card_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `final_project`.`landmarks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `final_project`.`landmarks` (
  `card_name` TEXT NULL DEFAULT NULL,
  `card_code` INT NOT NULL,
  `region_1` TEXT NULL DEFAULT NULL,
  `region_2` TEXT NULL DEFAULT NULL,
  `cost` INT NULL DEFAULT NULL,
  `effect` TEXT NULL DEFAULT NULL,
  `artist_name` TEXT NULL DEFAULT NULL,
  `keyword_1` TEXT NULL DEFAULT NULL,
  `keyword_2` TEXT NULL DEFAULT NULL,
  `keyword_3` TEXT NULL DEFAULT NULL,
  `rarity` TEXT NULL DEFAULT NULL,
  `affiliation` TEXT NULL DEFAULT NULL,
  `type` TEXT NULL DEFAULT NULL,
  `collectible` TEXT NULL DEFAULT NULL,
  `set_number` INT NULL DEFAULT NULL,
  `set_name` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`card_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `final_project`.`nexus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `final_project`.`nexus` (
  `user_id` INT NOT NULL,
  `health` INT NULL DEFAULT NULL,
  `mana` INT NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `final_project`.`spells`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `final_project`.`spells` (
  `card_name` TEXT NULL DEFAULT NULL,
  `card_code` INT NOT NULL,
  `region_1` TEXT NULL DEFAULT NULL,
  `region_2` TEXT NULL DEFAULT NULL,
  `cost` INT NULL DEFAULT NULL,
  `effect` TEXT NULL DEFAULT NULL,
  `artist_name` TEXT NULL DEFAULT NULL,
  `keyword_1` TEXT NULL DEFAULT NULL,
  `keyword_2` TEXT NULL DEFAULT NULL,
  `keyword_3` TEXT NULL DEFAULT NULL,
  `spell_speed` TEXT NULL DEFAULT NULL,
  `rarity` TEXT NULL DEFAULT NULL,
  `affiliation` TEXT NULL DEFAULT NULL,
  `type` TEXT NULL DEFAULT NULL,
  `collectible` TEXT NULL DEFAULT NULL,
  `set_number` INT NULL DEFAULT NULL,
  `set_name` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`card_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `final_project`.`traps`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `final_project`.`traps` (
  `card_name` TEXT NULL DEFAULT NULL,
  `card_code` INT NOT NULL,
  `region_1` TEXT NULL DEFAULT NULL,
  `region_2` TEXT NULL DEFAULT NULL,
  `effect` TEXT NULL DEFAULT NULL,
  `artist_name` TEXT NULL DEFAULT NULL,
  `keyword_1` TEXT NULL DEFAULT NULL,
  `keyword_2` TEXT NULL DEFAULT NULL,
  `keyword_3` TEXT NULL DEFAULT NULL,
  `rarity` TEXT NULL DEFAULT NULL,
  `affiliation` TEXT NULL DEFAULT NULL,
  `type` TEXT NULL DEFAULT NULL,
  `collectible` TEXT NULL DEFAULT NULL,
  `set_number` INT NULL DEFAULT NULL,
  `set_name` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`card_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `final_project`.`units`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `final_project`.`units` (
  `card_name` TEXT NULL DEFAULT NULL,
  `card_code` INT NOT NULL,
  `region_1` TEXT NULL DEFAULT NULL,
  `region_2` TEXT NULL DEFAULT NULL,
  `attack` INT NULL DEFAULT NULL,
  `cost` INT NULL DEFAULT NULL,
  `health` INT NULL DEFAULT NULL,
  `effect` TEXT NULL DEFAULT NULL,
  `artist_name` TEXT NULL DEFAULT NULL,
  `keyword_1` TEXT NULL DEFAULT NULL,
  `keyword_2` TEXT NULL DEFAULT NULL,
  `keyword_3` TEXT NULL DEFAULT NULL,
  `spell_speed` TEXT NULL DEFAULT NULL,
  `rarity` TEXT NULL DEFAULT NULL,
  `affiliation` TEXT NULL DEFAULT NULL,
  `type` TEXT NULL DEFAULT NULL,
  `collectible` TEXT NULL DEFAULT NULL,
  `set_number` INT NULL DEFAULT NULL,
  `set_name` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`card_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

USE `final_project` ;

-- -----------------------------------------------------
-- procedure getAbilitiesByArtistName
-- -----------------------------------------------------

DELIMITER $$
USE `final_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAbilitiesByArtistName`(IN Artist_Name varchar(20))
BEGIN
    SELECT *
    FROM abilities
    WHERE abilities.artist_name = Artist_Name;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getAbilitiesByRarity
-- -----------------------------------------------------

DELIMITER $$
USE `final_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAbilitiesByRarity`(IN Rarity varchar(20))
BEGIN
    SELECT *
    FROM abilities
    WHERE abilities.rarity = Rarity;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getAbilitiesByRegion
-- -----------------------------------------------------

DELIMITER $$
USE `final_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAbilitiesByRegion`(IN Region varchar(20))
BEGIN
	SELECT
		card_name,
        region_1,
        region_2
    FROM abilities
    WHERE region_1 = Region OR region_2 = Region;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getAbilityByName
-- -----------------------------------------------------

DELIMITER $$
USE `final_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAbilityByName`(IN Ability_Name varchar(20))
BEGIN
	SELECT
		card_name,
		region_1,
        region_2,
        effect,
        keyword_1,
        keyword_2,
        keyword_3,
		spell_speed
    FROM abilities
    WHERE card_name = Ability_Name;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getAttackByName
-- -----------------------------------------------------

DELIMITER $$
USE `final_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAttackByName`(IN cardName varchar(20) )
BEGIN
	SELECT attack
    FROM units
    WHERE units.card_name = cardName;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getChampionByName
-- -----------------------------------------------------

DELIMITER $$
USE `final_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getChampionByName`(IN Champ_Name varchar(20))
BEGIN
	SELECT
		card_name,
		region_1,
        region_2,
        attack,
        health,
        cost,
        effect,
        level_up_description,
        keyword_1,
        keyword_2,
        keyword_3
    FROM champions
    WHERE card_name = Champ_Name;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getChampionsByArtistName
-- -----------------------------------------------------

DELIMITER $$
USE `final_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getChampionsByArtistName`(IN Artist_Name varchar(20))
BEGIN
    SELECT *
    FROM champions
    WHERE champions.artist_name = Artist_Name;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getChampionsByRarity
-- -----------------------------------------------------

DELIMITER $$
USE `final_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getChampionsByRarity`(IN Rarity varchar(20))
BEGIN
    SELECT *
    FROM champions
    WHERE champions.rarity = Rarity;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getChampionsByRegion
-- -----------------------------------------------------

DELIMITER $$
USE `final_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getChampionsByRegion`(IN Region varchar(20))
BEGIN
	SELECT
		champions.card_name,
        champions.region_1,
        champions.region_2
    FROM champions
    WHERE region_1 = Region OR region_2 = Region;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getLandmarkByName
-- -----------------------------------------------------

DELIMITER $$
USE `final_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getLandmarkByName`(IN Landmark_Name varchar(20))
BEGIN
	SELECT
		card_name,
		region_1,
        region_2,
        cost,
        effect,
        keyword_1,
        keyword_2,
        keyword_3
    FROM landmarks
    WHERE card_name = Landmark_Name;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getLandmarksByArtistName
-- -----------------------------------------------------

DELIMITER $$
USE `final_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getLandmarksByArtistName`(IN Artist_Name varchar(20))
BEGIN
    SELECT *
    FROM landmarks
    WHERE landmarks.artist_name = Artist_Name;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getLandmarksByRarity
-- -----------------------------------------------------

DELIMITER $$
USE `final_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getLandmarksByRarity`(IN Rarity varchar(20))
BEGIN
    SELECT *
    FROM landmarks
    WHERE landmarks.rarity = Rarity;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getLandmarksByRegion
-- -----------------------------------------------------

DELIMITER $$
USE `final_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getLandmarksByRegion`(IN Region varchar(20))
BEGIN
	SELECT
		card_name,
        region_1,
        region_2
    FROM landmarks
    WHERE region_1 = Region OR region_2 = Region;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getSpellByName
-- -----------------------------------------------------

DELIMITER $$
USE `final_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSpellByName`(IN Spell_Name varchar(20))
BEGIN
	SELECT
		card_name,
		region_1,
        region_2,
        cost,
        effect,
        keyword_1,
        keyword_2,
        keyword_3
    FROM spells
    WHERE card_name = Spell_Name;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getSpellsByArtistName
-- -----------------------------------------------------

DELIMITER $$
USE `final_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSpellsByArtistName`(IN Artist_Name varchar(20))
BEGIN
    SELECT *
    FROM spells
    WHERE spells.artist_name = Artist_Name;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getSpellsByRarity
-- -----------------------------------------------------

DELIMITER $$
USE `final_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSpellsByRarity`(IN Rarity varchar(20))
BEGIN
    SELECT *
    FROM spells
    WHERE spells.rarity = Rarity;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getSpellsByRegion
-- -----------------------------------------------------

DELIMITER $$
USE `final_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSpellsByRegion`(IN Region varchar(20))
BEGIN
	SELECT
		card_name,
        region_1,
        region_2
    FROM spells
    WHERE region_1 = Region OR region_2 = Region;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getTrapByName
-- -----------------------------------------------------

DELIMITER $$
USE `final_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getTrapByName`(IN Trap_Name varchar(20))
BEGIN
	SELECT
		card_name,
		region_1,
        region_2,
        effect,
        keyword_1,
        keyword_2,
        keyword_3
    FROM traps
    WHERE card_name = Trap_Name;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getTrapsByArtistName
-- -----------------------------------------------------

DELIMITER $$
USE `final_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getTrapsByArtistName`(IN Artist_Name varchar(20))
BEGIN
    SELECT *
    FROM traps
    WHERE traps.artist_name = Artist_Name;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getTrapsByRarity
-- -----------------------------------------------------

DELIMITER $$
USE `final_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getTrapsByRarity`(IN Rarity varchar(20))
BEGIN
    SELECT *
    FROM traps
    WHERE traps.rarity = Rarity;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getTrapsByRegion
-- -----------------------------------------------------

DELIMITER $$
USE `final_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getTrapsByRegion`(IN Region varchar(20))
BEGIN
	SELECT
		card_name,
        region_1,
        region_2
    FROM traps
    WHERE region_1 = Region OR region_2 = Region;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getUnitByName
-- -----------------------------------------------------

DELIMITER $$
USE `final_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getUnitByName`(IN Unit_Name varchar(20))
BEGIN
	SELECT
		card_name,
		region_1,
        region_2,
        attack,
        health,
        cost,
        effect,
        keyword_1,
        keyword_2,
        keyword_3
    FROM units
    WHERE card_name = Unit_Name;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getUnitsByArtistName
-- -----------------------------------------------------

DELIMITER $$
USE `final_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getUnitsByArtistName`(IN Artist_Name varchar(20))
BEGIN
    SELECT *
    FROM units
    WHERE units.artist_name = Artist_Name;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getUnitsByRarity
-- -----------------------------------------------------

DELIMITER $$
USE `final_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getUnitsByRarity`(IN Rarity varchar(20))
BEGIN
    SELECT *
    FROM units
    WHERE units.rarity = Rarity;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getUnitsByRegion
-- -----------------------------------------------------

DELIMITER $$
USE `final_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getUnitsByRegion`(IN Region varchar(20))
BEGIN
	SELECT
		card_name,
        region_1,
        region_2
    FROM units
    WHERE region_1 = Region OR region_2 = Region;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getUnitsRegion
-- -----------------------------------------------------

DELIMITER $$
USE `final_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getUnitsRegion`(IN cardName varchar(20))
BEGIN
	SELECT region_1, region_2
    FROM units
    WHERE units.card_name = cardName;
END$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
