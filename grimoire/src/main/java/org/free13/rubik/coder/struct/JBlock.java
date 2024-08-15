package org.free13.rubik.coder.struct;

import java.util.List;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public class JBlock implements JCode {

    private List<JCode> modifiers;
    private JCode left;
    private JCode right;
    private List<JCode> contents;

    // builder设计模式
    public static class Builder {
        private JCode left;
        private JCode right;
        private List<JCode> contents;
        private List<JCode> modifiers;

        public Builder left(JCode left) {
            this.left = left;
            return this;
        }

        public Builder right(JCode right) {
            this.right = right;
            return this;
        }

        public Builder contents(List<JCode> contents) {
            this.contents = contents;
            return this;
        }
        // build
        public JBlock build() {
            return new JBlock(this);
        }
        public Builder modifiers(List<JCode> modifiers) {
            this.modifiers = modifiers;
            return this;
        }
    }

    private JBlock(Builder builder) {
        this.left = builder.left;
        this.right = builder.right;
        this.contents = builder.contents;
        this.modifiers = builder.modifiers;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toCode() {
        if (contents != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(left.toCode()).append(JKeyword.WRAP.getKeyword());
            for (JCode code : contents) {
                sb.append(code.toCode());
            }
            sb.append(JKeyword.WRAP.getKeyword()).append(right.toCode());
            return sb.toString();
        }
        return "";
    }
}
