USE CURIOUS_DRIVE

DECLARE @OldSchema AS varchar(255)
DECLARE @NewSchema AS varchar(255)
DECLARE @newLine AS varchar(2) = CHAR(13) + CHAR(10)

SET @OldSchema = 'curious_drive'
SET @NewSchema = 'dbo'

DECLARE @sql AS varchar(MAX)

SET @sql = 'CREATE SCHEMA [' + @NewSchema + ']' + @newLine
SELECT @sql = @sql + 'GO' + @newLine
SELECT @sql = @sql + 'ALTER SCHEMA [' + @NewSchema + '] TRANSFER [' + TABLE_SCHEMA + '].[' + TABLE_NAME + ']'
     + @newLine
FROM INFORMATION_SCHEMA.TABLES
WHERE TABLE_SCHEMA = @OldSchema

SET @sql = @sql + 'DROP SCHEMA [' + @OldSchema + ']'

PRINT @sql -- NOTE PRINT HAS AN 8000 byte limit - 8000 varchar/4000 nvarchar - see comments
IF (0=1) EXEC (@sql)