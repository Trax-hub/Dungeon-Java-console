package model;

import view.Console;
import view.GameScreen;

public class Fight {
	private Player player;
	private Enemy enemy;
	private GameScreen screen;
	private int turn;
	
	//Constructors
	/**
	 * This Constructor creates a Fight between a Player and an Enemy
	 * @param player Player
	 * @param enemy Enemy
	 */
	public Fight(Player player, Enemy enemy) {
		super();
		this.player = player;
		this.enemy = enemy;
		this.turn = 1;
	}
	
	//Getters & Setters
	public int getTurn() {
		return turn;
	}
	
	public void addTurn() {
		turn++;
	}
	
	public Enemy getEnemy() {
		return enemy;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	//Methods
	/**
	 * This method start a fight
	 */
	public void start() {
		Console.displayln("A fight between you and "+enemy+" just started");
		player.setFighting(true);
		while(player.isAlive() && enemy.isAlive()){
			screen.showRound(turn);
			screen.showHp(enemy);
			screen.showHp(player);
			
			
			addTurn();
		}
	}
	
	/**
	 * This method check if the player is Fighting or not and set his Fighting boolean
	 */
	public void checkFight() {
		if(!player.isAlive() || !enemy.isAlive()) {
			player.setFighting(false);
		}
	}
	
	
}
