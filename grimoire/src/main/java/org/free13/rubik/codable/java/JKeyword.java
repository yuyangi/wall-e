package org.free13.rubik.codable.java;

import org.free13.rubik.codable.java.enums.CodeState;
import org.free13.rubik.meta.RField;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public enum JKeyword implements JCode {
    // 用于定义数据类型的关键字
    @RField(name = "类", alias = {"对象","东西"}, type = "class")
    CLASS("class"),
    @RField(name = "接口", alias = {"规则","标准"}, type = "interface")
    INTERFACE("interface"),
    @RField(name = "枚举", alias = {"选项","选择"}, type = "enum")
    ENUM("enum"),
    @RField(name = "字节", alias = {"位","位元"}, type = "byte")
    BYTE("byte"),
    @RField(name = "短整型", alias = {"整数"}, type = "short")
    SHORT("short"),
    @RField(name = "整型", alias = {"整数", "数", "数字"}, type = "int")
    INT("int"),
    @RField(name = "长整型", alias = {"整数", "数", "数字"}, type = "long")
    LONG("long"),
    @RField(name = "浮点型", alias = {"小数"}, type = "float")
    FLOAT("float"),
    @RField(name = "双精度", alias = {"小数"}, type = "double")
    DOUBLE("double"),
    @RField(name = "字符", alias = {"字符", "字", "字元"}, type = "char")
    CHAR("char"),
    @RField(name = "布尔", alias = {"真假"}, type = "boolean")
    BOOLEAN("boolean"),
    @RField(name = "空", alias = {"无", "无返回值"}, type = "enum")
    VOID("void"),

    // 用于定义流程控制的关键字
    @RField(name = "如果", alias = {"假如", "要是"}, type = "grammar")
    IF("if"),
    @RField(name = "否则", alias = {"否则如果", "如果"}, type = "grammar")
//    ELSEIF("else if"), 不原子
//    @RField(name = "否则", alias = {"不是"}, type = "grammar")
    ELSE("else"),
    @RField(name = "如果", alias = {"选择"}, type = "grammar")
    SWITCH("switch"),
    @RField(name = "当", alias = {"如果"}, type = "grammar")
    CASE("case"),
    @RField(name = "默认", type = "grammar")
    DEFAULT("default"),
    @RField(name = "循环", type = "grammar")
    WHILE("while"),
    @RField(name = "执行", type = "grammar")
    DO("do"),
    @RField(name = "循环", type = "grammar")
    FOR("for"),
    @RField(name = "跳出", alias = {"停止", "跳过"}, type = "grammar")
    BREAK("break"),
    @RField(name = "继续", type = "grammar")
    CONTINUE("continue"),
    @RField(name = "返回", type = "grammar")
    RETURN("return"),

    @RField(name = "私有", type = "grammar")
    // 用于定义访问权限修饰符的关键字
    PRIVATE("private"),
    @RField(name = "受保护", type = "grammar")
    PROTECTED("protected"),
    @RField(name = "公共", type = "grammar")
    PUBLIC("public"),

    // 用于定义类、函数、变量修饰符的关键字
    @RField(name = "抽象", type = "grammar")
    ABSTRACT("abstract"),
    @RField(name = "最终", alias = {"终态"}, type = "grammar")
    FINAL("final"),
    @RField(name = "静态", type = "grammar")
    STATIC("static"),
    @RField(name = "同步", type = "grammar")
    SYNCHRONIZED("synchronized"),

    // 用于定义类与类之间关系的关键字
    @RField(name = "继承" , type = "grammar")
    EXTENDS("extends"),
    @RField(name = "实现" , type = "grammar")
    IMPLEMENTS("implements"),

    // 用于定义建立实例及引用实例、判断实例的关键字
    @RField(name = "新建", alias = {"实例化", "创建", "初始化"}, type = "grammar")
    NEW_("new"),
    @RField(name = "当前", alias = {"本地", "自有"}, type = "grammar")
    THIS("this"),
    @RField(name = "父类", type = "grammar")
    SUPER("super"),
    @RField(name = "类型", alias = {"类型是", "类型等于"}, type = "grammar")
    INSTANCEOF("instanceof"),

    // 用于异常处理的关键字
    @RField(name = "尝试", alias = {"谨慎执行"}, type = "grammar")
    TRY_("try"),
    @RField(name = "捕获", type = "grammar")
    CATCH_("catch"),
    @RField(name = "最终", type = "grammar")
    FINALLY_("finally"),
    @RField(name = "抛出", type = "grammar")
    THROW_("throw"),
    @RField(name = "抛出", type = "grammar")
    THROWS_("throws"),

    // 用于包的关键字
    @RField(name = "包", type = "grammar")
    PACKAGE_("package"),
    @RField(name = "导入", alias = {"引入", "依赖"}, type = "grammar")
    IMPORT_("import"),

    // 其他修饰符关键字
    @RField(name = "本地", alias = {"系统"}, type = "grammar")
    NATIVE_("native"),
    @RField(name = "默认", type = "grammar")
    STRICTFP_("strictfp"),
    @RField(name = "透明的", alias = {"透明", "非序列化", "不序列化"}, type = "grammar")
    TRANSIENT_("transient"),
    @RField(name = "不稳定的", alias = {"最新的"}, type = "grammar")
    VOLATILE_("volatile"),
    @RField(name = "断言", type = "grammar")
    ASSERT_("assert"),

    // 用于定义数据类型值的字面值
    @RField(name = "真", alias = {"是"}, type = "grammar")
    TRUE_("true"),
    @RField(name = "假", alias = {"否"}, type = "grammar")
    FALSE_("false"),
    @RField(name = "空", alias = {"无"}, type = "grammar")
    NULL_("null"),

    // 用于定义运算符的关键字
    @RField(name = "加", type = "grammar")
    PLUS("+"),
    @RField(name = "减", type = "grammar")
    MINUS("-"),
    @RField(name = "乘", type = "grammar")
    MULTIPLY("*"),
    @RField(name = "除", type = "grammar")
    DIVIDE("/"),
    @RField(name = "取余", alias = {"模"}, type = "grammar")
    MODULO("%"),
    @RField(name = "左移", type = "grammar")
    LEFT_SHIFT("<<"),
    @RField(name = "右移", type = "grammar")
    RIGHT_SHIFT(">>"),
    @RField(name = "无符号右移", type = "grammar")
    UNSIGNED_RIGHT_SHIFT(">>>"),
    @RField(name = "与", type = "grammar")
    BITWISE_AND("&"),
    @RField(name = "或", type = "grammar")
    BITWISE_OR("|"),
    @RField(name = "异或", type = "grammar")
    BITWISE_XOR("^"),
    @RField(name = "取反", type = "grammar")
    BITWISE_COMPLEMENT("~"),
    @RField(name = "赋值", type = "grammar")
    ASSIGNMENT("="),

    // 用于定义逻辑运算符的关键字
    @RField(name = "与", type = "grammar")
    AND("&&"),
    @RField(name = "或", type = "grammar")
    OR("||"),
    @RField(name = "非", type = "grammar")
    NOT("!"),

    // 用于定义关系运算符的关键字
    @RField(name = "等于", type = "grammar")
    EQUAL("=="),
    @RField(name = "不等于", type = "grammar")
    NOT_EQUAL("!="),
    @RField(name = "大于", type = "grammar")
    GREATER_THAN(">"),
    @RField(name = "小于", type = "grammar")
    LESS_THAN("<"),
    @RField(name = "大于等于", type = "grammar")
    GREATER_THAN_OR_EQUAL(">="),
    @RField(name = "小于等于", type = "grammar")
    LESS_THAN_OR_EQUAL("<="),

    // 用于做范围或结束的符号
    @RField(name = "左大括号", type = "grammar")
    LEFT_BRACKETS("{"),
    @RField(name = "右大括号", type = "grammar")
    RIGHT_BRACKETS("}"),
    @RField(name = "左括号", type = "grammar")
    LEFT_PARENTHESES("("),
    @RField(name = "右括号", type = "grammar")
    RIGHT_PARENTHESES(")"),
    @RField(name = "左中括号", type = "grammar")
    LEFT_SQUARE_BRACKETS("["),
    @RField(name = "右中括号", type = "grammar")
    RIGHT_SQUARE_BRACKETS("]"),
    @RField(name = "左尖括号", type = "grammar")
    LEFT_ANGLE_BRACKETS("<"),
    @RField(name = "右尖括号", type = "grammar")
    RIGHT_ANGLE_BRACKETS(">"),
    @RField(name = "分号", alias = {"结束", "结束符"}, type = "grammar")
    SEMICOLONS(";"),
    @RField(name = "冒号", type = "grammar")
    COLON(":"),
    @RField(name = "逗号", type = "grammar")
    COMMA(","),
    @RField(name = "点", type = "grammar")
    DOT("."),
    // 单引号
    @RField(name = "单引号", type = "grammar")
    SINGLE_QUOTES("'"),
    // 双引号
    @RField(name = "双引号", type = "grammar")
    QUOTES("\""),
    @RField(name = "空格", type = "grammar")
    SPACE(" "),
    @RField(name = "缩进", type = "grammar")
    INDENT("    "),
    @RField(name = "换行", type = "grammar")
    WRAP("\n"),
    @RField(name = "注释行", alias = {"注释"}, type = "grammar")
    COMMENT_LINE("//"),
    @RField(name = "注释块开始", type = "grammar")
    COMMENT_BLOCK_START("/*"),
    @RField(name = "注释块结束", type = "grammar")
    COMMENT_BLOCK_END("*/"),
    @RField(name = "注释块行", type = "grammar")
    COMMENT_BLOCK_LINE(" *"),
    @RField(name = "JavaDoc注释块开始", type = "grammar")
    COMMENT_JAVADOC_START("/**"),
    @RField(name = "JavaDoc注释块结束", type = "grammar")
    COMMENT_JAVADOC_END(" */"),

    // 特殊符号
    @RField(name = "下划线", type = "grammar")
    UNDERSCORE("_"),
    @RField(name = "@", alias = {"@符号", "at符号"}, type = "grammar")
    AT("@"),
    @RField(name = "$", alias = {"dollar符号"}, type = "grammar")
    DOLLAR("$"),
    @RField(name = "#", alias = {"hash符号"}, type = "grammar")
    HASH("#"),
    @RField(name = "&", alias = {"and符号"}, type = "grammar")
    AMPERSAND("&"),
    @RField(name = "*", alias = {"star符号", "星号"}, type = "grammar")
    ASTERISK("*"),
    @RField(name = "\\", alias = {"反斜杠"}, type = "grammar")
    BACKSLASH("\\"),
    @RField(name = "^", alias = {"插入符号"}, type = "grammar")
    CARET("^"),
    @RField(name = "~", alias = {"tilde符号"}, type = "grammar")
    TILDE("~"),
    @RField(name = "`", alias = {"反引号"}, type = "grammar")
    BACKQUOTE("`")
    ;

    private final String keyword;

    JKeyword(String keyword) {
        this.keyword = keyword;
    }

    public static JKeyword of(String keyword) {
        for (JKeyword value : JKeyword.values()) {
            if (value.name().equals(keyword)) {
                return value;
            }
        }
        return null;
    }

    public String keyword() {
        return keyword;
    }

    @Override
    public String toString() {
        return keyword;
    }

    @Override
    public String simpleName() {
        return keyword;
    }

    @Override
    public String toCode(String... params) {
        return keyword();
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