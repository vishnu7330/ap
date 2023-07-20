package com.example.spring.dependency;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

// when we use component the instance of pacman game will be created by spring in background 
@Component
public class PacManGame implements GameConsole {

	public void up() {
		System.out.println("up");
	}

	public void down() {
		System.out.println("down");
	}

	public void left() {
		System.out.println("left");
	}

	public void right() {
		System.out.println("right");
	}

}
