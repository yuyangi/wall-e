package org.free13.rubik.codable.java;

import org.free13.rubik.codable.java.enums.CodeState;

/**
 * @author free13 Copyright (c) 2024.
 */
public class JStatement extends AbsJCode {

    private String name;

    private String code;

    public JStatement(String code) {
        this.code = code;
    }

    public static JStatement of(String code) {
        return new JStatement(code);
    }


    @Override
    public String name() {
        return name;
    }

    @Override
    public String simpleName() {
        return "";
    }

    @Override
    public String toCode(String... params) {
        return code;
    }

    @Override
    public CodeState codeState() {
        return CodeState.FRAGMENT;
    }

    @Override
    public String comment() {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
