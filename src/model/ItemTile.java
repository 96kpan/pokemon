package model;

import java.awt.Image;
import java.awt.image.BufferedImage;

import item.Item;

public class ItemTile extends Tile {
	private Item itemOnTile;
	
	
	public ItemTile(BufferedImage tileImage, Item itemOnTile) {
		super(tileImage);
		this.itemOnTile = itemOnTile;
	}
	@Override
	public void playerIsOnTile(Game game) {
		//game.getTrainer().acquireItem();
		
	}

}
