package org.free13.rubik.coder.struct;

/**
 * @author free13 Copyright (c) 2024.
 */
public enum JOperator {
    // 算术运算符
    ADDITION("+", 2), SUBTRACTION("-", 2), MULTIPLICATION("*", 2), DIVISION("/", 2), MODULUS("%", 2),

    // 比较运算符
    EQUALS("==", 2), NOT_EQUALS("!=", 2), LESS_THAN("<", 2), GREATER_THAN(">", 2), LESS_THAN_OR_EQUAL("<=", 2),
    GREATER_THAN_OR_EQUAL(">=", 2),

    // 逻辑运算符
    LOGICAL_AND("&&", 2), LOGICAL_OR("||", 2), LOGICAL_NOT("!", 1),

    // 位运算符
    BITWISE_COMPLEMENT("~", 1), BITWISE_AND("&", 2), BITWISE_OR("|", 2), BITWISE_XOR("^", 2), LEFT_SHIFT("<<", 2),
    SIGNED_RIGHT_SHIFT(">>", 2), UNSIGNED_RIGHT_SHIFT(">>>", 2),

    // 赋值运算符
    ASSIGNMENT("=", 2), ADD_ASSIGN("+=", 2), SUBTRACT_ASSIGN("-=", 2), MULTIPLY_ASSIGN("*=", 2), DIVIDE_ASSIGN("/=", 2),
    REMAINDER_ASSIGN("%=", 2), BITWISE_AND_ASSIGN("&=", 2), BITWISE_OR_ASSIGN("|=", 2), BITWISE_XOR_ASSIGN("^=", 2),
    LEFT_SHIFT_ASSIGN("<<=", 2), SIGNED_RIGHT_SHIFT_ASSIGN(">>=", 2), UNSIGNED_RIGHT_SHIFT_ASSIGN(">>>=", 2),

    // 条件运算符
    TERNARY_CONDITIONAL("? :", 3),

    // 特殊运算符
    INSTANCEOF("instanceof", 2), NEW_("new", 1), // "new" 关键字后面可以跟多个参数，但在这里我们假设至少一个操作数（类型）
    DOT(".", 2), ARRAY_ACCESS("[]", 2), METHOD_INVOCATION("()", 1), // 方法调用至少需要一个操作数（方法名），但可以有任意数量的参数

    // 逗号运算符
    COMMA(",", 2),

    // 增量和减量运算符
    PREFIX_INCREMENT("++", 1), PREFIX_DECREMENT("--", 1), POSTFIX_INCREMENT("++", 1), POSTFIX_DECREMENT("--", 1),

    // 显式类型转换
    TYPE_CAST("(type)", 1);

    private final String symbol;
    private final int operandCount;

    JOperator(String symbol, int operandCount) {
        this.symbol = symbol;
        this.operandCount = operandCount;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getOperandCount() {
        return operandCount;
    }
}