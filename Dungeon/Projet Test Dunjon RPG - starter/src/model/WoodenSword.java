package model;

public class WoodenSword extends Sword{
    private static final int damage= 10;
    private static final String name = "Wooden Sword";
    
    //Cosntructor
    /**
     * This method creates a WoodenSword with a default name and default damages
     */
    public WoodenSword() {
        super(name, damage);
    }
}