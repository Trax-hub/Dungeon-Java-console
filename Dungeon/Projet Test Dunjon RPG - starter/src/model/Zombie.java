package model;

public class Zombie extends Enemy {
	private static final String DEFAULT_NAME = "Zombie";
	private static final double DEFAULT_HP = 30;
	private static final double DEFAULT_HP_MAX = 30;
	private static final double DEFAULT_ATTACK = 15;
	private static final double DEFAULT_DEFENSE = 0;
	
	//Constructor
	/**
	 * This constructor creates a Zombie with a default name, a default HP, a default HP max, a default damages and a default defense stat
	 */
	public Zombie() {
		super(DEFAULT_NAME, DEFAULT_HP, DEFAULT_HP_MAX, DEFAULT_ATTACK, DEFAULT_DEFENSE);
	}

	//ToString
	@Override
	public String toString() {
		return "Zombie";
	}
	
	
}
