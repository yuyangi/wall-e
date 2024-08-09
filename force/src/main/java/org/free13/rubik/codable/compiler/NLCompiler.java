package org.free13.rubik.codable.compiler;

import net.openhft.compiler.CachedCompiler;
import net.openhft.compiler.CompilerUtils;
import org.free13.rubik.codable.Utils;

import java.io.File;

/**
 * @author yang
 * @date 2020/11/24
 * 自然语言编译成java代码
 */
public class NLCompiler implements Compiler {

    static final CachedCompiler JCC = CompilerUtils.DEBUGGING ?
            new CachedCompiler(new File("src/test/java"), new File("target/classes")) :
            CompilerUtils.CACHED_COMPILER;

    @Override
    public Class<?>[] compile(String name, String nl) {
        String className = Utils.toClassName(name);
        return new Class[]{compile2Class(className, nl)};
    }

    public String compile2Code(String nl) {
        return null;
    }

    public Class<?> compile2Class(String name, String sourceCode) {
        try {
            return JCC.loadFromJava(this.getClass().getClassLoader(), name, sourceCode);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Generate " + name + " code error, class not generate or cannot loaded.", e);
        }
    }

    public File compile2File(String sourceCode) {
        return null;
    }
}
