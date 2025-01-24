package org.free13.rubik;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;
import com.google.googlejavaformat.java.JavaFormatterOptions;
import org.free13.rubik.codable.Codability;
import org.free13.rubik.codable.java.*;
import org.free13.rubik.meta.RField;
import org.free13.rubik.meta.RFunction;

import java.lang.annotation.Annotation;
import java.util.*;

import static org.free13.rubik.codable.java.JDefine.Scope.PARAM;
import static org.free13.rubik.codable.java.JDefine.Scope.PROPERTY;

/**
 * 简单代码生成器
 * @author free13
 * Copyright (c) 2024 free13.
 */
public class LittleJavaCoder implements Codability {

    @Override
    public String programming(String requirement) {
        return "";
    }

    @Override
    public String format(String source) {
        JavaFormatterOptions options = JavaFormatterOptions.builder().style(JavaFormatterOptions.Style.GOOGLE).build();
        com.google.googlejavaformat.java.Formatter formatter = new Formatter(options);
        String output = null;
        try {
            output = formatter.formatSource(source);
        } catch (FormatterException e) {
            throw new RuntimeException(e);
        }
        return output;
    }

    public String entity(String packages, String name, String code, String comment, String propsDesc) {
        String[] propDesc = propsDesc.split("\n");
        JClass.Builder entityBuilder = JClass.builder()
                .modifiers(Collections.singletonList(JKeyword.PUBLIC))
                .className(code)
                .comment(comment);

        List<JDefine> properties = Lists.newArrayList();
        List<JMethod> methods = Lists.newArrayList();

        Set<JLine> imports = Sets.newHashSet();
        for (String propDescLine : propDesc) {
            String[] propAttrs = propDescLine.split(" ");
            String field = propAttrs[0];
            String desc = propAttrs[1];
            String type = propAttrs[2];
            properties.add(property(field, desc, type));
            methods.add(getter(field, desc, type));
            methods.add(setter(field, desc, type));
            imports.add(JLine.builder().factor(JKeyword.IMPORT_).factor(JConstant.of(type)).separator(JKeyword.SPACE.keyword()).factor(JKeyword.SEMICOLONS).build());
        }
        imports.add(JLine.builder().factor(JKeyword.IMPORT_).factor(JConstant.of(RField.class.getName())).factor(JKeyword.SEMICOLONS).separator(JKeyword.SPACE.keyword()).build());
        imports.add(JLine.builder().factor(JKeyword.IMPORT_).factor(JConstant.of(RFunction.class.getName())).factor(JKeyword.SEMICOLONS).separator(JKeyword.SPACE.keyword()).build());
        entityBuilder.properties(properties);
        entityBuilder.methods(methods);
        entityBuilder.imports(Lists.newArrayList(imports));
        entityBuilder.packages(JLine.builder().factor(JConstant.of(packages)).build()).build();
        return format(entityBuilder.build().toCode());
    }

    private JDefine property(String fieldName, String desc, String type) {
        JDefine.Builder propDefBuilder = JDefine.builder().type(type).name(fieldName);
        propDefBuilder.modifiers(Collections.singletonList(JKeyword.PRIVATE)).scope(PROPERTY);
        HashMap<String, String> fields = Maps.newHashMap();
        fields.put("name", fieldName);
        fields.put("desc", desc);
        fields.put("type", type);
        JLine.Builder annotationBuilder = getAnnotationBuilder(RField.class, fields);
        propDefBuilder.annotations(Collections.singletonList(annotationBuilder.build()));
        return propDefBuilder.build();
    }

    private JMethod getter(String fieldName, String desc, String type) {
        JMethod.Builder getterBuilder = JMethod.builder()
                .modifiers(Collections.singletonList(JKeyword.PUBLIC))
                .returnType(JConstant.of(type))
                .body(JBlock.builder().body(JLine.builder().factor(JKeyword.RETURN).factor(JKeyword.SPACE).factor(JConstant.of(fieldName)).factor(JKeyword.SEMICOLONS).build()).build())
                .methodName(JConstant.of("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1)));
        Map<String, String> fields = Maps.newHashMap();
        fields.put("name", fieldName);
        fields.put("desc", desc);
        JLine.Builder annotationBuilder = getAnnotationBuilder(RFunction.class, fields);
        return getterBuilder.annotations(Collections.singletonList(annotationBuilder.build())).build();
    }

    private static JLine.Builder getAnnotationBuilder(Class<? extends Annotation> annotation, Map<String, String> fields) {
        JLine.Builder builder = JLine.builder()
                .factor(JKeyword.AT)
                .factor(JConstant.of(annotation.getSimpleName()))
                .factor(JKeyword.LEFT_PARENTHESES);
        int count = 0;
        for (Map.Entry<String, String> entry : fields.entrySet()) {
            count++;
            builder.factor(JConstant.of(entry.getKey()))
                    .factor(JKeyword.ASSIGNMENT)
                    .factor(JKeyword.QUOTES)
                    .factor(JConstant.of(entry.getValue()))
                    .factor(JKeyword.QUOTES);
            if (count != fields.size()) {
                builder.factor(JKeyword.COMMA);
            }
        }
        builder.factor(JKeyword.RIGHT_PARENTHESES);
        return builder;
    }

    private JMethod setter(String fieldName, String desc, String type) {
        JMethod.Builder setterBuilder = JMethod.builder()
                .modifiers(Collections.singletonList(JKeyword.PUBLIC))
                .returnType(JConstant.of("void"))
                .parameters(Collections.singletonList(JDefine.builder().type(type).name(fieldName).build()))
                .body(JBlock.builder().body(JLine.builder().factor(JKeyword.THIS).factor(JKeyword.DOT).factor(JConstant.of(fieldName)).factor(JKeyword.ASSIGNMENT).factor(JConstant.of(fieldName)).factor(JKeyword.SEMICOLONS).build()).build())
                .methodName(JConstant.of("set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1)))
                .parameters(Collections.singletonList(JDefine.builder().type(type).name(fieldName).scope(PARAM).build()));
        Map<String, String> fields = Maps.newHashMap();
        fields.put("name", fieldName);
        fields.put("desc", desc);
        JLine.Builder annotationBuilder = getAnnotationBuilder(RFunction.class, fields);
        return setterBuilder.annotations(Collections.singletonList(annotationBuilder.build())).build();
    }

    public static void main(String[] args) {
        String desc = "id 编码 java.lang.Long\n" +
                "name 名称 java.lang.String\n" +
                "company 公司 java.lang.String\n" +
                "email 邮箱 java.lang.String\n" +
                "phone 电话 java.lang.String\n" +
                "source 来源 java.lang.String\n" +
                "status 状态 java.lang.String\n" +
                "createDate 创建日期 java.util.Date\n" +
                "updateDate 更新日期 java.util.Date\n" +
                "ownerId 负责人ID java.lang.Long\n" +
                "description 描述 java.lang.String\n" +
                "address 地址 java.lang.String\n" +
                "industry 行业 java.lang.String\n" +
                "revenue 收入 java.math.BigDecimal\n" +
                "employees 员工数 java.lang.Integer\n" +
                "rating 评级 java.lang.String\n" +
                "campaignId 活动ID java.lang.Long";
        LittleJavaCoder ljc = new LittleJavaCoder();
        System.out.println(ljc.entity("org.free13.rubik.demo", "Customer", "Customer", "客户", desc));
    }

}
