package show.me.the.code.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import show.me.the.code.codable.Codability;
import show.me.the.code.meta.model.Entity;

@Configuration
@Component
public class CodableScanner implements BeanPostProcessor {

    @Autowired
    private Codability codability;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Entity annotation = AnnotationUtils.getAnnotation(bean.getClass(), Entity.class);
        if (annotation != null) {
            codability.learn(annotation.name(), bean);
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

}
