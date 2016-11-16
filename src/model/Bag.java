// Last updated: 11/15 2104
// [WORKING ON BY NIVEN FRANCIS]

/*
 * 						+-----------------------------------------------+
 * 						|				<VINIT LOOK HERE>				|
 * 						|												|
 * 						|			Make sure .getName() works			|
 * 						|		here and also the initializations		|
 * 						|			in the trainer tester class			|
 * 						|												|
 * 						+-----------------------------------------------+
 */

package model;

import item.Item;

public class Bag {
	private int numItems;
	private Item[] items;

	private final int MAX_ITEMS = 3;

	// Creates a new bag with nothing in the backpack
	public Bag() {
		numItems = 0;
		items = new Item[MAX_ITEMS];
	}

	// Adds item passed through parameters to the backpack
	// Won't add if there's no space left in backpack
	public void addItem(Item item) {
		if (numItems >= MAX_ITEMS) {
			System.out.println("Cannot add " + item.getItemName() + ". \n Reason: Backpack full.");
		} 
		else {
			items[numItems] = item;
			numItems++;
			System.out.println("Added " + item.getItemName() + " to backpack. \n Remaining slots: " + (MAX_ITEMS-numItems));
		}
	}
	
	// Removes given item from backpack and shifts array
	public void removeItem(Item item) {
		int index = 0;
		for(int x = 0; x < numItems; x++) {
			if(items[x] == item) {
				index = x;
				break;
			}
		}
		
		for(int x = index; x < numItems - 1; x++) {
			items[x] = items[x+1];
		}
		numItems--;
	}
	
	// Calls the useItem() method on the given item
	public void useItem(Item item) {
//		for(int x = 0; x < numItems; x++) {
//			if(items[x] == item) {
//				items[x].useItem();
//				break;
//			}
//		}
	}
	
	// Prints all current items in the trainer's backpack
	public void printItems() {
		if(numItems == 0)
			System.out.println("Nothing in backpack.");
		else
			System.out.print("Items in backpack: " + list() + "\n");
		
	}
	
	private String list() {
		String temp = null;
		for(int x = 0; x < numItems; x++) {
			temp = items[x].getItemName() + " ";
		}
		return temp;
	}

	// Returns the number of items in the trainer's backpack	
	public int numItems() {
		return numItems;
	}
}
