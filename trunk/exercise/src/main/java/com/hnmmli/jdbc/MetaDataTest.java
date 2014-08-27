package com.hnmmli.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class MetaDataTest
{
    public static void main(String[] args)
    {
        Connection conn = null;
        try
        {
            conn = ConnectionUtils.connection();
            DatabaseMetaData meta = conn.getMetaData();
            System.out.println(meta.supportsCatalogsInPrivilegeDefinitions());
            System.out.println(meta.nullPlusNonNullIsNull());
            // getTables(meta);
            System.out.println("--------------------------------------------------------------------");
            // getColumns(meta);
            System.out.println("--------------------------------------------------------------------");
            // getPrimaryKeys(meta);
            System.out.println("--------------------------------------------------------------------");
            showColumn(conn);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            ConnectionUtils.close(conn);
        }
    }

    private static void showColumn(Connection conn) throws Exception
    {
        Statement stmt = conn.createStatement();
        ResultSet mrs = stmt.executeQuery("select * from test");
        ResultSetMetaData meta = mrs.getMetaData();
        for (int i = 1; i <= meta.getColumnCount(); i++)
        {
            System.out.println("============================");
            System.out.println(meta.getColumnLabel(i));
            System.out.println(meta.getColumnDisplaySize(i));
        }

    }

    private static void getColumns(DatabaseMetaData meta) throws Exception
    {
        // 参数catalog : 类别名称
        // 参数schema : 用户方案名称
        // 参数tableName : 数据库表名称
        // 参数columnName : 列名称
        ResultSet mrs = meta.getColumns("javacore", null, "test", "ID");
        while (mrs.next())
        {
            System.out.println("++++++++++++++++++++++++++++++++++++++");
            // 1. TABLE_CAT String => 表类别（可为 null）
            // 2. TABLE_SCHEM String => 表模式（可为 null）
            // 3. TABLE_NAME String => 表名称
            // 4. COLUMN_NAME String => 列名称
            // 5. DATA_TYPE int => 来自 java.sql.Types 的 SQL 类型
            // 6. TYPE_NAME String => 数据源依赖的类型名称，对于 UDT，该类型名称是完全限定的
            // 7. COLUMN_SIZE int => 列的大小。
            // 8. BUFFER_LENGTH 未被使用。
            // 9. DECIMAL_DIGITS int => 小数部分的位数。对于 DECIMAL_DIGITS 不适用的数据类型，则返回 Null。
            // 10. NUM_PREC_RADIX int => 基数（通常为 10 或 2）
            // NULLABLE int => 是否允许使用 NULL。
            // columnNoNulls - 可能不允许使用 NULL 值
            // columnNullable - 明确允许使用 NULL 值
            // 11. columnNullableUnknown - 不知道是否可使用 null
            // 12. REMARKS String => 描述列的注释（可为 null）
            // 13. COLUMN_DEF String => 该列的默认值，当值在单引号内时应被解释为一个字符串（可为 null）
            // 14. SQL_DATA_TYPE int => 未使用
            // 15. SQL_DATETIME_SUB int => 未使用
            // 16. CHAR_OCTET_LENGTH int => 对于 char 类型，该长度是列中的最大字节数
            // 17. ORDINAL_POSITION int => 表中的列的索引（从 1 开始）
            // 18. IS_NULLABLE String => ISO 规则用于确定列是否包括 null。
            // YES --- 如果参数可以包括 NULL
            // NO --- 如果参数不可以包括 NULL
            // 空字符串 --- 如果不知道参数是否可以包括 null
            // 19. SCOPE_CATLOG String => 表的类别，它是引用属性的作用域（如果 DATA_TYPE 不是 REF，则为 null）
            // 20. SCOPE_SCHEMA String => 表的模式，它是引用属性的作用域（如果 DATA_TYPE 不是 REF，则为 null）
            // 21. SCOPE_TABLE String => 表名称，它是引用属性的作用域（如果 DATA_TYPE 不是 REF，则为 null）
            // 22. SOURCE_DATA_TYPE short => 不同类型或用户生成 Ref 类型、来自 java.sql.Types 的 SQL 类型的源类型（如果 DATA_TYPE 不是
            // DISTINCT
            // 或用户生成的 REF，则为 null）
            // 23. IS_AUTOINCREMENT String => 指示此列是否自动增加
            // YES --- 如果该列自动增加
            // NO --- 如果该列不自动增加
            // 空字符串 --- 如果不能确定该列是否是自动增加参数
            System.out.println("TABLE_CAT =====" + mrs.getString(1));
            System.out.println("TABLE_SCHEM =====" + mrs.getString(2));
            System.out.println("TABLE_NAME =====" + mrs.getString(3));
            System.out.println("COLUMN_NAME =====" + mrs.getString(4));
            System.out.println("DATA_TYPE =====" + mrs.getString(5));
            System.out.println("TYPE_NAME =====" + mrs.getString(6));
            System.out.println("COLUMN_SIZE =====" + mrs.getString(7));
            System.out.println("BUFFER_LENGTH =====" + mrs.getString(8));
            System.out.println("DECIMAL_DIGITS =====" + mrs.getString(9));
            System.out.println("NUM_PREC_RADIX =====" + mrs.getString(10));

            System.out.println("NULLABLE =====" + mrs.getString(11));
            System.out.println("REMARKS =====" + mrs.getString(12));
            System.out.println("COLUMN_DEF =====" + mrs.getString(13));
            System.out.println("SQL_DATA_TYPE =====" + mrs.getString(14));
            System.out.println("SQL_DATETIME_SUB =====" + mrs.getString(15));
            System.out.println("CHAR_OCTET_LENGTH =====" + mrs.getString(16));
            System.out.println("ORDINAL_POSITION =====" + mrs.getString(17));
            System.out.println("IS_NULLABLE =====" + mrs.getString(18));
            System.out.println("SCOPE_CATLOG =====" + mrs.getString(19));
            System.out.println("SCOPE_SCHEMA =====" + mrs.getString(20));

            System.out.println("SCOPE_TABLE =====" + mrs.getString(21));
            System.out.println("SOURCE_DATA_TYPE =====" + mrs.getString(22));
            System.out.println("IS_AUTOINCREMENT =====" + mrs.getString(23));
            System.out.println("++++++++++++++++++++++++++++++++++++++");
        }
    }

    private static void getPrimaryKeys(DatabaseMetaData meta) throws Exception
    {
        // 参数catalog : 类别名称
        // 参数schema : 用户方案名称
        // 参数tableName : 数据库表名称
        // 备注：一定要指定表名称，否则返回值将是什么都没有。
        ResultSet mrs = meta.getPrimaryKeys("javacore", null, "test");
        while (mrs.next())
        {
            System.out.println("++++++++++++++++++++++++++++++++++++++");
            // 1. TABLE_CAT String => 表类别（可为 null）
            // 2. TABLE_SCHEM String => 表模式（可为 null）
            // 3. TABLE_NAME String => 表名称
            // 4. COLUMN_NAME String => 列名称
            // 5. KEY_SEQ short => 主键中的序列号（值 1 表示主键中的第一列，值 2 表示主键中的第二列）。
            // 6. PK_NAME String => 主键的名称（可为 null）
            System.out.println("TABLE_CAT =====" + mrs.getString(1));
            System.out.println("TABLE_SCHEM =====" + mrs.getString(2));
            System.out.println("TABLE_NAME =====" + mrs.getString(3));
            System.out.println("COLUMN_NAME =====" + mrs.getString(4));
            System.out.println("KEY_SEQ =====" + mrs.getString(5));
            System.out.println("PK_NAME =====" + mrs.getString(6));
            System.out.println("++++++++++++++++++++++++++++++++++++++");
        }
    }

    private static void getTables(DatabaseMetaData meta) throws Exception
    {
        // 参数:catalog:目录名称，一般都为空.
        // 参数：schema:数据库名，对于oracle来说就用户名
        // 参数：tablename:表名称
        // 参数：type :表的类型(TABLE | VIEW)
        ResultSet mrs = meta.getTables("javacore", null, "test", null);// new String[] { "TABLE" });
        while (mrs.next())
        {
            System.out.println("++++++++++++++++++++++++++++++++++++++");
            // 1. TABLE_CAT String => 表类别（可为 null）【数据库名称】
            // 2. TABLE_SCHEM String => 表模式（可为 null）
            // 3. TABLE_NAME String => 表名称
            // 4. TABLE_TYPE String => 表类型。典型的类型是
            // "TABLE"、"VIEW"、"SYSTEM TABLE"、"GLOBAL TEMPORARY"、"LOCAL TEMPORARY"、"ALIAS" 和 "SYNONYM"。
            // 5. REMARKS String => 表的解释性注释
            // 6. TYPE_CAT String => 类型的类别（可为 null）
            // 7. TYPE_SCHEM String => 类型模式（可为 null）
            // 8. TYPE_NAME String => 类型名称（可为 null）
            // 9. SELF_REFERENCING_COL_NAME String => 有类型表的指定 "identifier" 列的名称（可为 null）
            // 10. REF_GENERATION String => 指定在 SELF_REFERENCING_COL_NAME 中创建值的方式。这些值为 "SYSTEM"、"USER" 和
            // "DERIVED"。（可能为null）
            // 注： 有些数据库可能不返回用于所有表的信息。
            System.out.println("TABLE_CAT =====" + mrs.getString(1));
            System.out.println("TABLE_SCHEM =====" + mrs.getString(2));
            System.out.println("TABLE_NAME =====" + mrs.getString(3));
            System.out.println("TABLE_TYPE =====" + mrs.getString(4));
            System.out.println("REMARKS =====" + mrs.getString(5));
            // System.out.println("TYPE_CAT =====" + mrs.getString(6));
            // System.out.println("TYPE_SCHEM =====" + mrs.getString(7));
            // System.out.println("TYPE_NAME =====" + mrs.getString(8));
            // System.out.println("SELF_REFERENCING_COL_NAME =====" + mrs.getString(9));
            // System.out.println("REF_GENERATION =====" + mrs.getString(10));
            System.out.println("++++++++++++++++++++++++++++++++++++++");
        }
    }
}