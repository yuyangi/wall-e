package org.free13;

import org.free13.rubik.coder.NamingConverter;
import org.free13.rubik.coder.RSQL2JavaCoder;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }


    public static void nameConverter() {
        String underscoreName = "example_column_name";

        // 测试首字母小写的驼峰式命名
        String camelCaseName = NamingConverter.underscoreToCamelCase(underscoreName, false);
        System.out.println("Original: " + underscoreName);
        System.out.println("Converted (first letter lowercase): " + camelCaseName);

        // 测试首字母大写的驼峰式命名
        String pascalCaseName = NamingConverter.underscoreToCamelCase(underscoreName, true);
        System.out.println("Converted (first letter uppercase): " + pascalCaseName);
    }
}