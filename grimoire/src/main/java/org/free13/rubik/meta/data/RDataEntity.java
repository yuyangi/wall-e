package org.free13.rubik.meta.data;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author free13
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RDataEntity {

    String name(); // 表名称（中文）
    String code(); // 编码
    String comment() default ""; // 表注释
    String dbType() default "mysql"; // 数据库类型
    String dbName() default "default";
    String schema() default "public"; // 模式
    String tableName() default "";

}
