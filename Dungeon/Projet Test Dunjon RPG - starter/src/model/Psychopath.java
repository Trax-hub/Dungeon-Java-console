package model;

public class Psychopath extends Enemy {
	private static final String DEFAULT_NAME = "Psychopath";
	private static final double DEFAULT_HP = 40;
	private static final double DEFAULT_HP_MAX = 40;
	private static final double DEFAULT_ATTACK = 20;
	private static final double DEFAULT_DEFENSE = 0;
	
	//Constructor
	/**
	 * This constructor creates a Psychopath with a default name, a default HP, a default HP max, a default damages and a default defense stat
	 */
	public Psychopath() {
		super(DEFAULT_NAME, DEFAULT_HP, DEFAULT_HP_MAX, DEFAULT_ATTACK, DEFAULT_DEFENSE);
	}

	//ToString
	@Override
	public String toString() {
		return "Psychopath";
	}
	
}
