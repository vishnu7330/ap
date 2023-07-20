package com.example.spring.dependency.examples.h1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
//Component scan will help to tell the spring to search  in the specific package 
@ComponentScan
public class XmlConfigurationContextLauncher {

	public static void main(String[] args) {

		try (var context = new ClassPathXmlApplicationContext("ContextConfiguration.xml")) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}

	}

}
