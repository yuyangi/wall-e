package org.free13.rubik.codable.java;

import org.free13.rubik.codable.java.enums.CodeState;
import org.free13.rubik.codable.java.enums.CommentType;
import org.free13.rubik.utilities.NamingUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import static org.free13.rubik.codable.java.JKeyword.*;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public class JClass extends AbsJCode {

    private JLine packages;
    private List<JLine> imports;
    private List<JDefine> properties;
    private List<JMethod> methods;
    private List<JKeyword> modifiers;
    private JConstant className;
    private JComment comment;
    private List<JLine> annotations;

    private JClass(Builder builder) {
        this.packages = builder.packages;
        this.imports = builder.imports;
        this.properties = builder.properties;
        this.methods = builder.methods;
        this.modifiers = builder.modifiers;
        this.className = builder.className;
        this.comment = builder.comment;
        this.annotations = builder.annotations;
    }

    // builder模式
    public static class Builder {
        private JLine packages;
        private List<JLine> imports;
        private List<JDefine> properties;
        private List<JMethod> methods;
        private List<JKeyword> modifiers;
        private JConstant className;
        private JComment comment;
        private List<JLine> annotations;

        public Builder packages(JLine packages) {
            this.packages = packages;
            return this;
        }

        public Builder imports(List<JLine> imports) {
            this.imports = imports;
            return this;
        }

        public Builder imports(JLine imp) {
            if (this.imports == null) {
                imports = new ArrayList<>();
            }
            imports.add(imp);
            return this;
        }

        public Builder className(String className) {
            this.className = JConstant.of(className);
            return this;
        }

        public Builder comment(String comment) {
            this.comment = JComment.of(comment, CommentType.JAVADOC);
            return this;
        }

        public Builder properties(List<JDefine> properties) {
            this.properties = properties;
            return this;
        }

        public Builder property(JDefine property) {
            if (this.properties == null) {
                properties = new ArrayList<>();
            }
            properties.add(property);
            return this;
        }

        public Builder methods(List<JMethod> methods) {
            this.methods = methods;
            return this;
        }

        public Builder method(JMethod method) {
            if (this.methods == null) {
                this.methods = new ArrayList<>();
            }
            this.methods.add(method);
            return this;
        }

        public Builder modifiers(List<JKeyword> keywords) {
            this.modifiers = keywords;
            return this;
        }

        public Builder modifiers(String[] modifiers) {
            for (String modifier : modifiers) {
                modifier(modifier);
            }
            return this;
        }

        public Builder modifier(JKeyword modifier) {
            if (this.modifiers == null) {
                this.modifiers = new ArrayList<>();
            }
            modifiers.add(modifier);
            return this;
        }

        public Builder modifier(String modifier) {
            if (this.modifiers == null) {
                this.modifiers = new ArrayList<>();
            }
            JKeyword jKeyword = JKeyword.of(modifier);
            if (jKeyword != null) {
                modifiers.add(jKeyword);
            }
            return this;
        }

        public Builder annotations(List<JLine> annotations) {
            this.annotations = annotations;
            return this;
        }

        public JClass build() {
            return new JClass(this);
        }
    }

    public static Builder builder() {
        return new JClass.Builder();
    }

    public static JClass of(Class<?> clz) {
        Field[] fields = clz.getFields();
        Method[] methods = clz.getMethods();
        String packages = clz.getPackage().toString();
        int classModifiers = clz.getModifiers();
        List<JDefine> properties = new ArrayList<>();
        List<JMethod> methodList = new ArrayList<>();
        for (Field field : fields) {
            String modifiersStr = Modifier.toString(field.getModifiers());
            String[] modifiers = modifiersStr.split(" ");
            List<JCode> modifiersList = new ArrayList<>();
            for (String modifier : modifiers) {
                if (JKeyword.of(modifier) != null) {
                    modifiersList.add(JKeyword.of(modifier));
                }
            }
            JDefine def = JDefine.builder()
                    .name(field.getName())
                    .type(JConstant.of(field.getType().getSimpleName()))
                    .modifiers(modifiersList)
                    .scope(JDefine.Scope.PROPERTY)
                    .build();
            properties.add(def);
        }
        for (Method method : methods) {
            String modifiersStr = Modifier.toString(method.getModifiers());
            String[] modifiers = modifiersStr.split(" ");
            Class<?>[] parameterTypes = method.getParameterTypes();
            List<JDefine> parameters = new ArrayList<>();
            for (Class<?> parameterType : parameterTypes) {
                parameters.add(JDefine.builder()
                        .name(NamingUtils.toParamName(parameterType.getSimpleName()))
                        .type(parameterType.getSimpleName())
                        .scope(JDefine.Scope.PARAM)
                        .build());
            }
            JMethod methodDef = JMethod.builder()
                    .methodName(method.getName())
                    .returnType(method.getReturnType().getSimpleName())
                    .parameters(parameters)
                    .modifiers(modifiers)
                    .body(JBlock.builder().build())
                    .build();
            methodList.add(methodDef);
        }
        String clzModifiersStr = Modifier.toString(classModifiers);
        String[] clzModifiers = clzModifiersStr.split( " ");
        Builder classBuilder = builder()
                .modifiers(clzModifiers)
                .className(clz.getName())
                .properties(properties)
                .methods(methodList)
                .packages(JLine.builder().factor(JConstant.of(packages)).factor(SEMICOLONS).build());
        return classBuilder.build();
    }

    @Override
    public String toCode(String... params) {
        if (className == null) {
            throw new RuntimeException("对象名称不能为空！");
        }

        JMultiLine.Builder builder = JMultiLine.builder();
        if (packages != null) {
            builder.content(JLine.builder().separator(SPACE.keyword()).factor(JKeyword.PACKAGE_).factor(packages).factor(SEMICOLONS).build());
        }
        if (imports != null) {
            builder.contents(imports);
        }
        if (comment != null) {
            builder.content(comment);
        }
        JLine.Builder classDef = JLine.builder().separator(SPACE.keyword());
        if (modifiers != null) {
            builder.content(classDef.factors(modifiers).factor(CLASS).factor(className).build());
        }

        builder.content(LEFT_BRACKETS);

        if (properties != null) {
            builder.contents(properties);
        }
        if (methods != null) {
            builder.contents(methods);
        }
        builder.content(RIGHT_BRACKETS);
        return builder.build().toCode(params);
    }

    @Override
    public CodeState codeState() {
        return CodeState.COMPLETE;
    }

    @Override
    public String name() {
        return packages.name() + "." + className.simpleName();
    }

    @Override
    public String simpleName() {
        return className.simpleName();
    }

    public JLine getPackages() {
        return packages;
    }

    public void setPackages(JLine packages) {
        this.packages = packages;
    }

    public List<JLine> getImports() {
        return imports;
    }

    public void setImports(List<JLine> imports) {
        this.imports = imports;
    }

    public List<JDefine> getProperties() {
        return properties;
    }

    public void setProperties(List<JDefine> properties) {
        this.properties = properties;
    }

    public List<JMethod> getMethods() {
        return methods;
    }

    public void setMethods(List<JMethod> methods) {
        this.methods = methods;
    }

    public List<JKeyword> getModifiers() {
        return modifiers;
    }

    public void setModifiers(List<JKeyword> modifiers) {
        this.modifiers = modifiers;
    }

    public JConstant getClassName() {
        return className;
    }

    public void setClassName(JConstant className) {
        this.className = className;
    }

    public JComment getComment() {
        return comment;
    }

    public void setComment(JComment comment) {
        this.comment = comment;
    }
}
