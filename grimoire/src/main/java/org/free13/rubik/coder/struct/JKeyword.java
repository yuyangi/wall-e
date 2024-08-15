package org.free13.rubik.coder.struct;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public enum JKeyword implements JCode {
    // 用于定义数据类型的关键字
    CLASS("class"), INTERFACE("interface"), ENUM("enum"), BYTE("byte"), SHORT("short"), INT("int"), LONG("long"), FLOAT("float"), DOUBLE("double"), CHAR("char"), BOOLEAN("boolean"), VOID("void"),

    // 用于定义流程控制的关键字
    IF("if"), ELSEIF("else if"),ELSE("else"), SWITCH("switch"), CASE("case"), DEFAULT("default"), WHILE("while"), DO("do"), FOR("for"), BREAK("break"), CONTINUE("continue"), RETURN("return"),

    // 用于定义访问权限修饰符的关键字
    PRIVATE("private"), PROTECTED("protected"), PUBLIC("public"),

    // 用于定义类、函数、变量修饰符的关键字
    ABSTRACT("abstract"), FINAL("final"), STATIC("static"), SYNCHRONIZED("synchronized"),

    // 用于定义类与类之间关系的关键字
    EXTENDS("extends"), IMPLEMENTS("implements"),

    // 用于定义建立实例及引用实例、判断实例的关键字
    NEW_("new"), THIS("this"), SUPER("super"), INSTANCEOF("instanceof"),

    // 用于异常处理的关键字
    TRY_("try"), CATCH_("catch"), FINALLY_("finally"), THROW_("throw"), THROWS_("throws"),

    // 用于包的关键字
    PACKAGE_("package"), IMPORT_("import"),

    // 其他修饰符关键字
    NATIVE_("native"), STRICTFP_("strictfp"), TRANSIENT_("transient"), VOLATILE_("volatile"), ASSERT_("assert"),

    // 用于定义数据类型值的字面值
    TRUE_("true"), FALSE_("false"), NULL_("null"),

    // 用于定义运算符的关键字
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/"), MODULO("%"),

    // 用于定义逻辑运算符的关键字
    AND("&&"), OR("||"), NOT("!"),

    // 用于定义关系运算符的关键字
    EQUAL("=="), NOT_EQUAL("!="), GREATER_THAN(">"), LESS_THAN("<"), GREATER_THAN_OR_EQUAL(">="), LESS_THAN_OR_EQUAL("<="),

    // 用于做范围或结束的符号
    LEFT_BRACKETS("{"),
    RIGHT_BRACKETS("}"),
    LEFT_PARENTHESES("("),
    RIGHT_PARENTHESES(")"),
    LEFT_SQUARE_BRACKETS("["),
    RIGHT_SQUARE_BRACKETS("]"),
    LEFT_ANGLE_BRACKETS("<"),
    RIGHT_ANGLE_BRACKETS(">"),
    SEMICOLONS(";"),
    SPACE(" "),
    INDENT("    "),
    WRAP("\n");

    private final String keyword;

    JKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    @Override
    public String toString() {
        return keyword;
    }

    @Override
    public String toCode() {
        return getKeyword();
    }
}