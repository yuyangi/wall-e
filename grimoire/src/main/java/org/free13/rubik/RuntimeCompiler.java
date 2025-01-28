package org.free13.rubik;

import net.openhft.compiler.CachedCompiler;
import net.openhft.compiler.CompilerUtils;
import org.free13.rubik.compiler.Compiler;
import org.free13.rubik.meta.RAction;
import org.free13.rubik.meta.RDesc;
import org.free13.rubik.utilities.NamingUtils;

import java.io.File;

/*
 *
 * @author free13
 * Copyright (c) 2024.
 */

/**
 * @author yang
 * @date 2020/11/24
 */
public class RuntimeCompiler implements Compiler {

    private String sourceDir;

    private String targetDir;

    private CachedCompiler compiler;

    // 单例模式
    private static final RuntimeCompiler INSTANCE = new RuntimeCompiler();
    private RuntimeCompiler() {
    }

    public static RuntimeCompiler getInstance() {
        return INSTANCE;
    }

    private CachedCompiler getCompiler() {
        if (compiler == null) {
            compiler = CompilerUtils.DEBUGGING ? new CachedCompiler(new File(sourceDir), new File(targetDir)) : CompilerUtils.CACHED_COMPILER;
        }
        return compiler;
    }

    @RAction(name = "编译java代码")
    @Override
    public Class<?>[] compile(String name, String sourceCode) {
        String className = NamingUtils.toClassName(name);
        return new Class[]{compile2Class(className, sourceCode)};
    }

    public Class<?> compile2Class(String className, String sourceCode) {
        try {
            @RDesc("加载java class")
            Class<?> aClass = getCompiler().loadFromJava(this.getClass().getClassLoader(), className, sourceCode);
            return aClass;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Generate " + className + " code error, class not generate or cannot loaded.", e);
        }
    }

}
