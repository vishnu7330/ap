package com.example.spring.dependency.examples.a0;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//Component scan will help to tell the spring to search  in the specific package 
@ComponentScan
public class SimpleSpringContextLauncher {

	public static void main(String[] args) {

		try(var context = new AnnotationConfigApplicationContext(SimpleSpringContextLauncher.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}

	}

}
