package model;

import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

public class BossTile extends Tile {


	public BossTile(BufferedImage tileImage) {
		super(tileImage);
		super.canMove = true;
	}
	@Override
	public String toString() {
		return "B";
	}

	@Override
	public void playerIsOnTile(PokemonGame game) {
		int response = JOptionPane.showConfirmDialog(null, "Would you like to battle the trainer? He has an extremeyly rare pokemon. "
				+ "Beware he is spooked easily; if you dont battle him now he will run!");
		if(response == JOptionPane.YES_OPTION) {
			game.launchBattle(2);
			
		}
		else {
			game.trainer.setLocation(game.trainer.getLocation());
		}
		game.map.map[1][20] = new GrassTile(null);
		game.map.map[1][20].setHasTrainer(true);
		
		
	}

}
