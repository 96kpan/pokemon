package pokemons;

import java.awt.Image;
import java.io.Serializable;

public class Lugia extends Pokemon implements Serializable {

	public Lugia(int level, int totalHealth, String pokemonName, String pokemonType, boolean capturedOrNot,
			int runProbs, Image pokemonPic) {
		super(level, totalHealth, pokemonName, pokemonType, capturedOrNot, runProbs, pokemonPic);
	}


}
