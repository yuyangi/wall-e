package org.free13.rubik.codable.java.enums;

import org.free13.rubik.codable.java.JCode;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public enum Operator implements JCode {
    // 算术运算
    ADD("+", 2, "{0} + {1}"),
    SUBTRACT("-", 2, "{0} - {1}"),
    MULTIPLY("*", 2, "{0} * {1}"),
    DIVIDE("/", 2, "{0} / {1}"),
    REMAINDER("%", 2, "{0} % {1}"),

    // 赋值运算
    ASSIGN("=", 2, "{0} = {1}"),
    ADD_ASSIGN("+=", 2, "{0} += {1}"),
    SUBTRACT_ASSIGN("-=", 2, "{0} -= {1}"),
    MULTIPLY_ASSIGN("*=", 2, "{0} *= {1}"),
    DIVIDE_ASSIGN("/=", 2, "{0} /= {1}"),
    REMAINDER_ASSIGN("%=", 2, "{0} %= {1}"),

    // 比较运算
    EQUALS("==", 2, "{0} == {1}"),
    NOT_EQUALS("!=", 2, "{0} != {1}"),
    GREATER_THAN(">", 2, "{0} > {1}"),
    LESS_THAN("<", 2, "{0} < {1}"),
    GREATER_THAN_OR_EQUAL(">=", 2, "{0} >= {1}"),
    LESS_THAN_OR_EQUAL("<=", 2, "{0} <= {1}"),

    // 逻辑运算
    LOGICAL_AND("&&", 2, "{0} && {1}"),
    LOGICAL_OR("||", 2, "{0} || {1}"),
    LOGICAL_NOT("!", 1, "!{0}"),

    // 位运算
    BITWISE_AND("&", 2, "{0} & {1}"),
    BITWISE_OR("|", 2, "{0} | {1}"),
    BITWISE_XOR("^", 2, "{0} ^ {1}"),
    LEFT_SHIFT("<<", 2, "{0} << {1}"),
    RIGHT_SHIFT(">>", 2, "{0} >> {1}"),
    UNSIGNED_RIGHT_SHIFT(">>>", 2, "{0} >>> {1}"),

    // 条件运算 (三元运算符)
    CONDITIONAL("?", 3, "{0} ? {1} : {2}"),

    // 实例运算
    INSTANCEOF("instanceof", 2, "{0} instanceof {1}"),

    // 空合并运算 (Java 9 开始支持)
    NULL_COALESCING("??", 2, "{0} ?? {1}"),

    // 特殊运算符
    NEW_("new", 1, "new {0}()"),
    DOT(".", 2, "{0}.{1}"),
    ARRAY_ACCESS("[]", 2, "{0}[{1}]"),
    // TODO 设计一下格式 体现参数的数量
    METHOD_INVOCATION("()", 1, "{0}()"),

    // 逗号运算符???
    //COMMA(",", 2),

    // 增量和减量运算符
    PREFIX_INCREMENT("++", 1, "++{0}"),
    PREFIX_DECREMENT("--", 1, "--{0}"),
    POSTFIX_INCREMENT("++", 1, "{0}++"),
    POSTFIX_DECREMENT("--", 1, "{0}--"),

    // 显式类型转换
    TYPE_CAST("(type)", 2, "({0}){1}");

    private final String symbol;
    private final int operandCount;
    private final String format;

    Operator(String symbol, int operandCount, String format) {
        this.symbol = symbol;
        this.operandCount = operandCount;
        this.format = format;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getOperandCount() {
        return operandCount;
    }

    public String getFormat() {
        return format;
    }

    public String format(Object[] params) {
        return String.format(this.getFormat(), params);
    }

    @Override
    public String simpleName() {
        return symbol;
    }

    @Override
    public String toCode(String... params) {
        if (params != null && params.length > 0) {
            return format(params);
        }
        return symbol;
    }

    @Override
    public CodeState codeState() {
        return CodeState.FRAGMENT;
    }

    @Override
    public JCode getParent() {
        return null;
    }


}