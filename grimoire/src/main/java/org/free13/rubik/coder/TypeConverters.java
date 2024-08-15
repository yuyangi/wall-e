package org.free13.rubik.coder;

import java.util.HashMap;
import java.util.Map;
import java.sql.Types;


/*
 *
 * @author free13
 * Copyright (c) 2024.
 */

/**
 * @author free13
 */
public class TypeConverters {

    public static final Map<String, String> MYSQL_2_JAVA_MAPPING = new HashMap<>();
    public static final Map<Integer, String> MYSQL_2_JAVA_MAPPING2 = new HashMap<>();

    public static final Map<String, String> JAVA_2_MYSQL_MAPPING = new HashMap<>();

    static {

        MYSQL_2_JAVA_MAPPING2.put(Types.BIT, "boolean");
        // MySQL TINYINT can be signed or unsigned
        MYSQL_2_JAVA_MAPPING2.put(Types.TINYINT, "Short");
        MYSQL_2_JAVA_MAPPING2.put(Types.SMALLINT, "Short");
        MYSQL_2_JAVA_MAPPING2.put(Types.INTEGER, "Integer");
        MYSQL_2_JAVA_MAPPING2.put(Types.BIGINT, "Long");
        MYSQL_2_JAVA_MAPPING2.put(Types.REAL, "Float");
        MYSQL_2_JAVA_MAPPING2.put(Types.FLOAT, "Float");
        MYSQL_2_JAVA_MAPPING2.put(Types.DOUBLE, "Double");
        MYSQL_2_JAVA_MAPPING2.put(Types.NUMERIC, "BigDecimal");
        MYSQL_2_JAVA_MAPPING2.put(Types.DECIMAL, "BigDecimal");
        MYSQL_2_JAVA_MAPPING2.put(Types.CHAR, "String");
        MYSQL_2_JAVA_MAPPING2.put(Types.VARCHAR, "String");
        MYSQL_2_JAVA_MAPPING2.put(Types.LONGVARCHAR, "String");
        MYSQL_2_JAVA_MAPPING2.put(Types.DATE, "java.sql.Date");
        MYSQL_2_JAVA_MAPPING2.put(Types.TIME, "java.sql.Time");
        MYSQL_2_JAVA_MAPPING2.put(Types.TIMESTAMP, "java.sql.Timestamp");
        MYSQL_2_JAVA_MAPPING2.put(Types.BINARY, "byte[]");
        MYSQL_2_JAVA_MAPPING2.put(Types.VARBINARY, "byte[]");
        MYSQL_2_JAVA_MAPPING2.put(Types.LONGVARBINARY, "byte[]");
        MYSQL_2_JAVA_MAPPING2.put(Types.BLOB, "byte[]");
        MYSQL_2_JAVA_MAPPING2.put(Types.CLOB, "String");
        // MySQL does not have NCHAR but it's included for completeness
        MYSQL_2_JAVA_MAPPING2.put(Types.NCHAR, "String");
        // MySQL does not have NVARCHAR but it's included for completeness
        MYSQL_2_JAVA_MAPPING2.put(Types.NVARCHAR, "String");
        // MySQL does not have LONGNVARCHAR but it's included for completeness
        MYSQL_2_JAVA_MAPPING2.put(Types.LONGNVARCHAR, "String");
        // For ENUM, SET, and other non-standard types
        MYSQL_2_JAVA_MAPPING2.put(Types.OTHER, "Object");
        // For JSON and other object types
        MYSQL_2_JAVA_MAPPING2.put(Types.JAVA_OBJECT, "Object");


        MYSQL_2_JAVA_MAPPING.put("tinyint", "boolean");
        MYSQL_2_JAVA_MAPPING.put("smallint", "short");
        MYSQL_2_JAVA_MAPPING.put("mediumint", "int");
        MYSQL_2_JAVA_MAPPING.put("int", "int");
        MYSQL_2_JAVA_MAPPING.put("bigint", "long");
        MYSQL_2_JAVA_MAPPING.put("decimal", "BigDecimal");
        MYSQL_2_JAVA_MAPPING.put("float", "float");
        MYSQL_2_JAVA_MAPPING.put("double", "double");
        MYSQL_2_JAVA_MAPPING.put("char", "String");
        MYSQL_2_JAVA_MAPPING.put("varchar", "String");
        MYSQL_2_JAVA_MAPPING.put("text", "String");
        MYSQL_2_JAVA_MAPPING.put("blob", "byte[]");
        MYSQL_2_JAVA_MAPPING.put("date", "Date");
        MYSQL_2_JAVA_MAPPING.put("datetime", "Date");
        MYSQL_2_JAVA_MAPPING.put("timestamp", "Date");
        MYSQL_2_JAVA_MAPPING.put("time", "Time");
        MYSQL_2_JAVA_MAPPING.put("year", "int");
        MYSQL_2_JAVA_MAPPING.put("enum", "String");
        MYSQL_2_JAVA_MAPPING.put("set", "String");
        MYSQL_2_JAVA_MAPPING.put("bit", "boolean");
        MYSQL_2_JAVA_MAPPING.put("geometry", "String");
        MYSQL_2_JAVA_MAPPING.put("geometrycollection", "String");
        MYSQL_2_JAVA_MAPPING.put("linestring", "String");
        MYSQL_2_JAVA_MAPPING.put("multilinestring", "String");
        // ...

        JAVA_2_MYSQL_MAPPING.put("boolean", "tinyint");
        JAVA_2_MYSQL_MAPPING.put("short", "smallint");
        JAVA_2_MYSQL_MAPPING.put("int", "int");
        JAVA_2_MYSQL_MAPPING.put("long", "bigint");
        JAVA_2_MYSQL_MAPPING.put("float", "float");
        JAVA_2_MYSQL_MAPPING.put("double", "double");
        JAVA_2_MYSQL_MAPPING.put("String", "varchar");
        JAVA_2_MYSQL_MAPPING.put("byte[]", "blob");
        JAVA_2_MYSQL_MAPPING.put("Date", "datetime");
        JAVA_2_MYSQL_MAPPING.put("Time", "time");
        JAVA_2_MYSQL_MAPPING.put("BigDecimal", "decimal");
    }

    public static String getJavaType(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Unsupported type: empty type");
        }
        type = type.toLowerCase();
        if (MYSQL_2_JAVA_MAPPING.containsKey(type)) {
            return MYSQL_2_JAVA_MAPPING.get(type);
        } else {
            throw new IllegalArgumentException("Unsupported type: " + type);
        }
    }

    public static String getJavaType(Integer type) {
        if (type == null) {
            throw new IllegalArgumentException("Unsupported type: empty type");
        }
        if (MYSQL_2_JAVA_MAPPING2.containsKey(type)) {
            return MYSQL_2_JAVA_MAPPING2.get(type);
        } else {
            throw new IllegalArgumentException("Unsupported type: " + type);
        }
    }

    public static String getMySqlType(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Unsupported type: empty type");
        }
        type = type.toLowerCase();
        if (JAVA_2_MYSQL_MAPPING.containsKey(type)) {
            return JAVA_2_MYSQL_MAPPING.get(type);
        } else {
            throw new IllegalArgumentException("Unsupported type: " + type);
        }
    }
}
