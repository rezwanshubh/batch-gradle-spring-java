DROP TABLE IF EXISTS agency;

CREATE TABLE `agency` (`id` BIGINT(20)  NOT NULL AUTO_INCREMENT, `agency_id`  VARCHAR(40) NULL, `agency_name` VARCHAR(500) NULL, `agency_url`  VARCHAR(500) NULL, `agency_timezone` VARCHAR(40) NULL, `agency_phone`  VARCHAR(40) NULL, `agency_lang` VARCHAR(20) NULL, PRIMARY KEY (`id`));

