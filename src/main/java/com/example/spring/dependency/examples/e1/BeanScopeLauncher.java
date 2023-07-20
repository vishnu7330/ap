package com.example.spring.dependency.examples.e1;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class Normal{
	
}
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass{
	
}
@Configuration
//Component scan will help to tell the spring to search  in the specific package 
@ComponentScan
public class BeanScopeLauncher {

	public static void main(String[] args) {

		try(var context = new AnnotationConfigApplicationContext(BeanScopeLauncher.class)){
			
			System.out.println(context.getBean(Normal.class));
			System.out.println(context.getBean(Normal.class));
			
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
		}

	}

}
