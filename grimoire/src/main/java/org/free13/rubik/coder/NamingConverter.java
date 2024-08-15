package org.free13.rubik.coder;

/**
 * @author free13 Copyright (c) 2024.
 */
public class NamingConverter {

    /**
     * 将下划线命名的字符串转换为驼峰式命名。
     *
     * @param underscoreName        下划线命名的字符串。
     * @param capitalizeFirstLetter 是否将首字母大写。
     * @return 转换后的驼峰式命名字符串。
     */
    public static String underscoreToCamelCase(String underscoreName, boolean capitalizeFirstLetter) {
        StringBuilder camelCaseName = new StringBuilder();
        boolean nextUpperCase = false;

        for (char c : underscoreName.toCharArray()) {
            if (c == '_') {
                nextUpperCase = true;
            } else {
                if (nextUpperCase) {
                    camelCaseName.append(Character.toUpperCase(c));
                    nextUpperCase = false;
                } else {
                    // 如果capitalizeFirstLetter为true且是第一个字符，则转换为大写
                    camelCaseName.append(camelCaseName.length() == 0 && capitalizeFirstLetter
                            ? Character.toUpperCase(c)
                            : Character.toLowerCase(c));
                }
            }
        }
        return camelCaseName.toString();
    }

    public static String capitalize(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }
}