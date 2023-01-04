package model;

public class Potion extends Item {
	private int percentage;

	//Constructors
	/**
	 * This constructor creates a Potion from  name and a percentage of regeneration
	 * @param name Name
	 * @param percentage Percentage
	 */
	public Potion(String name, int percentage) {
		super(name);
		this.percentage = percentage;
	}

	//Getters & Setters
	public int getPercentage() {
		return percentage;
	}

	//Methods
	/**
	 * This method add an unit to the quantity of Potion
	 */
	public void addUnity() {
		setQuantity(getQuantity()+1);
	}
}