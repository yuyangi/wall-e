package org.free13.rubik.coder.struct;

import java.util.List;
import java.util.stream.Collectors;

import static org.free13.rubik.coder.struct.JKeyword.*;
import static org.free13.rubik.coder.struct.JType.INTEND;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public class JClass implements RCode {

    private RCode packages;
    private List<RCode> imports;
    private RCode body;
    private String className;
    private String comment;

    @Override
    public String toCode(String... params) {
        StringBuilder sb = new StringBuilder();
        if (packages != null) {
            sb.append(packages.toCode()).append(WRAP);
        }
        if (imports != null) {
            sb.append(imports.stream().map(RCode::toCode).collect(Collectors.joining(JKeyword.WRAP.getKeyword())));
        }
        // class begin
        if (body != null) {
            sb.append(INTEND).append(body.toCode()).append(WRAP);
        }
        // class end
        sb.append(RIGHT_BRACKETS);
        return sb.toString();
    }

    @Override
    public CodeState codeState() {
        return CodeState.COMPLETE;
    }

    @Override
    public String name() {
        return className;
    }

    @Override
    public String simpleName() {
        return packages.name() + "." + className;
    }
}
