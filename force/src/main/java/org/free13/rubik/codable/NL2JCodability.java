package org.free13.rubik.codable;

import org.free13.rubik.codable.compiler.Compiler;
import org.free13.rubik.codable.exec.Executor;
import org.free13.rubik.codable.storage.Storager;

public class NL2JCodability implements Codability {

    private Compiler compiler;

    private Executor executor;

    private Storager storager;

    public NL2JCodability(Compiler compiler, Executor executor, Storager storager) {
        super();
        init(compiler, executor, storager);
    }

    @Override
    public void init(Compiler compiler, Executor executor, Storager storager) {
        this.compiler = compiler;
        this.executor = executor;
        this.storager = storager;
    }

    @Override
    public void learn(String name, Object codable) {
        if (storager == null) {
            throw new RuntimeException("[NL2JCodability] Codability storager is null !");
        }
        storager.store(name, codable);
    }

    @Override
    public void learn(Codable codable) {
        if (storager == null) {
            throw new RuntimeException("[NL2JCodability] Codability storager is null!");
        }
        storager.store(codable.name(), codable);
    }

    @Override
    public void generate(String title, String requirement) {
        if (compiler == null) {
            throw new RuntimeException("[NL2JCodability] Codability compiler is null!");
        }
        compiler.compile(title, requirement);
    }

    @Override
    public String execute(String command) {
        if (executor == null) {
            throw new RuntimeException("[NL2JCodability] Codability executor is null!");
        }
        return executor.execute(command);
    }

    // TODO 生产当前可用的对象功能文档
    @Override
    public String[] document(int docType) {

        return new String[0];
    }
}
