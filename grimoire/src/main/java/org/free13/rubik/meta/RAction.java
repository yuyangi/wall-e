package org.free13.rubik.meta;

import java.lang.annotation.*;

/**
 * @author free13
 * Copyright (c) 2024.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Inherited
public @interface RAction {

    String name() default ""; // 字段名称

    String[] alias() default {};

}
