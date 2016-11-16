// Last updated: 1042

package model;

public abstract class PokemonMap {
	final int MAP_HEIGHT = 25;
	final int MAP_WIDTH = 25;
	Tile[][] map;
	public PokemonMap() {
		map = new Tile[MAP_HEIGHT][MAP_WIDTH];
	}
	
	public abstract void initMap();
	
	
}
