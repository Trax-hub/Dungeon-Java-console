package model;

public class IronSword extends Sword{
    private static final int DAMAGE = 12;
    private static final String NAME= "Iron Sword";
    
    //Cosntructor
    /**
     * This constructor creates a IronSword with a defined name and defined damges
     */
    public IronSword() {
        super(NAME, DAMAGE);
    }

}