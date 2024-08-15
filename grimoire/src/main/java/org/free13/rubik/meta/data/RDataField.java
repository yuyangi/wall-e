package org.free13.rubik.meta.data;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author free13
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RDataField {

    String name() default ""; // 字段名称

    String type(); // 数据类型

    boolean primaryKey() default false; // 是否为主键

    boolean nullable() default true; // 是否不允许为空

    String defaultValue() default ""; // 默认值

    boolean unique() default false; // 是否唯一

    String indexType() default ""; // 索引类型

    String comment() default ""; // 字段注释

    boolean autoIncrement() default false;

}
