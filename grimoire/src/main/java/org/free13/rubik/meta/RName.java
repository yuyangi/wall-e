package org.free13.rubik.meta;

import java.lang.annotation.*;

/**
 * @author free13
 * Copyright (c) 2024.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface RName {

    String name() default "";

    String comment() default "";

    String code() default "";

    String[] alias() default {};

}
