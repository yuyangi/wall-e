package show.me.the.code.compiler;

import java.io.File;

public interface Compiler {

    /**
     * Compiles the given source code and returns an executable object.
     *
     * @param nl the source code to be compiled
     * @return java source code
     */
    default Class<?> compile(String nl) {
        return compile2Class(compile2Code(nl));
    }

    String compile2Code(String nl);

    Class<?> compile2Class(String sourceCode);

    File compile2File(String sourceCode);

}
