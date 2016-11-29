package pokemons;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

public class Pikachu extends Pokemon implements Serializable {

	static int thisLevel = (int) (Math.random() * 10);
	static int thisHealth = (int) (Math.random() * 200)+100;
	static int thisRunProbs = (int) (Math.random() * 50);
	static BufferedImage thisPic = null; //NIVEN INSERT IMAGE HERE
	
	try {
		thisPic = ImageIO.read(new File("images" + File.separator + "pokemon.png"));
	} catch (IOException e) {
		System.out.println("Can't find image");
	}
	
	public Pikachu(){
		this(thisLevel, thisHealth, "Pikachu", "Electric", false, thisRunProbs, thisPic.getSubimage(0, 10*32 , 32, 32));
	}
	
	public Pikachu(int level, int totalHealth, String pokemonName, String pokemonType, boolean capturedOrNot,
			int runProbs, Image pokemonPic) {
		super(level, totalHealth, pokemonName, pokemonType, capturedOrNot, runProbs, pokemonPic);
	}


}
