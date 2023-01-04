package model;

public class AppleJuicePotion extends Potion{
	
    public static final int percentage = 10;
    private static final String nom= "Apple juice";

    
    //Constructor
    /**
     * this constructor create a Potion with a predefined percentage and a predefined name
     */
    public AppleJuicePotion() {
        super(nom, percentage);
    }
   
    //toString
	@Override
	public String toString() {
		return "AppleJuicePotion - ("+getQuantity()+")";
	}
    
    

}