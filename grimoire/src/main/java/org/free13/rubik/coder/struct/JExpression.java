package org.free13.rubik.coder.struct;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public class JExpression implements RCode {

    private String name;
    private RCode[] factors;
    private JOperator operator;

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
