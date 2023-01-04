package model;

public class CorkscrewSword extends Sword{
    private static final int DAMAGE = 5;
    private static final String NAME = "Corkscrew Sword";
    
    //Constructor
    /**
     * This constructor creates a CorksrewSword with defined damages and a defined name
     */
    public CorkscrewSword() {
        super(NAME, DAMAGE);
    }

}