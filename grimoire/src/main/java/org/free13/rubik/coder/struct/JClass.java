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
        JMultiLine.Builder builder = JMultiLine.builder();
        if (packages != null) {
            builder.content(packages).content(WRAP);
        }
        if (imports != null) {
            builder.contents(imports);
            imports.forEach(imp -> builder.content(imp).content(WRAP));
        }
        // class begin
        if (body != null) {
            builder.content(INDENT);
            builder.content(body);
            builder.content(WRAP);
        }
        return builder.build().toCode(params);
    }

    @Override
    public CodeState codeState() {
        return CodeState.COMPLETE;
    }

    @Override
    public String name() {
        return packages.name() + "." + className;
    }

    @Override
    public String simpleName() {
        return className;
    }
}
