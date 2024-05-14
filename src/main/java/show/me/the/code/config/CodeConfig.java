package show.me.the.code.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import show.me.the.code.codable.compiler.Compiler;
import show.me.the.code.codable.compiler.NLCompiler;
import show.me.the.code.codable.exec.Executor;
import show.me.the.code.codable.exec.NLExecutor;
import show.me.the.code.codable.storage.MemoryStorager;
import show.me.the.code.codable.storage.Storager;
import show.me.the.code.meta.model.Entity;

@Configuration
@ComponentScan(basePackages = {"show.me.the.code.meta"}, includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Entity.class)
})
public class CodeConfig {

    @Bean
    public Compiler compiler() {
        return new NLCompiler();
    }

    @Bean
    public Executor executor() {
        return new NLExecutor();
    }

    @Bean
    public Storager storager() {
        return new MemoryStorager();
    }
}
