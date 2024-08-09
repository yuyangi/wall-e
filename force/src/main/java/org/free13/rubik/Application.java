package org.free13.rubik;

import org.free13.rubik.config.CodeConfig;
import org.free13.rubik.meta.model.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

/**
 * @author yuyang.13
 * @date 2024/08/08
 * @description Rubik startup class
 */
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
