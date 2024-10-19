package org.free13;

import org.free13.rubik.utilities.NamingUtils;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        // 测试
        System.out.println(convertToFraction("0.5"));  // 应输出 (1, 2)
        System.out.println(convertToFraction("2.25")); // 应输出 (9, 4)
        System.out.println(convertToFraction("-0.75"));// 应输出 (-3, 4)
        System.out.println(convertToFraction("3.14159265358979323846"));
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