package com.example.spring.dependency;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// @primary is used when we have multiple bean dependencies to see a particular bean  
@Primary
public class MarioGame implements GameConsole {

	public void up() {
		System.out.println("jump");
	}

	public void down() {
		System.out.println("Go into the hole");
	}

	public void left() {
		System.out.println("backward");
	}

	public void right() {
		System.out.println("accelerate");
	}

}
