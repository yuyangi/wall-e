package org.free13.rubik.codable.storage;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public interface Storager {

    void store(String name, Object codable);

    Object getEntity(String name);

    Method getAction(String entityName, String actionName);

    Field getProperty(String entityName, String propName);

}
