package show.me.the.code.codable;

import org.springframework.stereotype.Component;
import show.me.the.code.codable.compiler.Compiler;
import show.me.the.code.codable.exec.Executor;
import show.me.the.code.codable.storage.Storager;

@Component
public class NL2JCodability implements Codability {

    private Compiler compiler;

    private Executor executor;

    private Storager storager;

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
