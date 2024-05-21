package show.me.the.code.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.*;
import show.me.the.code.codable.Codability;
import show.me.the.code.codable.NL2JCodability;
import show.me.the.code.codable.compiler.Compiler;
import show.me.the.code.codable.compiler.NLCompiler;
import show.me.the.code.codable.exec.Executor;
import show.me.the.code.codable.exec.NLExecutor;
import show.me.the.code.codable.storage.MemoryStorager;
import show.me.the.code.codable.storage.Storager;
import show.me.the.code.meta.model.Entity;
import show.me.the.code.nlp.AnsjSegmentor;
import show.me.the.code.nlp.Segmentor;

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
