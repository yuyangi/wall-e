package org.free13.rubik.coder.struct;

import org.free13.rubik.meta.RFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public class JBlock implements RCode {

    private List<RCode> modifiers;
    private List<RCode> contents;
    private String name;

    static {
        System.out.println("aaa");
    }

    public JBlock() {
    }

    // builder设计模式
    public static class Builder {
        private List<RCode> contents;
        private List<RCode> modifiers;
        private String name;

        public Builder contents(List<RCode> contents) {
            this.contents = contents;
            return this;
        }
        // build
        public JBlock build() {
            return new JBlock(this);
        }

        public Builder modifiers(List<RCode> modifiers) {
            this.modifiers = modifiers;
            return this;
        }

        @RFunction()
        public Builder modifier(RCode modifier) {
            if (this.modifiers == null) {
                this.modifiers = new ArrayList<>();
            }
            this.modifiers.add(modifier);
            return this;
        }

        public Builder content(RCode content) {
            if (this.contents == null) {
                this.contents = new ArrayList<>();
            }
            this.contents.add(content);
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }
    }

    private JBlock(Builder builder) {
        this.contents = builder.contents;
        this.modifiers = builder.modifiers;
        this.name = builder.name;
    }

    public static JBlock.Builder builder() {
        return new JBlock.Builder();
    }

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
        JMultiLine.Builder builder = JMultiLine.builder();
        if (modifiers != null) {
            builder.contents(modifiers);
        }
        if (contents != null) {
            builder.content(JKeyword.LEFT_BRACKETS);
            builder.contents(contents);
            builder.content(JKeyword.RIGHT_BRACKETS);
        }
        return builder.build().toCode(params);
    }

    @Override
    public CodeState codeState() {
        return CodeState.FRAGMENT;
    }

}
