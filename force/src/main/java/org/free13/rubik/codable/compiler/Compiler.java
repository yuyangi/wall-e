package org.free13.rubik.codable.compiler;

import java.io.File;

public interface Compiler {

    /**
     * Compiles the given source code and returns an executable object.
     *
     * @param nl the source code to be compiled
     * @return java source code
     */
    Class<?>[] compile(String name, String nl);

}
