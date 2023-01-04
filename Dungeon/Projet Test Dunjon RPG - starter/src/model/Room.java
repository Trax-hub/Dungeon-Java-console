package model;

public class Room {
	private String name;
	private Room westRoom;
	private Room eastRoom;
	private Room northRoom;
	private Room southRoom;
	private Enemy enemy;
	private Trap trap;
	private Chest chest;
	
	//Constructor
	/**
	 * This method creates a Room from a name
	 * @param name Name
	 */
	public Room(String name) {
		super();
		this.name = name;
	}

	//Getters & Setters
	public Room getWestRoom() {
		return westRoom;
	}
	
	public void setWestRoom(Room westRoom) {
		this.westRoom = westRoom;
	}
	
	public Enemy getEnemy() {
		return enemy;
	}
	
	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}


	public Room getEastRoom() {
		return eastRoom;
	}


	public void setEastRoom(Room eastRoom) {
		this.eastRoom = eastRoom;
	}


	public Room getNorthRoom() {
		return northRoom;
	}


	public void setNorthRoom(Room northRoom) {
		this.northRoom = northRoom;
	}


	public Room getSouthRoom() {
		return southRoom;
	}


	public void setSouthRoom(Room southRoom) {
		this.southRoom = southRoom;
	}
	
	public Trap getTrap() {
		return trap;
	}
	
	public void setTrap(Trap trap) {
		this.trap = trap;
	}
	
	public void setChest(Chest chest) {
		this.chest = chest;
	}
	
	public Chest getChest() {
		return chest;
	}

	//ToString
	@Override
	public String toString() {
		return name;
	}
	
	
	
	

	
	
	
	

}
