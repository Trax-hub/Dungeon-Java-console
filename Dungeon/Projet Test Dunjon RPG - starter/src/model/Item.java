package model;

public class Item  {
    private String name;
	private int quantity;

    
    //Constructor
	/**
	 * This constructor creates an Item from a name and set its quantity to 1
	 * @param name Name
	 */
    public Item(String name) {
        super();
        this.name = name;
        this.quantity = 1;
    }

    //Getters & Setters
    public String getName() {
        return name;
    }

    public void setNom(String name) {
        this.name = name;
    }
    
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
    //Methods
	/**
	 * This method remove a unity from quatity of this Item
	 */
	public void remove() {
		setQuantity(getQuantity() - 1);
	}
	
	@Override
	public String toString() {
		return name;
	}
	

    
    

    
}