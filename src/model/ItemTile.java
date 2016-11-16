package model;

import java.awt.Image;

import item.Item;

public class ItemTile extends Tile {
	private Item itemOnTile;
	
	
	public ItemTile(Image tileImage, Item itemOnTile) {
		super(tileImage);
		this.itemOnTile = itemOnTile;
	}
	@Override
	public void playerIsOnTile(Game game) {
		//game.getTrainer().acquireItem();
		
	}

}
