package org.free13.rubik.coder.struct;


/**
 * @author free13
 * Copyright (c) 2024.
 */
public class JConstant implements RCode {

    private String value;

    public JConstant(String value) {
        this.value = value;
    }

    @Override
    public String name() {
        return value;
    }

    @Override
    public String simpleName() {
        return value;
    }

    @Override
    public String toCode(String... params) {
        return value;
    }

    @Override
    public CodeState codeState() {
        return null;
    }

    public static JConstant of(String value) {
        return new JConstant(value);
    }
}
