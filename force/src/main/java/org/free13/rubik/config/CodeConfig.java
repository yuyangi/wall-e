package org.free13.rubik.config;

import org.springframework.context.annotation.*;
import org.free13.rubik.codable.Codability;
import org.free13.rubik.codable.NL2JCodability;
import org.free13.rubik.codable.compiler.Compiler;
import org.free13.rubik.codable.compiler.NLCompiler;
import org.free13.rubik.codable.exec.Executor;
import org.free13.rubik.codable.exec.NLExecutor;
import org.free13.rubik.codable.storage.MemoryStorager;
import org.free13.rubik.codable.storage.Storager;
import org.free13.rubik.meta.model.Entity;
import org.free13.rubik.nlp.AnsjSegmentor;
import org.free13.rubik.nlp.Segmentor;

@Configuration
@ComponentScan(includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Entity.class)
})
public class CodeConfig {

    @Bean
    public Compiler compiler() {
        return new NLCompiler();
    }

    @Bean
    public Executor executor() {
        return new NLExecutor(segmentor(), storager());
    }

    @Bean
    public Segmentor segmentor() {
        return new AnsjSegmentor();
    }

    @Bean
    public Storager storager() {
        return new MemoryStorager();
    }

    @Bean
    public Codability codability() {
        return new NL2JCodability(compiler(), executor(), storager());
    }
}
