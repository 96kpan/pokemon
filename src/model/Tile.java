package model;

import java.awt.Image;

public abstract class Tile {
	private Image tileImage;
	
	public Tile(Image tileImage) {
		this.tileImage = tileImage;
	}
	
	public Image getImage() {
		return this.tileImage;
	}
	public abstract void playerIsOnTile(Game game);
	

}
