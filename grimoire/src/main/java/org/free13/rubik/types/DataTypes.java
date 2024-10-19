package org.free13.rubik.types;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/*
 *
 * @author free13
 * Copyright (c) 2024.
 */
public class DataTypes {

    public static final int SQL_TYPES_BIT = Types.BIT;
    public static final int SQL_TYPES_TINYINT = Types.TINYINT;
    public static final int SQL_TYPES_SMALLINT = Types.SMALLINT;
    public static final int SQL_TYPES_INTEGER = Types.INTEGER;
    public static final int SQL_TYPES_BIGINT = Types.BIGINT;
    public static final int SQL_TYPES_REAL = Types.REAL;
    public static final int SQL_TYPES_FLOAT = Types.FLOAT;
    public static final int SQL_TYPES_DOUBLE = Types.DOUBLE;
    public static final int SQL_TYPES_NUMERIC = Types.NUMERIC;
    public static final int SQL_TYPES_DECIMAL = Types.DECIMAL;
    public static final int SQL_TYPES_CHAR = Types.CHAR;
    public static final int SQL_TYPES_VARCHAR = Types.VARCHAR;
    public static final int SQL_TYPES_LONGVARCHAR = Types.LONGVARCHAR;
    public static final int SQL_TYPES_DATE = Types.DATE;
    public static final int SQL_TYPES_TIME = Types.TIME;
    public static final int SQL_TYPES_TIMESTAMP = Types.TIMESTAMP;
    public static final int SQL_TYPES_BINARY = Types.BINARY;
    public static final int SQL_TYPES_VARBINARY = Types.VARBINARY;
    public static final int SQL_TYPES_LONGVARBINARY = Types.LONGVARBINARY;
    public static final int SQL_TYPES_BLOB = Types.BLOB;
    public static final int SQL_TYPES_CLOB = Types.CLOB;
    public static final int SQL_TYPES_NCHAR = Types.NCHAR;
    public static final int SQL_TYPES_NVARCHAR = Types.NVARCHAR;
    public static final int SQL_TYPES_LONGNVARCHAR = Types.LONGNVARCHAR;
    public static final int SQL_TYPES_OTHER = Types.OTHER;
    public static final int SQL_TYPES_JAVA_OBJECT = Types.JAVA_OBJECT;

    public static final String JAVA_BOOLEAN = "boolean";
    public static final String JAVA_SHORT = "short";
    public static final String JAVA_INT = "int";
    public static final String JAVA_LONG = "long";
    public static final String JAVA_FLOAT = "float";
    public static final String JAVA_DOUBLE = "double";
    public static final String JAVA_STRING = "String";
    public static final String JAVA_BYTE = "byte";
    public static final String JAVA_BYTE_ARRAY = "byte[]";
    public static final String JAVA_DATE = "Date";
    public static final String JAVA_TIME = "Time";
    public static final String JAVA_BIGDECIMAL = "BigDecimal";

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
