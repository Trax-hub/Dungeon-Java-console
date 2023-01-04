package model;

import java.util.ArrayList;

import view.Console;

public class Player extends Humanoid{
	private static final double DEFAULT_HP =100;
	private static final double DEFAULT_HP_MAX = 100;
	private static final double DEFAULT_ATTACK_STAT = 15;
	private static final double DEFAULT_DEFENSE_STAT = 0;
	private static final String DEFAULT_NAME = "Player";

	private Room currentLocation;
	private Room previousLocation;
	private boolean fighting;
	private Inventory inventory = new Inventory();
	private Armor armor;
	private Sword sword;


	//Constructors
	/**
	 * This constructor creates a Player with a default name, default HP, default HP maximum, default damages and a default resistance stat
	 */
	public Player() {
		super(DEFAULT_NAME, DEFAULT_HP, DEFAULT_HP_MAX, DEFAULT_ATTACK_STAT, DEFAULT_DEFENSE_STAT);
		this.fighting = false;
		this.sword = null;
		this.armor = null;
	}

	//Getters & Setters 
	public Room getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Room currentLocation) {
		this.currentLocation = currentLocation;
	}

	public Room getPreviousLocation() {
		return previousLocation;
	}

	public void setPreviousLocation(Room previousLocation) {
		this.previousLocation = previousLocation;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public boolean isFighting() {
		return fighting;
	}

	public void setFighting(boolean state) {
		fighting = state;
	}

	public void setSword(Sword sword) {
		this.sword = sword;
		if(sword != null) {
			setAttackStat(getAttackStat() + sword.getDamage());
		}

	}

	public void setArmor(Armor armor) {
		this.armor = armor;
		if(armor != null) {
			setDefenseStat(getDefenseStat() + getDefenseStat()*armor.getResistance()/100);
		}
	}

	public Armor getArmor() {
		return armor;
	}

	public Sword getSword() {
		return sword;
	}


	//Methods
	/**
	 * This method make the player go to the west Room
	 */
	public void goWest() {
		setPreviousLocation(currentLocation);
		setCurrentLocation(currentLocation.getWestRoom());

	}

	/**
	 * This method make the player go to the north Room
	 */
	public void goNorth() {
		setPreviousLocation(currentLocation);
		setCurrentLocation(currentLocation.getNorthRoom());
	}

	/**
	 * This method make the player go to the east Room
	 */
	public void goEast() {
		setPreviousLocation(currentLocation);
		setCurrentLocation(currentLocation.getEastRoom());
	}

	/**
	 * This method make the player go to the south Room
	 */
	public void goSouth() {
		setPreviousLocation(currentLocation);
		setCurrentLocation(currentLocation.getSouthRoom());
	}

	/**
	 * This method make the player drink a potion and increase his HP
	 */
	public void drink(Potion potion) {
		if(getHp()+getHp()*potion.getPercentage()/100 > getHpMax()) {
			setHp(getHpMax());
		}
		else {
			setHp(getHp()+getHp()*potion.getPercentage()/100);
		}
	}

	/**
	 * This method check if the player is fighing and set the boolean Fighting of the player
	 */
	public void checkFight() {
		if(currentLocation.getEnemy() != null && currentLocation.getEnemy().isAlive()) {
			setFighting(true);
		}
	}
	
	/**
	 * This method makes the player run away from a fight and go back to the previous room
	 */
	public void runAway() {
		setFighting(false);
		setCurrentLocation(previousLocation);
	}

	/**
	 * This method open the inventory
	 */
	public void openInventory() {
		inventory.setOpen(true);
	}

	/**
	 * This method close the inventory
	 */
	public void closeInventory() {
		inventory.setOpen(false);
	}

	/**
	 * This method allow the player to receive an Item in his Inventory
	 * @param item Item
	 */
	public void receiveItem(Item item) {
		inventory.add(item);
	}

	/**
	 * This method makes the player consume an AppleJuicePotion
	 */
	public void consumeAppleJuicePotion() {
		for(Item item : inventory.getItemList()) {
			if(item instanceof AppleJuicePotion) {
				item.remove();
				drink(new AppleJuicePotion());
			}
		}
	}

	/**
	 * This method makes the player consume an WaterBottlePotion
	 */
	public void consumeWaterBottlePotion() {
		for(Item item : inventory.getItemList()) {
			if(item instanceof WaterBottlePotion) {
				item.remove();
				drink(new WaterBottlePotion());
			}
		}
	}

	/**
	 * This method makes the player wear an Armor
	 */
	public void useArmor(Armor armor) {
		setDefenseStat(armor.getResistance());
		for(Item item : inventory.getItemList()) {
			if(item == armor && !armor.isEquiped()) {
				armor.setEquiped(true);
				setArmor(armor);
			}
		}
	}

	/**
	 * This method makes the player unwear an Armor
	 */
	public void unuseArmor(Armor armor) {
		setDefenseStat(DEFAULT_DEFENSE_STAT);
		armor.setEquiped(false);
		setArmor(null);
	}

	/**
	 * This method makes the player use a sword
	 */
	public void useSword(Sword sword) {
		for(Item item : inventory.getItemList()) {
			if(item == sword && !sword.isEquiped()) {
				sword.setEquiped(true);
				setSword(sword);
			}
		}
	}

	/**
	 * This method makes the player disarm his sword
	 */
	public void unuseSword(Sword sword) {
		setAttackStat(DEFAULT_ATTACK_STAT);
		sword.setEquiped(false);
		setSword(null);
	}
	
	/**
	 * This method makes the player open a chest and receive his content
	 */
	public void openChest(Chest chest) {
		inventory.add(chest.getItem());
	}




}
