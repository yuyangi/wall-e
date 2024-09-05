package org.free13.rubik.coder.struct;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public class JMultiLine implements RCode {

    private List<RCode> lines;
    private String name;

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
        return lines.stream().map(RCode::toCode).collect(Collectors.joining(JKeyword.WRAP.getKeyword()));
    }

    @Override
    public CodeState codeState() {
        return CodeState.FRAGMENT;
    }

    public List<RCode> getLines() {
        return lines;
    }

    public void setLines(List<RCode> lines) {
        this.lines = lines;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // builder模式
    public static class Builder {
        private List<RCode> lines = new ArrayList<>();
        private String name;

        public Builder() {
        }

        public Builder content(RCode content) {
            this.lines.add(content);
            return this;
        }

        public Builder contents(List<RCode> contents) {
            this.lines.addAll(contents);
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public JMultiLine build() {
            JMultiLine jMultiLine = new JMultiLine();
            jMultiLine.setLines(lines);
            jMultiLine.setName(name);
            return jMultiLine;
        }
    }

    public static JMultiLine.Builder builder() {
        return new Builder();
    }
}
