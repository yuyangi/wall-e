package org.free13.rubik.coder.struct;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public interface RCode {

    String name();

    String simpleName();

    String toCode(String... params);

    CodeState codeState();

}
