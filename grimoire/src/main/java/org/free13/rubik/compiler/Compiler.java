package org.free13.rubik.compiler;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public interface Compiler {

    /**
     * 把源码编译成class对象
     *
     * @param source the source code to be compiled
     * @return java class
     */
    Class<?>[] compile(String name, String source);

}
