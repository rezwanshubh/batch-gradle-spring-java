DROP TABLE IF EXISTS agency;
DROP TABLE IF EXISTS calendar;

CREATE TABLE `agency` (`id` BIGINT(20)  NOT NULL AUTO_INCREMENT, `agency_id`  VARCHAR(40) NULL, `agency_name` VARCHAR(500) NULL, `agency_url`  VARCHAR(500) NULL, `agency_timezone` VARCHAR(40) NULL, `agency_phone`  VARCHAR(40) NULL, `agency_lang` VARCHAR(20) NULL, PRIMARY KEY (`id`));
CREATE TABLE `calendar` (`id` BIGINT(20)  NOT NULL AUTO_INCREMENT, `service_id`  BIGINT(20) NULL, `monday` BIT NULL, `tuesday`  BIT(1) NULL, `wednesday` BIT(1) NULL, `thursday`  BIT(1) NULL, `friday` BIT(1) NULL, `saturday` BIT(1) NULL, `sunday` BIT(1) NULL, `start_date` DATE NULL, `end_date` DATE NULL, PRIMARY KEY (`id`));

