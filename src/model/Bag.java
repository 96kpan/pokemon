// Last updated: 11/15 2104
// [WORKING ON BY NIVEN FRANCIS; EDITED AND FINISHED BY KATIE PAN]

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

import java.io.Serializable;
import java.util.HashMap;

import javax.swing.JOptionPane;

import item.Axe;
import item.Bait;
import item.HealthPot;
import item.Item;
import item.Pokeball;

public class Bag implements Serializable {
	private int numItems;
	private static HashMap bag;

	// Creates a new bag with nothing in the backpack
	public Bag() {
		bag = new HashMap<String, Integer>();
		for(int i = 0; i < 31; i++) {
			this.addItem(new Pokeball(1));
		}
		this.addItem(new HealthPot("Health Pot", 1));
		this.addItem(new Bait("Bait", 1));
		this.addItem(new Axe(1));
	}

	// Adds item passed through parameters to the backpack
	// Won't add if there's no space left in backpack
	public void addItem(Item item) {
		String itemStr = item.getItemName();
		if(bag.containsKey(itemStr)){
			System.out.println("herhehrehrhherhhehr " + this.getNumOfPokeballs());
			int num = (int) bag.get(itemStr);
			bag.put(itemStr, num +1);
		}
		else{
			bag.put(itemStr, 0);
		}
	}
	

	// Removes given item from backpack and shifts array
	public void removeItem(String s) {
		System.out.println("ehrehhreherhehrh " + s);
		if(bag.containsKey((String) s) && getCountOfItems(s) > 0){
			int num = (int) bag.get((String)s);
			if(num == 0){
				JOptionPane.showMessageDialog(null, "You are out of" + s);
			}
			else{
				bag.put((String)s, num-1);

				System.out.println("fewaf" + bag.get((String) s));
			}
		}
	}
	
	//getter for number of pokeballs
	public int getNumOfPokeballs(){
		System.out.println(bag.get("Pokeball"));
		return (int) bag.get("Pokeball");
	}
	
	public int getCountOfItems(String s){
		if(this.bag.containsKey(s)){
			System.out.println(s);
			System.out.println("Contains " + bag.get(s));
			return (int) bag.get(s);
		}
		return 0; 
	}

	// uses given item from backpack and shifts array
	public void useItem(Item item) {
		this.removeItem(item.getItemName());
	}

	// Prints all current items in the trainer's backpack
	public String toString() {
		String str = "";
		
//		str += "Bait " + bag.get("Bait") + "\n";
//		str += "Health Pot " + (int) bag.get("Health Pot") + "\n";
//		str += "Pokeball " + bag.get("Pokeball") + "\n";
//		str += "Axes " + (int) bag.get("Axes");
		for(Object s : bag.keySet()){
			
			str += ""+ s + "s " + (int) bag.get((String) s) + "<br>";
				
			
			
			
		}
		return str+"</body></html>";
	}

	// Returns the number of items in the trainer's backpack	
	public int numItems() {

		
		int count = 0;
		for(Object s : bag.keySet()){
			count += getCountOfItems((String) s);
		}

		return count;
	}
}
