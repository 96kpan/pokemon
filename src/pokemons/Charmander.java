package pokemons;

import java.awt.Image;
import java.io.Serializable;

public class Charmander extends Pokemon implements Serializable {
	
	static int thisLevel = (int) (Math.random() * 10);
	static int thisHealth = (int) (Math.random() * 200)+100;
	static int thisRunProbs = (int) (Math.random() * 50);
	static Image thisPic = null; //NIVEN INSERT IMAGE HERE
	
	public Charmander(){
		this(thisLevel, thisHealth, "Charmander", "Fire", false, thisRunProbs, thisPic);
	}

	public Charmander(int level, int totalHealth, String pokemonName, String pokemonType, boolean capturedOrNot,
			int runProbs, Image pokemonPic) {
		super(level, totalHealth, pokemonName, pokemonType, capturedOrNot, runProbs, pokemonPic);
		// TODO Auto-generated constructor stub
	}


}
