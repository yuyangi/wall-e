package org.free13.rubik.meta.data;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author free13
 */
public class RDataFieldHandler {

    public static List<RDataField> fieldExtractor(Class<?> clazz) throws NoSuchFieldException, IllegalAccessException {
        Field[] fields = clazz.getDeclaredFields();
        return Arrays.stream(fields).filter(field -> field.isAnnotationPresent(RDataField.class))
                .map(field -> field.getAnnotation(RDataField.class)).collect(Collectors.toList());
    }

}
