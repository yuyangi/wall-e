package org.free13.rubik.codable.java;

import java.util.List;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public class JCodeUtils {



    public String toCode(List<JCode> codes) {
        StringBuilder sb = new StringBuilder();
        if (codes != null) {
            for (JCode code : codes) {
                if (code != null) {
                    sb.append(code.toCode());
                }
            }
        }
        return sb.toString();
    }

}
