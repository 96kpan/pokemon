package model;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public class GrassTile extends Tile implements Serializable {

	public GrassTile(BufferedImage tileImage) {
		super(tileImage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void playerIsOnTile(PokemonGame game) {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		return "g";
	}

}
