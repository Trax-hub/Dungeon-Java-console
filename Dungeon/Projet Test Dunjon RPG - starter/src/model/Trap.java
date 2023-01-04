package model;

public class Trap {
	private String name;
	private String message;
	private int damages;
	
	//Constructor
	/**
	 * This constructor creates a Trap from a name, a message and damages
	 */
	public Trap(String nom, String message, int damages) {
		super();
		this.name = nom;
		this.message = message;
		this.damages = damages;
	}

	//Getters & Setters
	public String getNom() {
		return name;
	}

	public String getMessage() {
		return message;
	}

	public int getDamages() {
		return damages;
	}
	
	//Methods
	/**
	 * This method trigger the trap on the Player
	 * @param player Player
	 */
	public void triggerOn(Player player) {
		player.suffer(damages);
		player.getCurrentLocation().setTrap(null);
	}
	

	
	
	
	
	
}
