package org.free13.rubik.codable.java;


import org.free13.rubik.codable.java.enums.CodeState;

import java.util.Objects;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public class JConstant extends AbsJCode {

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
        return CodeState.FRAGMENT;
    }

    public static JConstant of(String value) {
        return new JConstant(value);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        JConstant jConstant = (JConstant) object;
        return Objects.equals(value, jConstant.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
