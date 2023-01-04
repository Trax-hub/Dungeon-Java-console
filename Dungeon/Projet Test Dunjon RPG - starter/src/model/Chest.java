package model;

public class Chest {
	private Item item;

	/**
	 * This constructor create an empty chest
	 */
	//Constructor
	public Chest() {
		super();
	}
	
	//Getters & Setters
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	
}
