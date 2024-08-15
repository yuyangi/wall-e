package org.free13.rubik.coder;

import com.alibaba.druid.sql.ast.SQLName;
import com.alibaba.druid.sql.ast.statement.SQLColumnConstraint;
import com.alibaba.druid.sql.ast.statement.SQLColumnDefinition;
import com.alibaba.druid.sql.ast.statement.SQLCreateTableStatement;
import com.alibaba.druid.sql.ast.statement.SQLTableElement;
import com.alibaba.druid.sql.parser.SQLParserUtils;
import com.alibaba.druid.sql.parser.SQLStatementParser;
import org.free13.rubik.meta.data.RDataEntity;
import org.free13.rubik.meta.data.RDataField;

import java.util.List;

import static org.free13.rubik.coder.NamingConverter.capitalize;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public class RSQL2JavaCoder implements RCoder<String> {

    /**
     * 只处理Create Table语句，根据Create Table语句生成Java实体类
     * @param sql
     * @return
     */
    @Override
    public String coding(String sql, String packages) {
        return generateJavaClassFromSql(sql, packages);
    }

    @Override
    public String decoding(String code) {
        return null;
    }

    @Override
    public String language() {
        return "java";
    }

    /**
     * 根据Create Table语句生成Java实体类
     * @param sql 建表语句
     * @param packages 包名
     * @return java代码（字符串）
     */
    public static String generateJavaClassFromSql(String sql, String packages) {
        SQLStatementParser createParser = SQLParserUtils.createSQLStatementParser(sql, "mysql");
        SQLCreateTableStatement sqlCreateTableStatement = createParser.getSQLCreateTableParser().parseCrateTable();
        SQLName name = sqlCreateTableStatement.getName();
        String className = NamingConverter.underscoreToCamelCase(name.getSimpleName(), true);
        StringBuilder entityCode = new StringBuilder();
        entityCode.append("package ").append(packages).append(";\n\n");
        entityCode.append("import javax.persistence.*;\n");
        entityCode.append("import java.util.Date;\n");
        entityCode.append("import java.math.BigDecimal;\n\n");
        entityCode.append("import ").append(RDataField.class.getPackage()).append(";\n");
        entityCode.append("import ").append(RDataEntity.class.getPackage()).append(";\n");
        entityCode.append("@RDataEntity(name = \"").append(name.getSimpleName()).append("\")\n");
        entityCode.append("public class ").append(className).append(" {\n\n");

        List<SQLTableElement> tableElementList = sqlCreateTableStatement.getTableElementList();
        if (tableElementList != null) {
            for (SQLTableElement tableElement : tableElementList) {
                if (tableElement instanceof SQLColumnDefinition columnDefinition) {
                    String fieldName = columnDefinition.getName().getSimpleName();
                    String fieldType = columnDefinition.getDataType().getName();
                    String javaType = TypeConverters.getJavaType(fieldType);
                    if (javaType == null) {
                        throw new IllegalArgumentException("Unsupported data type: " + fieldType);
                    }

                    entityCode.append("    @RDataField(name = \"").append(fieldName).append("\"");
                    if (columnDefinition.getConstraints() != null) {
                        for (SQLColumnConstraint constraint : columnDefinition.getConstraints()) {
                            if ("PRIMARY KEY".equals(constraint.getName().getSimpleName())) {
                                entityCode.append(", primaryKey = true");
                            } else if ("AUTO_INCREMENT".equals(constraint.getName().getSimpleName())) {
                                entityCode.append(", autoIncrement = true");
                            } else if ("UNIQUE".equals(constraint.getName().getSimpleName())) {
                                entityCode.append(", unique = true");
                            } else if ("NOT NULL".equals(constraint.getName().getSimpleName())) {
                                entityCode.append(", nullable = false");
                            } else if (constraint.getName().getSimpleName().startsWith("DEFAULT")) {
                                String constraintStr = constraint.getName().getSimpleName();
                                String defaultValue = constraintStr.substring(constraintStr.indexOf("'") + 1, constraintStr.lastIndexOf("'"));
                                entityCode.append(", defaultValue = ").append(defaultValue);
                            }
                        }
                    }
                    if (columnDefinition.getComment() != null) {
                        entityCode.append(", comment = ").append(columnDefinition.getComment().toString());
                    }

                    entityCode.append(")\n");
                    entityCode.append("    private ").append(javaType).append(" ").append(fieldName).append(";\n\n");
                    entityCode.append("    public ").append(javaType).append(" get").append(capitalize(fieldName))
                            .append("() {\n");
                    entityCode.append("        return this.").append(fieldName).append(";\n");
                    entityCode.append("    }\n\n");
                    entityCode.append("    public void set").append(capitalize(fieldName)).append("(").append(javaType)
                            .append(" ").append(fieldName).append(") {\n");
                    entityCode.append("        this.").append(fieldName).append(" = ").append(fieldName).append(";\n");
                    entityCode.append("    }\n\n");
                }
            }
        }
        entityCode.append("}\n");
        return entityCode.toString();
    }





}
