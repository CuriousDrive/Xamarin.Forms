CREATE TABLE IF NOT EXISTS `TRAN_THREAD` (
    `THREAD_ID` INT(11) NOT NULL AUTO_INCREMENT,
    `THREAD` VARCHAR(100) NULL,
	`THREAD_LINK` VARCHAR(500) NULL,
	`DESCRIPTION` VARCHAR(500) NULL,	
	`STATUS_ID` int(11) NOT NULL,
    `STATUS_VALUE` varchar(50) DEFAULT NULL,
    `CREATED_BY` INT(11) DEFAULT NULL,
	`CREATED_DATE` DATETIME DEFAULT NULL,
    `MODIFIED_BY` INT(11) DEFAULT NULL,
	`MODIFIED_DATE` DATETIME DEFAULT NULL,
    `UPDATE_SEQ` INT(11) DEFAULT NULL,
    PRIMARY KEY (`THREAD_ID`)
)  ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `CURIOSITE`.`TRAN_THREAD` (`THREAD`, `THREAD_LINK`, `DESCRIPTION`, `STATUS_ID`,`STATUS_VALUE`,`CREATED_BY`, `CREATED_DATE`, `MODIFIED_BY`, `MODIFIED_DATE`, `UPDATE_SEQ`) 
select 'Cosmology', '', 'the science of the origin and development of the universe. Modern astronomy is dominated by the Big Bang theory, 
which brings together observational astronomy and particle physics.', 7,'APPR','1', now(), '1', now(), '0' FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM  TRAN_THREAD WHERE THREAD = 'Cosmology');


INSERT INTO `CURIOSITE`.`TRAN_THREAD` (`THREAD`, `THREAD_LINK`, `DESCRIPTION`, `STATUS_ID`,`STATUS_VALUE`,`CREATED_BY`, `CREATED_DATE`, `MODIFIED_BY`, `MODIFIED_DATE`, `UPDATE_SEQ`) 
select 'Religion', '', 'A religion is an organized collection of beliefs, cultural systems, and world views that relate humanity to an order of existence. Many religions have narratives, symbols, and sacred histories that 
aim to explain the meaning of life, the origin of life, or the Universe', 7,'APPR','1', now(), '1', now(), '0' FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM  TRAN_THREAD WHERE THREAD = 'Religion');
