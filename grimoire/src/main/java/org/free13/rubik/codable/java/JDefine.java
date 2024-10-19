package org.free13.rubik.codable.java;

import org.free13.rubik.codable.java.enums.CodeState;
import org.free13.rubik.codable.java.enums.Operator;
import org.free13.rubik.meta.RFunction;

import java.util.List;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public class JDefine extends AbsJCode {

    private List<JCode> modifiers;
    private JCode type;
    private JCode name;
    private JCode operator;
    private JCode defaultValue;
    private Scope scope;
    public enum Scope {
        PARAM, VAR, PROPERTY
    }

    public JDefine() {

    }

    private JDefine(List<JCode> modifiers, JCode type, JCode name, JCode operator, JCode defaultValue, Scope scope) {
        this.modifiers = modifiers;
        this.type = type;
        this.name = name;
        this.defaultValue = defaultValue;
        this.scope = scope;
        this.operator = operator;
    }

    public static class Builder {
        private List<JCode> modifiers;
        private JCode type;
        private JCode name;
        private JCode defaultValue;
        private Scope scope;
        private JCode operator;

        public Builder modifiers(List<JCode> modifiers) {
            this.modifiers = modifiers;
            return this;
        }

        public Builder type(JCode type) {
            this.type = type;
            return this;
        }

        public Builder type(String type) {
            this.type = JConstant.of(type);
            return this;
        }

        public Builder name(String name) {
            this.name = JConstant.of(name);
            return this;
        }

        public Builder operator(JCode operator) {
            this.operator = operator;
            return this;
        }

        public Builder name(JCode name) {
            this.name = name;
            return this;
        }

        public Builder defaultValue(String defaultValue) {
            this.defaultValue = JConstant.of(defaultValue);
            return this;
        }

        public Builder defaultValue(JCode defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }

        public Builder scope(Scope scope) {
            this.scope = scope;
            return this;
        }

        public JDefine build() {
            return new JDefine(modifiers, type, name, operator, defaultValue, scope);
        }

    }

    @RFunction(name = " ")
    @Override
    public String toCode(String... params) {
        if (scope == Scope.PARAM) {
            return JLine.builder().factor(type).factor(name).build().toCode(params);
        } else if (scope == Scope.VAR) {
            JLine.Builder builder = JLine.builder().factor(type).factor(name);
            if (defaultValue != null) {
                builder.factor(Operator.ASSIGN).factor(defaultValue);
            }
            builder.factor(JKeyword.SEMICOLONS);
            return builder.build().toCode(params);
        } else if (scope == Scope.PROPERTY) {
            JLine.Builder builder = JLine.builder();
            if (modifiers != null) {
                builder.factors(modifiers);
            }
            builder.factor(type).factor(name);
            if (defaultValue != null) {
                builder.factor(Operator.ASSIGN).factor(defaultValue);
            }
            builder.factor(JKeyword.SEMICOLONS);
            return builder.build().toCode(params);
        }
        return "";
    }

    // builder模式
    public static JDefine.Builder builder() {
        return new JDefine.Builder();
    }

    @Override
    public CodeState codeState() {
        return CodeState.FRAGMENT;
    }

    @Override
    public String name() {
        return name.toCode();
    }

    @Override
    public String simpleName() {
        return name.toCode();
    }

    public List<JCode> getModifiers() {
        return modifiers;
    }

    public void setModifiers(List<JCode> modifiers) {
        this.modifiers = modifiers;
    }

    public JCode getType() {
        return type;
    }

    public void setType(JCode type) {
        this.type = type;
    }

    public JCode getName() {
        return name;
    }

    public void setName(JCode name) {
        this.name = name;
    }

    public JCode getOperator() {
        return operator;
    }

    public void setOperator(JCode operator) {
        this.operator = operator;
    }

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }
}
