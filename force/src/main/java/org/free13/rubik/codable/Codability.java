package org.free13.rubik.codable;

import org.free13.rubik.codable.compiler.Compiler;
import org.free13.rubik.codable.exec.Executor;
import org.free13.rubik.codable.storage.Storager;

public interface Codability {

    void init(Compiler compiler, Executor executor, Storager storager);

    void learn(String name, Object codable);

    void learn(Codable codable);

    void generate(String title, String requirement);

    String execute(String command);

    String[] document(int type);

    public static final int DOC_TYPE_STANDARD = 0;
    public static final int DOC_TYPE_NATURE = 1;
    public static final int DOC_TYPE_FORMAT = 2;
    public static final int DOC_TYPE_USER_DEFINE = -1;

}
