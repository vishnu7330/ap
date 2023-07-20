package com.example.spring.dependency.examples.g1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;

@Component
class BusinessService{
	private DataService dataservice;
	
	public DataService getDataservice() {
		System.out.println("getter Injection");
		return dataservice;
	}
	//@Autowired
	
	// @Inject annotaion is used instead of @Autowire in CDI(Context and Dependency Injection)
	@Inject
	public void setDataservice(DataService dataservice) {
	System.out.println("setter Injection");
		this.dataservice = dataservice;
	}
	
}
//@Component
 // @named annotaion is used instead of @Component in CDI(Context and Dependency Injection) 
@Named
class DataService{
	
}
@Configuration
//Component scan will help to tell the spring to search  in the specific package 
@ComponentScan
public class CdiContextLauncher {

	public static void main(String[] args) {

		try(var context = new AnnotationConfigApplicationContext(CdiContextLauncher.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean(BusinessService.class).getDataservice());
		}

	}

}
