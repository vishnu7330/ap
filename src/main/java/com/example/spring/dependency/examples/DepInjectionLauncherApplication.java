package com.example.spring.dependency.examples;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBusiness {

	private Dependency1 dependency1;

	private Dependency2 dependency2;

	public YourBusiness(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}

	/*
	 * @Autowired public void setDependency1(Dependency1 dependency1) {
	 * System.out.println("Setter injection-depndency1"); this.dependency1 =
	 * dependency1; }
	 * 
	 * 
	 * 
	 * @Autowired public void setDependency2(Dependency2 dependency2) {
	 * System.out.println("Setter injection-depndency2"); this.dependency2 =
	 * dependency2; }
	 */

	@Override
	public String toString() {
		return "YourBusiness [dependency1=" + this.dependency1 + ", dependency2=" + this.dependency2 + "]";
	}

}

@Component
class Dependency1 {

}

@Component
class Dependency2 {

}

@Configuration
//Component scan will help to tell the spring to search  in the specific package 
@ComponentScan
public class DepInjectionLauncherApplication {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

			System.out.println(context.getBean(YourBusiness.class));
		}

	}

}
