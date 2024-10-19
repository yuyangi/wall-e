package org.free13.rubik.codable.java;

import org.free13.rubik.codable.java.enums.CodeState;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public class JMultiLine extends AbsJCode {

    private List<JCode> lines;
    private String name;
    private String comment;

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
        return lines.stream().map(JCode::toCode).collect(Collectors.joining(JKeyword.WRAP.keyword()));
    }

    @Override
    public CodeState codeState() {
        return CodeState.FRAGMENT;
    }

    public List<JCode> getLines() {
        return lines;
    }

    public void setLines(List<JCode> lines) {
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
        private List<JCode> lines = new ArrayList<>();
        private String name;

        public Builder() {
        }

        public Builder content(JCode content) {
            this.lines.add(content);
            return this;
        }

        public Builder contents(List<JCode> contents) {
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
