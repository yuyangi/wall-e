package show.me.the.code.compiler;

import net.openhft.compiler.CachedCompiler;
import net.openhft.compiler.CompilerUtils;

import java.io.File;

/**
 * @author yang
 * @date 2020/11/24
 * 自然语言编译成java代码
 */
public class NLCompiler implements Compiler {

    public static final NLCompiler INSTANCE = new NLCompiler();

    static final CachedCompiler JCC = CompilerUtils.DEBUGGING ?
            new CachedCompiler(new File("src/test/java"), new File("target/classes")) :
            CompilerUtils.CACHED_COMPILER;

    // 单例模式
    private NLCompiler() {

    }

    // 获取单例
    public static NLCompiler getInstance() {
        return INSTANCE;
    }

    @Override
    public String compile2Code(String nl) {
        return null;
    }

    @Override
    public Class<?> compile2Class(String sourceCode) {
        return null;
    }

    @Override
    public File compile2File(String sourceCode) {
        return null;
    }
}
