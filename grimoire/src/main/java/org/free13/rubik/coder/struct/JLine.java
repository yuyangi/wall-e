package org.free13.rubik.coder.struct;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public class JLine implements RCode {

    private List<RCode> factors;
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
        private List<RCode> factors = new ArrayList<>();
        private String name;

        public Builder factors(List<RCode> factors) {
            this.factors.addAll(factors);
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder factor(RCode factor) {
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

    public static Builder builder() {
        return new Builder();
    }

    public static JLine of(List<RCode> factors) {
        return JLine.builder().factors(factors).build();
    }

    @Override
    public String toCode(String... params) {
        return factors.stream().map(RCode::toCode).collect(Collectors.joining(JKeyword.SPACE.getKeyword()));
    }

    @Override
    public CodeState codeState() {
        return CodeState.FRAGMENT;
    }

    public List<RCode> getFactors() {
        return factors;
    }
}
