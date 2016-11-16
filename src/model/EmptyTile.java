package model;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class EmptyTile extends Tile {

	public EmptyTile(BufferedImage tileImage) {
		super(tileImage);
	}

	// do nothing because we are on an empty tile
	@Override
	public void playerIsOnTile(Game game) {}
	
	// here we return an e for an empty tile
	@Override
	public String toString() {
		return "e";
	}
	

}
