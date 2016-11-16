package model;

import java.awt.Image;
import java.awt.image.BufferedImage;

public abstract class Tile {
	private BufferedImage tileImage;
	
	public Tile(BufferedImage tileImage) {
		this.tileImage = tileImage;
	}
	
	public BufferedImage getImage() {
		return this.tileImage;
	}
	public abstract void playerIsOnTile(Game game);
	

}
