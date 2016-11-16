// Last updated: 1042

package item;

public abstract class Item {
	private String itemName;
	private int numOfItems;
	private int price;
	
	Item(String itemName){
		this.itemName=itemName;
	}
	
	public int getNumOfItems(String itemName){
		return numOfItems;
	}
	
	public void setNumOfItems(int itemNumber){
		this.numOfItems += itemNumber;
	}
	
	public void setPriceOfItems(int itemPrice){
		this.price = itemPrice;
	}
	
	public int getPriceOfItems(int itemName){
		return price;
	}
	
	public abstract void useItem();  
	
}




