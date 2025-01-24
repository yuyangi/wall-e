package org.free13.rubik.codable.java;

import org.free13.rubik.codable.java.enums.CodeState;
import org.free13.rubik.codable.java.enums.Operator;
import org.free13.rubik.meta.RFunction;

import java.util.List;

import static org.free13.rubik.codable.java.JKeyword.SPACE;

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
    private List<JLine> annotations;
    public enum Scope {
        PARAM, VAR, PROPERTY
    }

    public JDefine() {

    }

    private JDefine(List<JCode> modifiers, JCode type, JCode name, JCode operator, JCode defaultValue, Scope scope, List<JLine> annotations) {
        this.modifiers = modifiers;
        this.type = type;
        this.name = name;
        this.defaultValue = defaultValue;
        this.scope = scope;
        this.operator = operator;
        this.annotations = annotations;
    }

    public static class Builder {
        private List<JCode> modifiers;
        private JCode type;
        private JCode name;
        private JCode defaultValue;
        private Scope scope;
        private JCode operator;
        private List<JLine> annotations;

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

        public Builder annotations(List<JLine> annotations) {
            this.annotations = annotations;
            return this;
        }

        public JDefine build() {
            return new JDefine(modifiers, type, name, operator, defaultValue, scope, annotations);
        }

    }

    @RFunction(name = " ")
    @Override
    public String toCode(String... params) {
        JLine.Builder builder = JLine.builder().separator(SPACE.keyword());
        if (scope == Scope.PARAM) {
            builder.factor(type).factor(name);
        } else if (scope == Scope.VAR) {
            builder.factor(type).factor(name);
            if (defaultValue != null) {
                builder.factor(Operator.ASSIGN).factor(defaultValue);
            }
            builder.factor(JKeyword.SEMICOLONS);
        } else if (scope == Scope.PROPERTY) {
            if (modifiers != null) {
                builder.factors(modifiers);
            }
            builder.factor(type).factor(name);
            if (defaultValue != null) {
                builder.factor(Operator.ASSIGN).factor(defaultValue);
            }
            builder.factor(JKeyword.SEMICOLONS);
        }
        if (annotations != null) {
            JMultiLine.Builder builder1 = JMultiLine.builder();
            for (JLine annotation : annotations) {
                builder1.content(annotation);
            }
            return builder1.content(builder.build()).build().toCode();
        }
        return builder.build().toCode();
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
