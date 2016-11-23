package model;

import java.awt.image.BufferedImage;

public class TerrainTile extends Tile {
	private String terrainType;

	public TerrainTile(BufferedImage tileImage, String terrainType) {
		super(tileImage);
		this.terrainType = terrainType;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void playerIsOnTile(Game game) {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		return terrainType;
	}

}
