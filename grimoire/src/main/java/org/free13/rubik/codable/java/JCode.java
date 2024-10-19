package org.free13.rubik.codable.java;

import org.free13.rubik.codable.java.enums.CodeState;

/*
 *
 * @author free13
 * Copyright (c) 2024.
 */
public interface JCode {

    String name();

    String simpleName();

    String toCode(String... params);

    CodeState codeState();

    JCode getParent();

    default String comment() {
        return null;
    }

}
