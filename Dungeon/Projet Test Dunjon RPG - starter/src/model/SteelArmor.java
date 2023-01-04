package model;

public class SteelArmor extends Armor{
    private static final int DEFAULT_RESISTANCE = 10;
    private static final String DEFAULT_NAME = "Steel armor";
    
    //Constructors
    /**
     * This constructor creates a SteelArmor with default name and a default resistance stat
     */
    public SteelArmor() {
        super(DEFAULT_NAME, DEFAULT_RESISTANCE);

    }

    //ToString
    @Override
    public String toString() {
        return ("Steel armor [10% damage reduction]" ); 
    }

    
    
}