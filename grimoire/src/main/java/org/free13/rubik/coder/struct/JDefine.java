package org.free13.rubik.coder.struct;

import java.util.List;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public class JDefine implements RCode {

    private List<RCode> modifiers;
    private RCode type;
    private String name;
    private String defaultValue;

    private Type defType;
    public enum Type {
        PARAM, VAR, PROPERTY
    }

    @Override
    public String toCode(String... params) {
        if (defType == Type.PARAM) {
            return JLine.builder().factor(type).factor(JConstant.of(name)).build().toCode(params);
        } else if (defType == Type.VAR) {
            JLine.Builder builder = JLine.builder().factor(type).factor(JConstant.of(name));
            if (defaultValue != null) {
                builder.factor(JOperator.ASSIGN).factor(JConstant.of(defaultValue));
            }
            builder.factor(JKeyword.SEMICOLONS);
            return builder.build().toCode(params);
        } else if (defType == Type.PROPERTY) {
            JLine.Builder builder = JLine.builder();
            if (modifiers != null) {
                builder.factors(modifiers);
            }
            builder.factor(type).factor(JConstant.of(name));
            if (defaultValue != null) {
                builder.factor(JOperator.ASSIGN).factor(JConstant.of(defaultValue));
            }
            builder.factor(JKeyword.SEMICOLONS);
            return builder.build().toCode(params);
        }
        return "";
    }

    @Override
    public CodeState codeState() {
        return CodeState.FRAGMENT;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String simpleName() {
        return name;
    }
}
