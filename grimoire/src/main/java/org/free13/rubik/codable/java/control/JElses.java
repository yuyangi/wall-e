package org.free13.rubik.codable.java.control;

import org.free13.rubik.codable.java.AbsJCode;
import org.free13.rubik.codable.java.enums.CodeState;
import org.free13.rubik.codable.java.JKeyword;
import org.free13.rubik.codable.java.JStatement;

import java.util.List;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public class JElses extends AbsJCode {
    private JIf first;
    private List<JIf> elseIfs;
    private JStatement elseBody;

    // 生成该类未实现的方法
    private JElses() {
    }

    @Override
    public String name() {
        return String.join(JKeyword.SPACE.keyword(), JKeyword.ELSE.keyword(), JKeyword.IF.keyword());
    }

    @Override
    public String simpleName() {
        return JKeyword.ELSE.keyword();
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
