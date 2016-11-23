// Last updated: 1042
// A class that represents a model for the game map.
// This is represented by a double array of tile objects
// When the player lands on the tile objects the playerIsOnTile() method .
package model;

public abstract class PokemonMap {
	final int MAP_HEIGHT = 23;
	final int MAP_WIDTH = 23;
	protected Tile[][] map;
	public PokemonMap() {
		map = new Tile[MAP_HEIGHT][MAP_WIDTH];
	}
	
	public abstract void initMap();
	
	
}
