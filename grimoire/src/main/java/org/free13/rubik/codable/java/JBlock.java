package org.free13.rubik.codable.java;

import org.free13.rubik.codable.java.enums.CodeState;
import org.free13.rubik.codable.java.enums.CommentType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public class JBlock extends AbsJCode {

    private List<JCode> modifiers;
    private JCode condition;
    private JCode body;
    private String name;
    private String comments;

    public JBlock() {
    }

    // builder设计模式
    public static class Builder {
        private JCode body;
        private List<JCode> modifiers;
        private JCode condition;
        private String name;
        private String comments;

        // build
        public JBlock build() {
            return new JBlock(this);
        }

        public Builder body(JCode body) {
            this.body = body;
            return this;
        }

        public Builder condition(JCode condition) {
            this.condition = condition;
            return this;
        }

        public Builder comments(String comments) {
            this.comments = comments;
            return this;
        }

        public Builder modifiers(List<JCode> modifiers) {
            this.modifiers = modifiers;
            return this;
        }

        public Builder modifier(JCode modifier) {
            if (this.modifiers == null) {
                this.modifiers = new ArrayList<>();
            }
            this.modifiers.add(modifier);
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }
    }

    private JBlock(Builder builder) {
        this.body = builder.body;
        this.modifiers = builder.modifiers;
        this.name = builder.name;
        this.condition = builder.condition;
        this.comments = builder.comments;
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
        if (comments != null) {
            builder.content(JComment.of(comments, CommentType.LINE));
        }
        if (modifiers != null) {
            builder.contents(modifiers);
        }
        if (condition != null) {
            builder.content(condition);
        }
        if (body != null) {
            builder.content(JKeyword.LEFT_BRACKETS);
            builder.content(body);
            builder.content(JKeyword.RIGHT_BRACKETS);
        } else {
            builder.content(JKeyword.LEFT_BRACKETS);
            builder.content(JKeyword.RIGHT_BRACKETS);
        }
        return builder.build().toCode(params);
    }

    @Override
    public CodeState codeState() {
        return CodeState.FRAGMENT;
    }

    public List<JCode> getModifiers() {
        return modifiers;
    }

    public void setModifiers(List<JCode> modifiers) {
        this.modifiers = modifiers;
    }

    public JCode getCondition() {
        return condition;
    }

    public void setCondition(JCode condition) {
        this.condition = condition;
    }

    public JCode getBody() {
        return body;
    }

    public void setBody(JCode body) {
        this.body = body;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
