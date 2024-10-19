package org.free13.rubik.codable.java;

import org.free13.rubik.codable.java.enums.CodeState;
import org.free13.rubik.codable.java.enums.Operator;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public class JExpression extends AbsJCode {

    private String name;
    private JCode[] factors;
    private Operator operator;

    @Override
    public String name() {
        return name;
    }

    @Override
    public String simpleName() {
        return name;
    }

    @Override
    public String toCode(String... params) {
        return "";
    }

    @Override
    public CodeState codeState() {
        return CodeState.HALF_COMPLETED;
    }
}
