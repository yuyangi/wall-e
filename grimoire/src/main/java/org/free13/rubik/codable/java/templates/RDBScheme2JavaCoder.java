package org.free13.rubik.codable.java.templates;

import org.free13.rubik.types.DataTypes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.free13.rubik.utilities.NamingUtils.capitalize;
import static org.free13.rubik.utilities.NamingUtils.underscoreToCamelCase;

/*
 *
 * @author free13
 * Copyright (c) 2024.
 */
public class RDBScheme2JavaCoder {

    private Connection connection;

    public RDBScheme2JavaCoder(Connection connection) {
        this.connection = connection;
    }

    public String coding(String source, String packages) {
        try {
            return generateJavaClassFromSchema(source, packages);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String decoding(String code) {
        return null;
    }

    public String language() {
        return "";
    }

    public String generateJavaClassFromSchema(String tableName, String packageName) throws SQLException {
        StringBuilder entityCode = new StringBuilder();
        entityCode.append("package ").append(packageName).append(";\n\n");
        entityCode.append("import javax.persistence.*;\n");
        entityCode.append("import java.util.Date;\n");
        entityCode.append("import java.math.BigDecimal;\n\n");
        entityCode.append("@Entity\n");
        entityCode.append("@Table(name = \"").append(tableName).append("\")\n");
        entityCode.append("public class ").append(underscoreToCamelCase(tableName, true)).append(" {\n\n");
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet columns = metaData.getColumns(null, null, tableName, null);
        ResultSet primaryKeys = metaData.getPrimaryKeys(null, null, tableName);
        List<String> primaryKeyNames = new ArrayList<>();
        while (primaryKeys.next()) {
            primaryKeyNames.add(primaryKeys.getString("COLUMN_NAME"));
        }

        while (columns.next()) {
            String columnName = columns.getString("COLUMN_NAME");
            int sqlType = columns.getInt("DATA_TYPE");
            String javaType = DataTypes.getJavaType(sqlType);
            String sqlTypeStr = DataTypes.getMySqlType(javaType);
            boolean isNullable = "YES".equals(columns.getString("IS_NULLABLE"));
            boolean isAutoIncrement = "YES".equals(columns.getString("IS_AUTOINCREMENT"));
            String remarks = columns.getString("REMARKS");
            String defaultValue = columns.getString("COLUMN_DEF");

            entityCode.append("    @RDataField(name = \"").append(columnName).append("\", nullable = ")
                    .append(isNullable ? "true" : "false");
            if (sqlTypeStr != null) {
                entityCode.append(", type = \"").append(sqlTypeStr).append("\"");
            }
            if (isAutoIncrement) {
                entityCode.append(", autoIncrement = true");
            }
            if (primaryKeyNames.contains(columnName)) {
                entityCode.append(", primaryKey = true");
            }
            if (remarks != null && !remarks.isEmpty()) {
                entityCode.append(", comment = \"").append(remarks).append("\"");
            }
            if (defaultValue != null) {
                entityCode.append(", defaultValue = \"").append(defaultValue).append("\"");
            }
            entityCode.append(")");
            entityCode.append("    private ").append(javaType).append(" ").append(columnName).append(";\n\n");

            entityCode.append("    public ").append(javaType).append(" get").append(capitalize(columnName))
                    .append("() {\n");
            entityCode.append("        return this.").append(columnName).append(";\n");
            entityCode.append("    }\n\n");

            entityCode.append("    public void set").append(capitalize(columnName)).append("(").append(javaType)
                    .append(" ").append(columnName).append(") {\n");
            entityCode.append("        this.").append(columnName).append(" = ").append(columnName).append(";\n");
            entityCode.append("    }\n\n");
        }
        entityCode.append("}\n");
        return entityCode.toString();
    }
}
