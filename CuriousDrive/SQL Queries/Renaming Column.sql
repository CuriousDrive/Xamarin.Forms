EXEC sp_RENAME 'Authors.au_id' , 'Authors.AuthorId', 'COLUMN'

select o.name as ObjName, r.name as ReferencedObj
from sys.sql_dependencies d
join sys.objects o on o.object_id=d.object_id
join sys.objects r on r.object_id=d.referenced_major_id
where 
-- d.class=1 AND 
r.name = 'Authors.au_id'