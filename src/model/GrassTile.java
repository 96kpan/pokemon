package model;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Random;

import javax.swing.JOptionPane;

public class GrassTile extends Tile implements Serializable {

	public GrassTile(BufferedImage tileImage) {
		super(tileImage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void playerIsOnTile(PokemonGame game) {
		Random rand = new Random();
		int  randomNum = rand.nextInt(100);
		if(randomNum < 10) {
			game.launchBattle();
		}
		else if(randomNum >= 10 && randomNum <= 15) {
			game.acquireItem();
			JOptionPane.showMessageDialog(null, "Acquiring Item: " + game.getItemAdded());
		}
		
	}
	
	public String toString() {
		return "g";
	}

}
