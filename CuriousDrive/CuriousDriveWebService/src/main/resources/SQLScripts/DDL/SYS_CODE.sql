CREATE TABLE if not exists `SYS_CODE` (
    `CODE_ID` int(11) NOT NULL AUTO_INCREMENT,
    `CODE_DESCRIPTION` varchar(50) NOT NULL,
    `DATA1_CAPTION` varchar(50)  NULL,
    `DATA1_TYPE` varchar(50) DEFAULT NULL,
    `DATA2_CAPTION` varchar(50) NULL,
    `DATA2_TYPE` varchar(50) DEFAULT NULL,
    `DATA3_CAPTION` varchar(50) NULL,
    `DATA3_TYPE` varchar(50) DEFAULT NULL,
    `COMMENTS` varchar(50) DEFAULT NULL,
    `CREATED_BY` int(11) DEFAULT NULL,
	`CREATED_DATE` DATETIME DEFAULT NULL,
    `MODIFIED_BY` int(11) DEFAULT NULL,
	`MODIFIED_DATE` DATETIME DEFAULT NULL,
    `UPDATE_SEQ` int(11) DEFAULT NULL,
    PRIMARY KEY (`CODE_ID`)
)  ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Code Value 1 - Network Type
INSERT INTO `SYS_CODE` 
SELECT 1,'Network Type',null,null,null,null,null,null,'This code id holds data for different types of networks',1,now(),1,now(),0 FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM SYS_CODE WHERE CODE_ID = 1 AND CODE_DESCRIPTION = 'Network Type');

-- Code Value 2 - Gender Type
INSERT  INTO `SYS_CODE` 
SELECT 2,'Gender',null,null,null,null,null,null,'Gender Values',1,now(),1,now(),0 FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM SYS_CODE WHERE CODE_ID = 2 AND CODE_DESCRIPTION = 'Gender');

-- Code Value 3 - Constants Value
INSERT  INTO `SYS_CODE` 
SELECT 3,'Constants',null,null,null,null,null,null,'Costant Values',1,now(),1,now(),0 FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM SYS_CODE WHERE CODE_ID = 3 AND CODE_DESCRIPTION = 'Constants');

-- Code Value 4 - System Region Values
INSERT  INTO `SYS_CODE` 
SELECT 4,'Region',null,null,null,null,null,null,'System Region',1,now(),1,now(),0 FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM SYS_CODE WHERE CODE_ID = 4 AND CODE_DESCRIPTION = 'Region');

-- Code Value 5 - System Message Type Values
INSERT  INTO `SYS_CODE` 
SELECT 5,'Message Type',null,null,null,null,null,null,'Message Types',1,now(),1,now(),0 FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM SYS_CODE WHERE CODE_ID = 5 AND CODE_DESCRIPTION = 'Message Type');

-- Code Value 6 - System Message Type Values
INSERT  INTO `SYS_CODE` 
SELECT 6,'Category Status',null,null,null,null,null,null,'Category Statuses',1,now(),1,now(),0 FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM SYS_CODE WHERE CODE_ID = 6 AND CODE_DESCRIPTION = 'Category Status');

-- Code Value 7 - Thread Status
INSERT  INTO `SYS_CODE` 
SELECT 7,'Thread Status',null,null,null,null,null,null,'Thread Statuses',1,now(),1,now(),0 FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM SYS_CODE WHERE CODE_ID = 7 AND CODE_DESCRIPTION = 'Thread Status');

-- Code Value 8 - Post Comment Types
INSERT  INTO `SYS_CODE` 
SELECT 8,'Post Comment Types',null,null,null,null,null,null,'Post Comment Types',1,now(),1,now(),0 FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM SYS_CODE WHERE CODE_ID = 8 AND CODE_DESCRIPTION = 'Post Comment Types');

-- Code Value 9 - Vote Types
INSERT  INTO `SYS_CODE` 
SELECT 9,'Vote Types',null,null,null,null,null,null,'Vote Types',1,now(),1,now(),0 FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM SYS_CODE WHERE CODE_ID = 9 AND CODE_DESCRIPTION = 'Vote Types');

-- Code Value 10 - Post Vote Types
INSERT  INTO `SYS_CODE` 
SELECT 10,'Post Vote Types',null,null,null,null,null,null,'Post Vote Types',1,now(),1,now(),0 FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM SYS_CODE WHERE CODE_ID = 10 AND CODE_DESCRIPTION = 'Post Vote Types');

-- Code Value 11 - Action Types
INSERT  INTO `SYS_CODE` 
SELECT 11,'Action Types',null,null,null,null,null,null,'Action Types',1,now(),1,now(),0 FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM SYS_CODE WHERE CODE_ID = 11 AND CODE_DESCRIPTION = 'Action Types');

-- Code Value 12 - Point Types
INSERT  INTO `SYS_CODE` 
SELECT 12,'Point Types',null,null,null,null,null,null,'Point Types',1,now(),1,now(),0 FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM SYS_CODE WHERE CODE_ID = 12 AND CODE_DESCRIPTION = 'Point Types');

-- Code Value 14 - Roles
INSERT  INTO `SYS_CODE` 
SELECT 14,'Roles',null,null,null,null,null,null,'Roles',1,now(),1,now(),0 FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM SYS_CODE WHERE CODE_ID = 14 AND CODE_DESCRIPTION = 'Roles');

-- Code Value 15 - User Groups
INSERT  INTO `SYS_CODE` 
SELECT 15,'User Groups',null,null,null,null,null,null,'User Groups',1,now(),1,now(),0 FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM SYS_CODE WHERE CODE_ID = 15 AND CODE_DESCRIPTION = 'User Groups');

-- Code Value 16 - Group Status
INSERT  INTO `SYS_CODE` 
SELECT 16,'Group Status',null,null,null,null,null,null,'Group Status',1,now(),1,now(),0 FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM SYS_CODE WHERE CODE_ID = 16 AND CODE_DESCRIPTION = 'Group Status');

-- Code Value 17 - User Group Types
INSERT  INTO `SYS_CODE` 
SELECT 17,'User Group Types',null,null,null,null,null,null,'User Group Types',1,now(),1,now(),0 FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM SYS_CODE WHERE CODE_ID = 17 AND CODE_DESCRIPTION = 'User Group Types');

-- Code Value 18 - User Status
INSERT  INTO `SYS_CODE` 
SELECT 18,'User Status',null,null,null,null,null,null,'User Statuses',1,now(),1,now(),0 FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM SYS_CODE WHERE CODE_ID = 18 AND CODE_DESCRIPTION = 'User Status');

