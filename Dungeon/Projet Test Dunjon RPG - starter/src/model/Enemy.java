package model;

public class Enemy extends Humanoid{
	private Item item;

	/**
	 * This constructor creates an Enemy
	 * @param name Name
	 * @param hp HP
	 * @param hpMax HP maximum
	 * @param attackStat Damages for each attack
	 * @param defenseStat Percentage of damages blocked
	 */
	//Constructor
	public Enemy(String name, double hp, double hpMax, double attackStat, double defenseStat) {
		super(name, hp, hpMax, attackStat, defenseStat);
	}
	
	//Setters & Getters
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	//Methods
	public void dropItem(Player player) {
		player.receiveItem(getItem());
	}
	
	
}
