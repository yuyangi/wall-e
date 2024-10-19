package org.free13.rubik;

import org.free13.rubik.codable.Codability;
import org.free13.rubik.compiler.Compiler;
import org.free13.rubik.executor.Executor;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public class Rubik implements Codability, Executor, Compiler {

    private Codability coder;
    private Executor executor;
    private Compiler compiler;

    @Override
    public String programming(String requirement) {
        return coder.programming(requirement);
    }

    @Override
    public Class<?>[] compile(String name, String source) {
        return compiler.compile(name, source);
    }

    @Override
    public void execute(String code) {
        executor.execute(code);
    }

    @Override
    public String format(String code) {
        return coder.format(code);
    }

    public Codability getCoder() {
        return coder;
    }

    public void setCoder(Codability coder) {
        this.coder = coder;
    }

    public Executor getExecutor() {
        return executor;
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    public Compiler getCompiler() {
        return compiler;
    }

    public void setCompiler(Compiler compiler) {
        this.compiler = compiler;
    }
}
