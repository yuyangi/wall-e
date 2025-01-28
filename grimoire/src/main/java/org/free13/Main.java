package org.free13;

import org.free13.rubik.LittleJavaCoder;
import org.free13.rubik.RuntimeCompiler;
import org.free13.rubik.codable.CodaResult;
import org.free13.rubik.codable.Codability;
import org.free13.rubik.compiler.Compiler;
import org.free13.rubik.llm.LLMAdapter;
import org.free13.rubik.llm.TongyiAdapter;
import org.free13.rubik.utilities.NamingUtils;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        LLMAdapter llm =  new TongyiAdapter("sk-082cc38b3aee4ca3922e8a0e5d0da995", "qwen-plus", "你是一个经验符丰富的架构师，你将帮助用户实现各种管理系统的设计和实现。你只需要输出用户想要的信息，不用输出多余的内容，例如我说输出字段和字段类型，那就输出一行文字，包含字段，类型并用空格隔开，其他的什么都不输出。");
        Codability coder = new LittleJavaCoder();
        Compiler compiler = RuntimeCompiler.getInstance();
        String answer = llm.answer("设计一个crm的线索对象，包含字段英文编码，中文名称，数据类型；生成数据类型时增加java对象的全路径类名");

        CodaResult customer = coder.programming("org.free13.rubik.demo", "Customer", answer);
        System.out.println("-----------------------------------------------------");
        System.out.println(customer.getSource());
        System.out.println("-----------------------------------------------------");
        compiler.compile("org.free13.rubik.demo.Customer", customer.getSource());
    }


    public static void nameConverter() {
        String underscoreName = "example_column_name";

        // 测试首字母小写的驼峰式命名
        String camelCaseName = NamingUtils.underscoreToCamelCase(underscoreName, false);
        System.out.println("Original: " + underscoreName);
        System.out.println("Converted (first letter lowercase): " + camelCaseName);

        // 测试首字母大写的驼峰式命名
        String pascalCaseName = NamingUtils.underscoreToCamelCase(underscoreName, true);
        System.out.println("Converted (first letter uppercase): " + pascalCaseName);
    }


    public static String convertToFraction(String decimalStr) {
        // 移除任何前导或尾随空格
        decimalStr = decimalStr.trim();

        // 检查是否包含负号
        boolean isNegative = false;
        if (decimalStr.startsWith("-")) {
            isNegative = true;
            decimalStr = decimalStr.substring(1);
        }

        // 分割整数部分和小数部分
        String[] parts = decimalStr.split("\\.");
        BigInteger integerPart = new BigInteger(parts[0]);
        BigInteger fractionalPart = new BigInteger(parts.length > 1 ? parts[1] : "0");

        // 如果没有小数部分，则直接返回整数
        if (fractionalPart.equals(BigInteger.ZERO)) {
            return formatResult(integerPart, BigInteger.ONE, isNegative);
        }

        // 计算小数部分的长度
        int n = fractionalPart.toString().length();
        BigInteger numerator = fractionalPart.add(integerPart.multiply(BigInteger.TEN.pow(n)));
        BigInteger denominator = BigInteger.TEN.pow(n);

        // 约分
        BigInteger gcd = numerator.gcd(denominator);
        numerator = numerator.divide(gcd);
        denominator = denominator.divide(gcd);

        // 返回结果
        return formatResult(numerator, denominator, isNegative);
    }

    private static String formatResult(BigInteger numerator, BigInteger denominator, boolean isNegative) {
        if (isNegative) {
            numerator = numerator.negate();
        }
        return "(" + numerator + ", " + denominator + ")";
    }

}