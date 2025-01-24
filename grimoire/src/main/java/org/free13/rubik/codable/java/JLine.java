package org.free13.rubik.codable.java;

import org.free13.rubik.codable.java.enums.CodeState;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public class JLine extends AbsJCode {

    private List<JCode> factors;
    private String name;
    private String separator = "";

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
        private String separator = "";

        public Builder factors(List<? extends JCode> factors) {
            if (factors == null) {
                return this;
            }
            if (this.factors == null) {
                this.factors = new ArrayList<>();
            }
            this.factors.addAll(factors);
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

        public Builder separator(String separator) {
            this.separator = separator;
            return this;
        }

        public JLine build() {
            return new JLine(this);
        }
    }

    private JLine(Builder builder) {
        this.factors = builder.factors;
        this.name = builder.name;
        this.separator = builder.separator;
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
        return factors.stream().map(JCode::toCode).collect(Collectors.joining(separator));
    }

    @Override
    public CodeState codeState() {
        return CodeState.FRAGMENT;
    }

    public List<JCode> getFactors() {
        return factors;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass())  {
            return false;
        }
        JLine jLine = (JLine) object;
        return Objects.equals(factors, jLine.factors) && Objects.equals(name, jLine.name) && Objects.equals(separator, jLine.separator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(factors, name, separator);
    }
}
