package org.free13.rubik.coder.struct;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public class JFlowControl implements RCode {

    // 用于定义流程控制的关键字：if、else、switch、case、default、while、do、for、break、continue、return
    public enum Control {
        IF(JKeyword.IF),
        ELSE(JKeyword.ELSE),
        SWITCH(JKeyword.SWITCH),
        CASE(JKeyword.CASE),
        DEFAULT(JKeyword.DEFAULT),
        WHILE(JKeyword.WHILE),
        DO(JKeyword.DO),
        FOR(JKeyword.FOR),
        BREAK(JKeyword.BREAK),
        CONTINUE(JKeyword.CONTINUE),
        RETURN(JKeyword.RETURN);

        private JKeyword keyword;

        private Control(JKeyword keyword) {
            this.keyword = keyword;
        }
    }

    private Control control;

    private JFlowControl(Control control) {
        this.control = control;
    }

    @Override
    public String toCode(String... params) {
        // 基于control的枚举值，生成switch代码
        if (control != null) {
            switch (control) {
                case SWITCH:
                case CASE:
                case DEFAULT:
                case IF:

                case ELSE:
                case WHILE:
                case DO:
                case FOR:
                case BREAK:
                case CONTINUE:
                case RETURN:
                    return "";
                default:
                    // 如果有其他未知的控制类型，这里可以添加额外的处理逻辑
                    throw new IllegalArgumentException("Unsupported control type: " + control);
            }
        }
        return "";
    }

    @Override
    public CodeState codeState() {
        return CodeState.FRAGMENT;
    }

    @Override
    public String name() {
        return control.keyword.simpleName();
    }

    @Override
    public String simpleName() {
        return control.keyword.simpleName();
    }
}
