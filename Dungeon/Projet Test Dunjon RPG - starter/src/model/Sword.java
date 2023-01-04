package model;

public class Sword extends Item{
    private int damage;
    private boolean equiped;
    
    //Constructor
    /**
     * This constructor from a name and a number of damages
     * @param name Name
     * @param damage Damage
     */
    public Sword(String name, int damage) {
        super(name);
        this.damage = damage;
        this.equiped = false;
    }  

    //Getters & Setters
    public int getDamage() {
    	return damage;
    }
    
    public boolean isEquiped() {
    	return equiped;
    }
    
    public void setEquiped(boolean equiped) {
    	this.equiped = equiped;
    }
    
    //Methods
    /**
     * This method set the sword equiped
     */
    public void equip() {
    	setEquiped(true);
    }
    
    /**
     * This method set the sword unequiped
     */
    public void unequip() {
    	setEquiped(false);
    }
}