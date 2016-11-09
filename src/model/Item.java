package model;

public abstract class Item {
	private String itemName;
	private int numOfItems;
	
	Item(String itemName){
		this.itemName=itemName;
	}
	
	public int getNumOfItems(String itemName){
		return numOfItems;
	}
	
	
	public abstract void useItem();  
	
	
	
	
}




