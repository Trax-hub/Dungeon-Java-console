package model;

public class PaperboardArmor extends Armor{
    private static final int DEFAULT_RESISTANCE = 5;
    private static final String DEFAULT_NAME = "paperboard armor";
    
    //Constructors
    /**
     * This constructor creates a PaperboardArmor with a default name and a default resistance stat
     */
    public PaperboardArmor() {
        super(DEFAULT_NAME, DEFAULT_RESISTANCE);
        

    }

    //ToString
    @Override
    public String toString() {
        return ("Paperboard armor [5% damage reduction]" ); 
    }

    
    
}