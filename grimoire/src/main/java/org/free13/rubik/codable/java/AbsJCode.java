package org.free13.rubik.codable.java;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public abstract class AbsJCode implements JCode {

    private JCode parent;

    @Override
    public JCode getParent() {
        return parent;
    }

    public void setParent(JCode parent) {
        this.parent = parent;
    }
}
