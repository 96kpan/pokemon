package pokemons;

import java.awt.Image;
import java.io.Serializable;

public class Blaziken extends Pokemon implements Serializable {

	public Blaziken(int level, int totalHealth, String pokemonName, String pokemonType, boolean capturedOrNot,
			int runProbs, Image pokemonPic) {
		super(level, totalHealth, pokemonName, pokemonType, capturedOrNot, runProbs, pokemonPic);
	}


}
