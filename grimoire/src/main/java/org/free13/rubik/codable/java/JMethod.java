package org.free13.rubik.codable.java;

import org.free13.rubik.codable.java.enums.CodeState;
import org.free13.rubik.codable.java.enums.CommentType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author free13 Copyright (c) 2024.
 */
public class JMethod extends AbsJCode {

    private List<JConstant> modifiers;

    private JConstant methodName;

    private JConstant returnType;

    private List<JDefine> parameters;

    private JComment comment;

    private JBlock body;

    // builder模式
    public static class Builder {
        private JConstant methodName;
        private JConstant returnType;
        private List<JDefine> parameters;
        private JComment comment;
        private JBlock body;
        private List<JConstant> modifiers;

        public Builder modifiers(List<JConstant> modifiers) {
            this.modifiers = modifiers;
            return this;
        }

        public Builder modifier(JConstant modifier) {
            this.modifiers.add(modifier);
            return this;
        }

        public Builder modifiers(String[] modifiers) {
            this.modifiers = Arrays.stream(modifiers).map(JConstant::of).collect(Collectors.toList());
            return this;
        }

        public Builder methodName(String methodName) {
            this.methodName = JConstant.of(methodName);
            return this;
        }

        public Builder methodName(JConstant methodName) {
            this.methodName = methodName;
            return this;
        }

        public Builder returnType(String returnType) {
            this.returnType = JConstant.of(returnType);
            return this;
        }

        public Builder returnType(JConstant returnType) {
            this.returnType = returnType;
            return this;
        }

        public Builder parameters(List<JDefine> parameters) {
            this.parameters = parameters;
            return this;
        }

        public Builder comment(String comment) {
            this.comment = JComment.of(comment, CommentType.BLOCK);
            return this;
        }

        public Builder body(JBlock body) {
            this.body = body;
            return this;
        }

        public JMethod build() {
            return new JMethod(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private JMethod(Builder builder) {
        this.methodName = builder.methodName;
        this.returnType = builder.returnType;
        this.parameters = builder.parameters;
        this.comment = builder.comment;
        this.body = builder.body;
        this.modifiers = builder.modifiers;
    }

    @Override
    public String name() {
        return methodName.toCode();
    }

    @Override
    public String simpleName() {
        return methodName.toCode();
    }

    @Override
    public String toCode(String... params) {
        return "";
    }

    @Override
    public CodeState codeState() {
        return null;
    }

    @Override
    public String comment() {
        return comment.toCode();
    }

    public JConstant getMethodName() {
        return methodName;
    }

    public void setMethodName(JConstant methodName) {
        this.methodName = methodName;
    }

    public List<JDefine> getParameters() {
        return parameters;
    }

    public void setParameters(List<JDefine> parameters) {
        this.parameters = parameters;
    }

    public JComment getComment() {
        return comment;
    }

    public void setComment(JComment comment) {
        this.comment = comment;
    }

    public JBlock getBody() {
        return body;
    }

    public void setBody(JBlock body) {
        this.body = body;
    }

    public List<JConstant> getModifiers() {
        return modifiers;
    }

    public void setModifiers(List<JConstant> modifiers) {
        this.modifiers = modifiers;
    }

    public JConstant getReturnType() {
        return returnType;
    }

    public void setReturnType(JConstant returnType) {
        this.returnType = returnType;
    }
}
