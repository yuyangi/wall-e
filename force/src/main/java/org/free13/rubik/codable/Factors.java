package org.free13.rubik.codable;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Factors {

    private Method[] methods;

    private Field[] fields;

    public Factors(Method[] methods, Field[] fields) {
        this.methods = methods;
        this.fields = fields;
    }

    public Method getMethod(String name) {
        if (methods != null) {
            return Arrays.stream(methods).filter(method -> method.getName().equals(name)).findAny().orElse(null);
        }
        return null;
    }

    public Field getField(String name) {
        if (fields != null) {
            return Arrays.stream(fields).filter(method -> method.getName().equals(name)).findAny().orElse(null);
        }
        return null;
    }

    public Method[] getMethods() {
        return methods;
    }

    public void setMethods(Method[] methods) {
        this.methods = methods;
    }

    public Field[] getFields() {
        return fields;
    }

    public void setFields(Field[] fields) {
        this.fields = fields;
    }
}
