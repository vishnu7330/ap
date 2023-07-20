package com.example.spring.dependency.examples.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class Someclass {
	private SomeDependency somedependency;

	public Someclass(SomeDependency somedependency) {
		super();
		this.somedependency = somedependency;
		System.out.println("All dependencies are ready");
	}

	// The <code>PostConstruct</code> annotation is used on a method that needs to
	// be executed after
	// dependency injection is done to perform any initialization. This method must
	// be invoked before
	// the class is put into service. This annotation must be supported on all
	// classes that support dependency injection.
	@PostConstruct
	public void intialize() {
		somedependency.getReady();
	}
	@PreDestroy
	public void predestroy() {
		System.out.println("intializer is closed");
	}
}

@Component
class SomeDependency {
	public void getReady() {
		System.out.println("some logic using dependencies");
	}
}

@Configuration
//Component scan will help to tell the spring to search  in the specific package 
@ComponentScan
public class PrepstAnnotationContextLauncher {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(PrepstAnnotationContextLauncher.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}

	}

}
