package org.free13.rubik.codable.java.enums;

/**
 * 大模型供应商类型
 * @author free13
 * Copyright (c) 2024.
 */
public enum LLMModelSource {

    TongYi("通义千问"),
    WenXin("文心一言"),
    Kimi("Kimi"),
    ;

    LLMModelSource(String name) {
    }

    private String name;

    public String getName() {
        return name;
    }
}
