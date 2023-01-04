package model;

public class WaterBottlePotion extends Potion{
    
    public static final int percentage = 5;
    private static final String name= "Water bottle";

    //Constructor
    /**
     * this constructor creates a WaterBottlePotion with a default name and a default regeneration percentage
     */
    public WaterBottlePotion() {
        super(name, percentage);
    }

}