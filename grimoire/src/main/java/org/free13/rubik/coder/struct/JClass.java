package org.free13.rubik.coder.struct;

import java.util.List;

import static org.free13.rubik.coder.struct.JKeyword.*;
import static org.free13.rubik.coder.struct.JType.INTEND;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public class JClass implements JCode {

    private JCode packages;
    private List<JCode> imports;
    private List<JCode> defines;
    private List<JCode> methods;
    private String className;
    private String comment;
    private String modifier = PUBLIC.getKeyword();

    @Override
    public String toCode() {
        StringBuffer sb = new StringBuffer();
        if (packages != null) {
            sb.append(packages.toCode()).append("\n");
            sb.append("\n");
        }
        if (imports != null) {
            for (JCode jCode : imports) {
                sb.append(jCode.toCode()).append("\n");
            }
            sb.append("\n");
        }
        // class begin
        sb.append(modifier).append(SPACE).append(CLASS).append(SPACE).append(className).append(SPACE).append(LEFT_BRACKETS).append(WRAP);

        if (defines != null) {
            for (JCode jCode : defines) {
                sb.append(INTEND).append(jCode.toCode()).append("\n");
            }
            sb.append("\n");
        }
        if (methods != null) {
            for (JCode jCode : methods) {
                sb.append(INTEND).append(jCode.toCode()).append("\n");
            }
        }
        // class end
        sb.append(RIGHT_BRACKETS);
        return "";
    }
}
