package com.example.spring.dependency;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//Component scan will help to tell the spring to search for the pacman game in the specific package 
@ComponentScan
public class GameAppLauncherApplication {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(GameAppLauncherApplication.class)) {
			context.getBean(GameConsole.class).up();
			context.getBean(GameRunner.class).run();
		} catch (BeansException e) {
			e.printStackTrace();
		}

	}

}
