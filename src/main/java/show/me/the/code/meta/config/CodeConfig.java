package show.me.the.code.meta.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import show.me.the.code.meta.model.Entity;

@Configuration
@ComponentScan(basePackages = {"show.me.the.code.meta"}, includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Entity.class)
})
public class CodeConfig {
}
