package org.free13.rubik.coder.struct.control;

import org.free13.rubik.coder.struct.*;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public class JIf implements RCode {

    private JStatement condition;
    private JStatement body;

    public JIf(JStatement condition, JStatement body) {
        this.condition = condition;
        this.body = body;
    }

    // builder模式
    public static class Builder {
        private JStatement condition;
        private JStatement body;

        public Builder condition(JStatement condition) {
            this.condition = condition;
            return this;
        }

        public Builder body(JStatement body) {
            this.body = body;
            return this;
        }

        public JIf build() {
            return new JIf(condition, body);
        }
    }

    // builder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String name() {
        return "if";
    }

    @Override
    public String simpleName() {
        return "if";
    }

    @Override
    public String toCode(String... params) {
        JMultiLine.Builder builder = JMultiLine.builder();
        builder.content(JLine.builder().factor(JKeyword.IF).factor(JKeyword.LEFT_PARENTHESES).factor(condition).factor(JKeyword.RIGHT_PARENTHESES).build());
        builder.content(JKeyword.LEFT_BRACKETS);
        builder.content(body);
        builder.content(JKeyword.RIGHT_BRACKETS);
        return builder.build().toCode();
    }

    @Override
    public CodeState codeState() {
        return CodeState.FRAGMENT;
    }
}