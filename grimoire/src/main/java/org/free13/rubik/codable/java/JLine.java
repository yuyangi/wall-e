package org.free13.rubik.codable.java;

import org.free13.rubik.codable.java.enums.CodeState;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public class JLine extends AbsJCode {

    private List<JCode> factors;
    private String name;

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public String simpleName() {
        return this.name;
    }

    public static class Builder {
        private List<JCode> factors = new ArrayList<>();
        private String name;

        public Builder factors(List<JCode> factors) {
            if (this.factors != null) {
                this.factors.addAll(factors);
            } else {
                this.factors = factors;
            }
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder factor(JCode factor) {
            this.factors.add(factor);
            return this;
        }

        public JLine build() {
            return new JLine(this);
        }
    }

    private JLine(Builder builder) {
        this.factors = builder.factors;
        this.name = builder.name;
    }

    public JLine() {

    }

    public static Builder builder() {
        return new Builder();
    }

    public static JLine of(List<JCode> factors) {
        return JLine.builder().factors(factors).build();
    }

    public static JLine of(String line) {
        String[] factors = line.split("[+\\-*=/:; .]");
        Builder builder = JLine.builder();
        for (String factor : factors) {
            builder.factor(JConstant.of(factor));
        }
        return builder.build();
    }

    @Override
    public String toCode(String... params) {
        return factors.stream().map(JCode::toCode).collect(Collectors.joining(JKeyword.SPACE.keyword()));
    }

    @Override
    public CodeState codeState() {
        return CodeState.FRAGMENT;
    }

    public List<JCode> getFactors() {
        return factors;
    }
}
