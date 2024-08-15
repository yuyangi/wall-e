package org.free13.rubik.coder;

import org.free13.rubik.meta.data.RDataEntity;
import org.free13.rubik.meta.data.RDataField;

import java.lang.reflect.Field;

/**
 * @author free13 Copyright (c) 2024.
 */
public class RJava2SQLCoder implements RCoder<Class<?>> {

    @Override
    public String coding(Class<?> source, String packages) {
        return generateCreateTableStatement(source);
    }

    @Override
    public Class<?> decoding(String code) {
        return null;
    }

    @Override
    public String language() {
        return "sql";
    }

    public static String generateCreateTableStatement(Class<?> clazz) {
        if (!clazz.isAnnotationPresent(RDataEntity.class)) {
            return "";
        }
        RDataEntity entity = clazz.getAnnotation(RDataEntity.class);
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE IF NOT EXISTS ").append(entity.tableName()).append(" (\n");

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(RDataField.class)) {
                RDataField rDataField = field.getAnnotation(RDataField.class);
                if (rDataField != null) {
                    sqlBuilder.append("`").append(rDataField.name().isEmpty() ? field.getName() : rDataField.name())
                            .append("` ").append(rDataField.type().isEmpty() ? "VARCHAR(255)" : rDataField.type());

                    if (rDataField.primaryKey()) {
                        sqlBuilder.append(" PRIMARY KEY");
                        if (rDataField.autoIncrement()) {
                            sqlBuilder.append(" AUTO_INCREMENT");
                        }
                    } else if (!rDataField.nullable()) {
                        sqlBuilder.append(" NOT NULL");
                    }

                    if (!rDataField.defaultValue().isEmpty()) {
                        sqlBuilder.append(" DEFAULT ").append(rDataField.defaultValue());
                    }

                    if (rDataField.unique()) {
                        sqlBuilder.append(" UNIQUE");
                    }

                    sqlBuilder.append(", ");
                }
            }
        }

        // 移除最后一个逗号和换行符
        if (sqlBuilder.length() > 0) {
            // 移除最后一个逗号
            sqlBuilder.setLength(sqlBuilder.length() - 2);
        }
        sqlBuilder.append("\n);");

        return sqlBuilder.toString();
    }

}
