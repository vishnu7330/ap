package com.example.spring.dependency;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier
public class SuperContraGame implements GameConsole {

	public void up() {
		System.out.println("jump");
	}

	public void down() {
		System.out.println("sit down");
	}

	public void left() {
		System.out.println("backward");
	}

	public void right() {
		System.out.println("shoot bullets");
	}

}
