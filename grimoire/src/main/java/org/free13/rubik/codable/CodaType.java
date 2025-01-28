package org.free13.rubik.codable;

/**
 *
 * @author free13
 * Copyright (c) 2025.
 */
public enum CodaType {

    Service("服务", "业务逻辑处理对象"),
    Entity("实体", "数据对象"),
    Code("代码", "代码片段"),
    Logic("逻辑", "业务逻辑代码"),
    Script("脚本", "脚本代码"),
    Test("测试", "测试代码"),
    ;
    private String name;
    private String desc;

    CodaType(String name, String desc) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }

    public static CodaType getByName(String name) {
        for (CodaType type : values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        return null;
    }
}
