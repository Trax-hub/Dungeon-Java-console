package model;

public class Nokia3310Armor extends Armor {
    private static final int DEFAULT_RESISTANCE = 100;
    private static final String DEFAULT_NAME = "Nokia 3310 armor";
    
    //Constructors
    /**
     * This constructor creates a Nokia3310Armor with a defined name and a defined resistance stat
     */
    public Nokia3310Armor() {
        super(DEFAULT_NAME, DEFAULT_RESISTANCE);
    }
    
    //ToString
    @Override
    public String toString() {
        return ("Nokia 3310 armor [100% damage reduction]" ); 
    }

    
    
}