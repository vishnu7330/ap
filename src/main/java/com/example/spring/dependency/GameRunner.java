package com.example.spring.dependency;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

	private GameConsole game;

	public GameRunner(@Qualifier("superContraGame") GameConsole game) {
		this.game = game;

	}

	public void run() {
		System.out.println("game runner " + game);
		game.up();
		game.down();
		game.left();
		game.right();

	}

}
