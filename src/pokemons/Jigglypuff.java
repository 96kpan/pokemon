package pokemons;

import java.awt.Image;
import java.io.Serializable;

public class Jigglypuff extends Pokemon implements Serializable{

	static int thisLevel = (int) (Math.random() * 10);
	static int thisHealth = (int) (Math.random() * 200)+100;
	static int thisRunProbs = (int) (Math.random() * 50);
	static Image thisPic = null; //NIVEN INSERT IMAGE HERE
	
	public Jigglypuff(){
		this(thisLevel, thisHealth, "Jigglypuff", "Fairy", false, thisRunProbs, thisPic);
	}
	
	public Jigglypuff(int level, int totalHealth, String pokemonName, String pokemonType, boolean capturedOrNot,
			int runProbs, Image pokemonPic) {
		super(level, totalHealth, pokemonName, pokemonType, capturedOrNot, runProbs, pokemonPic);
	}


}
