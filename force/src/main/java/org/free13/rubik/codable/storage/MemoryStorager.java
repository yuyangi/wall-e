package org.free13.rubik.codable.storage;

import com.google.common.collect.Sets;
import org.free13.rubik.codable.Factors;
import org.free13.rubik.meta.model.Action;
import org.free13.rubik.meta.model.Entity;

import javax.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryStorager implements Storager {

    private final Map<String, Object> codified = new ConcurrentHashMap<>();

    private final Map<String, Factors> factors = new ConcurrentHashMap<>();

    private final Map<String, Set<String>> actions = new ConcurrentHashMap<>();

    @Override
    public void store(String name, Object codable) {
        registerCodified(name, codable);
    }

    @Override
    public Object getEntity(String name) {
        if (name == null) {
            return null;
        }
        return codified.get(name);
    }

    @Override
    public Field getProperty(String entityName, String propName) {
        if (propName == null) {
            return null;
        }
        if (entityName != null) {
            Factors entiFactors = factors.get(entityName);
            if (entiFactors != null && entiFactors.getMethods() != null) {
                return Arrays.stream(entiFactors.getFields()).filter(f -> f.getName().equals(propName)).findAny().orElse(null);
            }
        }
        return null;
    }

    public void registerCodified(String name, Object codable) {
        codified.put(name, codable);
        Method[] methods = codable.getClass().getDeclaredMethods();
        Field[] fields = codable.getClass().getDeclaredFields();
        Entity entity = codable.getClass().getAnnotation(Entity.class);
        if (entity == null) {
            return;
        }
        codified.put(entity.name(), codable);
        factors.put(entity.name(), new Factors(methods, fields));
        Arrays.stream(methods).forEach(m -> {
            Action action = m.getAnnotation(Action.class);
            if (action != null) {
                Set<String> parts = actions.get(action.name());
                if (parts == null){
                    parts = Sets.newHashSet();
                }
                parts.add(entity.name());
            }
        });
    }

    public Object getCodified(String name) {
        return codified.get(name);
    }

    @Nullable
    @Override
    public Method getAction(String entityName, String actionName) {
        if (actionName == null) {
            return null;
        }
        if (entityName != null) {
            Factors entiFactors = factors.get(entityName);
            if (entiFactors != null && entiFactors.getMethods() != null) {
                return Arrays.stream(entiFactors.getMethods()).filter(f -> f.getName().equals(actionName)).findAny().orElse(null);
            }
        }
        return null;
    }

}
