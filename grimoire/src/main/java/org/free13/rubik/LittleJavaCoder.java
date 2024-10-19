package org.free13.rubik;

import org.free13.rubik.codable.Codability;
import org.free13.rubik.codable.java.*;
import org.free13.rubik.meta.RField;

/*
 *
 * @author free13
 * Copyright (c) 2024.
 */
public class LittleJavaCoder implements Codability {

    @Override
    public String programming(String requirement) {
        return "";
    }

    @Override
    public String format(String source) {
        return "";
    }

    private String entity(String propsDesc) {
        String[] propDesc = propsDesc.split("\n");
        for (String propDescLine : propDesc) {
            String[] propAttrs = propDescLine.split(" ");
            String field = propAttrs[0];
            String desc = propAttrs[1];
            String type = propAttrs[2];

        }
        return null;
    }

    private JCode property(String fieldName, String desc, String type) {
        JLine.Builder propDefBuilder = JLine.builder().factor(JKeyword.PRIVATE).factor(JStatement.of(type)).factor(JConstant.of(fieldName)).factor(JKeyword.SEMICOLONS);
        JLine.Builder annotationBuilder = JLine.builder()
                .factor(JKeyword.AT)
                .factor(JConstant.of(RField.class.getSimpleName()))
                .factor(JConstant.of("name"))
                .factor(JKeyword.ASSIGNMENT)
                .factor(JConstant.of(desc))
                .factor(JKeyword.COMMA)
                .factor(JConstant.of("type"))
                .factor(JKeyword.ASSIGNMENT)
                .factor(JConstant.of(type));
    }
}
