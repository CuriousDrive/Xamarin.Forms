USE CURIOUS_DRIVE;
GO
-- Truncate the log by changing the database recovery model to SIMPLE.
ALTER DATABASE CURIOUS_DRIVE
SET RECOVERY SIMPLE;
GO
-- Shrink the truncated log file to 1 MB.
DBCC SHRINKFILE (CURIOUS_DRIVE_Log, 1);
GO
-- Reset the database recovery model.
ALTER DATABASE CURIOUS_DRIVE
SET RECOVERY FULL;
GO

BACKUP DATABASE CURIOUS_DRIVE TO DISK = 'C:\Data\Curiouss Box\Workspace\CurioussBoxSource\DB Backups\TEST.bak' WITH INIT