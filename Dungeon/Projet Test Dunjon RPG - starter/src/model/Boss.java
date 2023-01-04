package model;

public class Boss extends Enemy{
	private static final double DEFAULT_HP = 100;
	private static final double DEFAULT_HP_MAX = 100;
	private static final double DEFAULT_ATTACK_STAT = 15;
	private static final double DEFAULT_DEFENSE_STAT = 0;
	private static final String DEFAULT_NAME = "boss";
	
	//Constructors
	/**
	 * This constructor creates a Default Boss
	 */
	public Boss() {
		super(DEFAULT_NAME, DEFAULT_HP, DEFAULT_HP_MAX, DEFAULT_ATTACK_STAT, DEFAULT_DEFENSE_STAT);
	}
	
	/**
	 * This constructor create a boss with a special name
	 * @param name Name
	 */
	public Boss(String name) {
		super(name, DEFAULT_HP, DEFAULT_HP_MAX, DEFAULT_ATTACK_STAT, DEFAULT_DEFENSE_STAT);
	}

	@Override
	public String toString() {
		return getName();
	}
	
	

}
