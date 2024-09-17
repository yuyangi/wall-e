package org.free13.rubik.coder.struct.control;

import org.free13.rubik.coder.struct.CodeState;
import org.free13.rubik.coder.struct.JStatement;
import org.free13.rubik.coder.struct.RCode;

import java.util.List;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public class JElses implements RCode {
    private JIf first;
    private List<JIf> elseIfs;
    private JStatement elseBody;

    // 生成该类未实现的方法
    private JElses() {
    }

    @Override
    public String name() {
        return "else if";
    }

    @Override
    public String simpleName() {
        return "else";
    }

    @Override
    public String toCode(String... params) {
        return "";
    }

    @Override
    public CodeState codeState() {
        return CodeState.FRAGMENT;
    }
}
