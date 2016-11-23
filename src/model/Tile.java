package model;

import java.awt.Image;
import java.awt.image.BufferedImage;

public abstract class Tile {
	private BufferedImage tileImage;
	private boolean hasTrainer;
	protected boolean canMove;
	
	public Tile(BufferedImage tileImage) {
		this.tileImage = tileImage;
		this.hasTrainer = false;
		canMove = true;
	}
	
	public boolean canMove() {
		return this.canMove;
	}
	
	public BufferedImage getImage() {
		return this.tileImage;
	}
	
	public boolean getHasTrainer() {
		return hasTrainer;
	}
	
	public void setHasTrainer(boolean hasHunter) {
		this.hasTrainer = hasHunter;
	}
	public abstract void playerIsOnTile(Game game);
	

}
