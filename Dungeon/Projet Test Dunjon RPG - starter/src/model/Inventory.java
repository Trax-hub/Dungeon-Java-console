package model;

import java.util.*;

import view.Console;

public class Inventory {
	private ArrayList<Item> itemList = new ArrayList<Item>();
	private int nbDifferentItems = 0;
	private boolean open = false;

	//Constructors
	/**
	 * this constructor creates an empty inventory
	 */
	public Inventory() {
		super();
	}

	//Getters & Setters
	public int getNbDifferentItems() {
		return nbDifferentItems;
	}

	public void setNbDifferentItems(int nbItems) {
		this.nbDifferentItems = nbItems;
	}

	public ArrayList<Item> getItemList(){
		return itemList;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean bool) {
		open = bool;
	}

	public Item getItemN(int n) {
		return itemList.get(n);
	}

	//Methods
	/**
	 * This method add an Item in the Inventory
	 * @param item Item
	 */
	public void add(Item item) {
		if(item.getQuantity() > 1) {
			item.setQuantity(item.getQuantity() + 1);
		}
		else {
		itemList.add(item);
		setNbDifferentItems(getNbDifferentItems() + 1);
		}
	}

	/**
	 * This method remove an Item from the Inventory
	 * @param item Item
	 */
	public void remove(Item item){
		if(item.getQuantity() >= 1) {
			item.setQuantity(item.getQuantity() - 1);
		}
		else {
		itemList.remove(item.getQuantity());
		setNbDifferentItems(getNbDifferentItems() - 1);
		}
	}

	/**
	 * This method returns the size of the Inventory
	 * @return
	 */
	public int size() {
		return itemList.size();
	}



}