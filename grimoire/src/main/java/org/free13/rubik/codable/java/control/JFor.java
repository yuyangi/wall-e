package org.free13.rubik.codable.java.control;

import com.google.common.collect.Lists;
import org.free13.rubik.codable.java.JBlock;
import org.free13.rubik.codable.java.JDefine;
import org.free13.rubik.codable.java.JKeyword;
import org.free13.rubik.codable.java.JCode;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public class JFor extends JBlock {

    public enum Form {
        for_each,
        for_i,
        stream
    }

    private Form form;

    private JDefine source;

    private JCode body;

    public JFor(Form form, JDefine source, JCode body) {
        this.form = form;
        this.source = source;
        this.body = body;

        JCode type = analysisType(source);
        JDefine condition = JDefine.builder().type(type).name(genTempVarName(type)).operator(JKeyword.COLON).defaultValue(source).build();
        this.setModifiers(Lists.newArrayList(JKeyword.FOR));
        this.setCondition(condition);
        this.setBody(body);
    }

    private JCode analysisType(JDefine variable) {
        return variable.getType();
    }

    private String genTempVarName(JCode type) {
        String simpleName = type.simpleName();
        simpleName = tempVar(simpleName);
        return simpleName;
    }

    private static String tempVar(String simpleName) {
        char first = simpleName.charAt(0);
        if (Character.isUpperCase(first)) {
            char lowerCase = Character.toLowerCase(first);
            simpleName = lowerCase + simpleName.substring(1);
        }
        return simpleName;
    }

    public static void main(String[] args) {

    }

}
