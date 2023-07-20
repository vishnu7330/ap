package com.example.spring.dependency.examples.d1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class A {

}

@Component
// By using lazy annotation the intialization of classB bean will happen when someone is using ClassB  	
@Lazy
class B {
	private A classA;

	public B(A classA) {
		System.out.println("Some intialization logic goes here");
		this.classA = classA;
	}

	public void dosomething() {
		System.out.println("here we called classB");
	}
}

@Configuration
//Component scan will help to tell the spring to search  in the specific package 
@ComponentScan
public class LazyInitializationLauncher {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(LazyInitializationLauncher.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println("where the intializer is done");
		context.getBean(B.class).dosomething();

		}

	}

}
