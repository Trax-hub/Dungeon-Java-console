package model;

public class Armor extends Item{
    private int resistance;
    private boolean equiped;
    
    //Constructor
    /**
     * 
     * @param name Name
     * @param resistance Resistance
     * This constructor create an Armor thanks to a name and a resistance percentage
     */
    public Armor(String name,int resistance) {
        super(name);
        this.resistance = resistance;
        this.equiped = false;
    }
    
    //Getters & Setters
    public int getResistance() {
    	return resistance;
    }
    
    public boolean isEquiped() {
    	return equiped;
    }
    
    public void setEquiped(boolean equiped) {
    	this.equiped = equiped;
    }
}