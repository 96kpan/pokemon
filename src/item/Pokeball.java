package item;

import model.Pokemon;

//This class is for the Pokeball, which IS-A Item.
//Pokeball has the ability to capture a pokemon.

public class Pokeball extends Item{
	private int itemNumber;
	private Pokemon pokemon;
	private int itemPrice;
	
	
	Pokeball(String itemName) {
		super("Pokeball");
	}

	public void setNumOfItems(int itemNumber) {
		super.setNumOfItems(itemNumber);
	}
	
	public void setPriceOfItems(int itemPrice){
		super.setPriceOfItems(100);
	}
	
	@Override
	public void useItem() {
		capturePokemon(pokemon);
	}

	//Need to edit the probability portion
	private void capturePokemon(Pokemon p) {
		int runProbability = p.getRunProbability();
		if(runProbability < 50){
			this.pokemon = p;
		}
	}
	

}
