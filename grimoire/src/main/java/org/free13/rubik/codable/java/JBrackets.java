package org.free13.rubik.codable.java;

import java.util.List;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public class JBrackets extends JLine {

    public static JLine of(List<JCode> factors) {
        return JLine.builder().factor(JKeyword.LEFT_PARENTHESES).factors(factors).factor(JKeyword.RIGHT_PARENTHESES).build();
    }
}
