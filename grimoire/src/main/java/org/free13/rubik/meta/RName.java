package org.free13.rubik.meta;

/*
 *
 * @author free13
 * Copyright (c) 2024.
 */
public @interface RName {

    String name();

    String comment() default "";

    String code() default "";

    String[] alias() default {};

}
