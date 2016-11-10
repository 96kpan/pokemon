package model;

import java.awt.Image;

public class EmptyTile extends Tile {

	public EmptyTile(Image tileImage) {
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
