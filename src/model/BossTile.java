package model;

import java.awt.image.BufferedImage;

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
		game.launchBattle();
		
	}

}
