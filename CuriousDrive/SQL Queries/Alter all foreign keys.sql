select schema_name(fk_tab.schema_id) + '.' + fk_tab.name as foreign_table,
    '>-' as rel,
    schema_name(pk_tab.schema_id) + '.' + pk_tab.name as primary_table,
    substring(column_names, 1, len(column_names)-1) as [fk_columns],
    fk.name as fk_constraint_name
from sys.foreign_keys fk
    inner join sys.tables fk_tab
        on fk_tab.object_id = fk.parent_object_id
    inner join sys.tables pk_tab
        on pk_tab.object_id = fk.referenced_object_id
    cross apply (select col.[name] + ', '
                    from sys.foreign_key_columns fk_c
                        inner join sys.columns col
                            on fk_c.parent_object_id = col.object_id
                            and fk_c.parent_column_id = col.column_id
                    where fk_c.parent_object_id = fk_tab.object_id
                      and fk_c.constraint_object_id = fk.object_id
                            order by col.column_id
                            for xml path ('') ) D (column_names)
order by schema_name(fk_tab.schema_id) + '.' + fk_tab.name,
    schema_name(pk_tab.schema_id) + '.' + pk_tab.name