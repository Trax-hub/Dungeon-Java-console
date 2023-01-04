package model;

import java.util.Random;

public class Humanoid {
	private final double DEFAULT_HP = 50;
	private final double DEFAULT_HP_MAX = 50;
	private final double DEFAULT_ATTACK_STAT = 10;
	private final double DEFAULT_DEFENSE_STAT = 0;
	private final String DEFAULT_NAME = "Humanoid";
	
	private String name;
	private double hp;
	private double hpMax;
	private double attackStat;
	private double defenseStat;
	private boolean lastAttack = false; 		//it shows if the last attack was a critical attack
	
	//Contructors
	/**
	 * This constructor creates a Humanoid with a default name
	 */
	public Humanoid() {
		super();
		this.name = DEFAULT_NAME;
	}
	
	/**
	 * This constructor creates a Humanoid with a name
	 * @param name Name
	 */
	public Humanoid(String name) {
		super();
		this.name=name;
		this.hp = DEFAULT_HP;
		this.hpMax = DEFAULT_HP_MAX;
		this.attackStat = DEFAULT_ATTACK_STAT;
		this.defenseStat = DEFAULT_DEFENSE_STAT;
	}

	/**
	 * This constructor creates a Humanoid from a name, a number of HP, a number of HP max, a number of damages and a defense stat
	 * @param name Name
	 * @param hp HP
	 * @param hpMax HP maximum
	 * @param attackStat Damages for each attack
	 * @param defenseStat Percentage of damages blocked
	 */
	public Humanoid(String name, double hp, double hpMax, double attackStat, double defenseStat) {
		super();
		this.name = name;
		this.hp = hp;
		this.hpMax = hpMax;
		this.attackStat = attackStat;
		this.defenseStat = defenseStat;
	}
	
	//Getters & Setters
	public String getName() {
		return name;
	}

	public double getHp() {
		return hp;
	}

	public double getHpMax() {
		return hpMax;
	}

	public double getAttackStat() {
		return attackStat;
	}

	public double getDefenseStat() {
		return defenseStat;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHp(double d) {
		this.hp = d;
	}

	public void setHpMax(double hpMax) {
		this.hpMax = hpMax;
	}

	public void setAttackStat(double attackStat) {
		this.attackStat = attackStat;
	}

	public void setDefenseStat(double defenseStat) {
		this.defenseStat = defenseStat;
	}
	
	public boolean isAlive() {
		return getHp()>0;
	}
	
	public boolean getLastAttack() {
		return lastAttack;
	}
	
	//Methods
	/**
	 * This method make an attack between two Humanoid with a chance to do a critical attack
	 * @param humanoid Humanoid
	 */
	public void attack(Humanoid humanoid) {
		Random rn = new Random();
		int answer = rn.nextInt(10) + 1;
		
		//30% chance to make a critical hit
		if(answer < 3) {
			humanoid.suffer((getAttackStat() + (int) getAttackStat()*0.2) - (int) getAttackStat()*humanoid.getDefenseStat());   //it increase the attack by 20% in case of critical attack
			lastAttack = true;
		} 
		else {
			humanoid.suffer(getAttackStat() - (int) getAttackStat()*humanoid.getDefenseStat());
			lastAttack = false;
		}
	}
	
	/**
	 * This method make an Humanoid suffer (lost HP)
	 * @param damages Damages
	 */
	public void suffer(double damages) {
		setHp(getHp()-damages);
	}
	
	
	//toString
	@Override
	public String toString() {
		return name;
	}
	
	
	
	
	
	
}
