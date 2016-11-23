package model;
// A tile for holding items
// Contains an item and playerIsOnTile should perform the right action based on the item.
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
