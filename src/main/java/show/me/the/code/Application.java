package show.me.the.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import show.me.the.code.meta.config.CodeConfig;
import show.me.the.code.meta.model.Entity;

import java.util.Map;

@SpringBootApplication
@PropertySource(value = {"classpath:application.properties"})
public class Application {

	public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
		testConfig();
	}

	private static void testConfig() {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(CodeConfig.class);
		Map<String, Object> beansWithAnnotation = context.getBeansWithAnnotation(Entity.class);
		for (String beanDefinitionName : beansWithAnnotation.keySet()) {
			Object bean = context.getBean(beanDefinitionName);
			System.out.println(beanDefinitionName + "->"+ beansWithAnnotation.get(beanDefinitionName).getClass().getSimpleName());
		}
	}

}
